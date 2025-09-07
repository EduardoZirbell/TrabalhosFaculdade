from fastapi import FastAPI, Depends, HTTPException, status
from sqlalchemy import Column, Integer, String, create_engine
from sqlalchemy.orm import sessionmaker, Session, declarative_base
from pydantic import BaseModel
import time
import asyncio

# Configuração do banco de dados
DATABASE_URL = "sqlite:///./users.db"
engine = create_engine(DATABASE_URL, connect_args={"check_same_thread": False})
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)
Base = declarative_base()

# Modelo de Usuário no banco
class User(Base):
    __tablename__ = "users"
    id = Column(Integer, primary_key=True, index=True)
    username = Column(String, unique=True, index=True)
    password = Column(String)
    email = Column(String)
    failed_attempts = Column(Integer, default=0)
    lock_until = Column(Integer, default=0)  # timestamp em segundos
    last_failed = Column(Integer, default=0) # timestamp do último erro

# Cria as tabelas
Base.metadata.create_all(bind=engine)

app = FastAPI()

# Models Pydantic para receber JSON
class RegisterRequest(BaseModel):
    username: str
    email: str
    password: str

class LoginRequest(BaseModel):
    username: str
    password: str

# Dependência para o banco
def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

# Rota de registro
@app.post("/register/")
def register_user(request: RegisterRequest, db: Session = Depends(get_db)):
    # Verifica se usuário já existe
    if db.query(User).filter_by(username=request.username).first():
        raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST, detail="Usuário já existe")
    user = User(username=request.username, email=request.email, password=request.password)
    db.add(user)
    db.commit()
    db.refresh(user)
    return {"message": "Usuário registrado com sucesso!"}

# Rota de login
@app.post("/login/")
async def login(request: LoginRequest, db: Session = Depends(get_db)):
    user = db.query(User).filter_by(username=request.username).first()
    now = int(time.time())
    if not user:
        await asyncio.sleep(1)  # atraso mínimo para evitar brute force
        raise HTTPException(status_code=status.HTTP_401_UNAUTHORIZED, detail="Credenciais inválidas")

    # Bloqueio temporário
    if user.lock_until and now < user.lock_until:
        wait = user.lock_until - now
        raise HTTPException(status_code=status.HTTP_403_FORBIDDEN, detail=f"Conta bloqueada. Tente novamente em {wait} segundos.")

    # Verifica senha
    if user.password != request.password:
        # Atraso progressivo
        user.failed_attempts += 1
        user.last_failed = now
        delay = min(2 ** user.failed_attempts, 30)  # máximo 30s
        await asyncio.sleep(delay)
        # Bloqueia após 3 tentativas
        if user.failed_attempts >= 3:
            user.lock_until = now + 60  # bloqueia por 1 minuto
            db.commit()
            raise HTTPException(status_code=status.HTTP_403_FORBIDDEN, detail="Conta bloqueada por múltiplas tentativas. Tente novamente em 60 segundos.")
        db.commit()
        raise HTTPException(status_code=status.HTTP_401_UNAUTHORIZED, detail="Credenciais inválidas")

    # Login bem-sucedido: reseta tentativas
    user.failed_attempts = 0
    user.lock_until = 0
    db.commit()
    return {"message": "Login realizado com sucesso!"}
