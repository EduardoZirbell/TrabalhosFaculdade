from Crypto.Cipher import Blowfish
from Crypto.Util import Padding
import os
import sys

# --- Configurações ---
TAMANHO_BLOCO = 8  # Blowfish sempre usa blocos de 8 bytes
CHAVE = b"ABCDE"   # chave pedida no enunciado

# --- Funções utilitárias ---
def aplicar_padding(dados: bytes) -> bytes:
    """Aplica PKCS#5 (equivalente ao PKCS#7 com bloco de 8)."""
    return Padding.pad(dados, TAMANHO_BLOCO, style='pkcs7')

def remover_padding(dados: bytes) -> bytes:
    """Remove PKCS#5."""
    return Padding.unpad(dados, TAMANHO_BLOCO, style='pkcs7')

def em_hex(dados: bytes, grupo: int = 8) -> str:
    """Formata bytes em hex, quebrando a cada 'grupo' bytes."""
    h = ['{:02X}'.format(x) for x in dados]
    return '\n'.join(' '.join(h[i:i+grupo]) for i in range(0, len(h), grupo))

def para_texto(dados: bytes) -> str:
    """Tenta decodificar em UTF-8, caso contrário indica binário."""
    try:
        return dados.decode('utf-8')
    except Exception:
        return "<binário - não UTF-8>"

# --- Modos ECB e CBC ---
def cifrar_ecb(plaintext: bytes, chave: bytes) -> bytes:
    c = Blowfish.new(chave, Blowfish.MODE_ECB)
    return c.encrypt(aplicar_padding(plaintext))

def decifrar_ecb(ciphertext: bytes, chave: bytes) -> bytes:
    c = Blowfish.new(chave, Blowfish.MODE_ECB)
    return remover_padding(c.decrypt(ciphertext))

def cifrar_cbc(plaintext: bytes, chave: bytes, iv: bytes) -> bytes:
    c = Blowfish.new(chave, Blowfish.MODE_CBC, iv)
    return c.encrypt(aplicar_padding(plaintext))

def decifrar_cbc(ciphertext: bytes, chave: bytes, iv: bytes) -> bytes:
    c = Blowfish.new(chave, Blowfish.MODE_CBC, iv)
    return remover_padding(c.decrypt(ciphertext))

# --- Execução dos casos ---
def main(arquivo_pdf: str = "L06 - Criptografia Blowfish (v3).pdf"):
    print("=== Exercícios Blowfish ===\n")
    print(f"Chave usada: {list(CHAVE)} -> '{CHAVE.decode('latin1')}'\n")

    # Caso 1
    c1 = cifrar_ecb(b"FURB", CHAVE)
    print("Caso 1 - 'FURB' (ECB):")
    print(em_hex(c1), "\n")

    # Caso 2
    c2 = cifrar_ecb("COMPUTADOR".encode(), CHAVE)
    print("Caso 2 - 'COMPUTADOR' (ECB):")
    print(em_hex(c2))
    print(f"Tamanho: {len(c2)} bytes (múltiplo de 8 por causa do padding)\n")

    # Caso 3
    c3 = cifrar_ecb("SABONETE".encode(), CHAVE)
    print("Caso 3 - 'SABONETE' (ECB):")
    print(em_hex(c3), "\n")

    # Caso 4
    c4 = cifrar_ecb(bytes([8]*8), CHAVE)
    print("Caso 4 - bloco [8]*8 (ECB):")
    print(em_hex(c4))
    print("Comparação último bloco do Caso 3 vs. bloco do Caso 4:")
    print("Igual" if c4[:8] == c3[-8:] else "Diferente", "\n")

    # Caso 5
    texto5 = "SABONETESABONETESABONETE".encode()
    c5 = cifrar_ecb(texto5, CHAVE)
    print("Caso 5 - texto repetido (ECB):")
    print(em_hex(c5))
    print("Observação: ECB mostra blocos repetidos no cifrado.\n")

    # Caso 6
    iv0 = bytes([0]*8)
    c6 = cifrar_cbc(b"FURB", CHAVE, iv0)
    print("Caso 6 - 'FURB' (CBC, IV=0):")
    print(em_hex(c6))
    try:
        print("Decifrado com IV errado:", para_texto(decifrar_cbc(c6, CHAVE, bytes([1]*8))))
    except Exception:
        print("Decifrado com IV errado: falha (padding inválido)")
    print("Decifrado com IV correto:", para_texto(decifrar_cbc(c6, CHAVE, iv0)), "\n")

    # Caso 7
    iv7 = bytes([1,1,2,2,3,3,4,4])
    c7 = cifrar_cbc(b"FURB", CHAVE, iv7)
    print("Caso 7 - 'FURB' (CBC, IV=[1,1,2,2,3,3,4,4]):")
    print(em_hex(c7), "\n")

    # Caso 8
    c8 = cifrar_cbc(texto5, CHAVE, iv7)
    print("Caso 8 - texto repetido (CBC, IV=[1,1,2,2,3,3,4,4]):")
    print(em_hex(c8))
    print("Observação: CBC quebra padrões repetidos.\n")

    # Caso 9
    iv9a = bytes([10,20,30,40,50,60,70,80])
    c9a = cifrar_cbc(texto5, CHAVE, iv9a)
    print("Caso 9 - mesmo texto, IV diferente (CBC):")
    print("IV A:", em_hex(c9a))
    try:
        print("Decifrado com IV errado:", para_texto(decifrar_cbc(c9a, CHAVE, iv7)))
    except Exception:
        print("Decifrado com IV errado: falha\n")

    # Caso 10
    c10 = cifrar_ecb(b"FURB", CHAVE)
    print("\nCaso 10 - 'FURB' (ECB) com chave errada:")
    print(em_hex(c10))
    try:
        print("Decifrado com chave errada:", para_texto(decifrar_ecb(c10, b"11111")))
    except Exception:
        print("Falha ao decifrar com chave errada (padding inválido)\n")

    # Caso 11 & 12
    print("Caso 11/12 - Criptografar PDF e verificar...")
    if not os.path.exists(arquivo_pdf):
        print(f"Arquivo PDF não encontrado: {arquivo_pdf}")
        return
    with open(arquivo_pdf, "rb") as f:
        dados = f.read()
    c = Blowfish.new(CHAVE, Blowfish.MODE_ECB)
    dados_cif = c.encrypt(aplicar_padding(dados))
    with open("saida.bin", "wb") as f:
        f.write(dados_cif)
    print("Arquivo criptografado salvo: saida.bin")
    c2 = Blowfish.new(CHAVE, Blowfish.MODE_ECB)
    dados_dec = remover_padding(c2.decrypt(dados_cif))
    with open("descriptografado.pdf", "wb") as f:
        f.write(dados_dec)
    print("Arquivo descriptografado salvo: descriptografado.pdf")

if __name__ == "__main__":
    if len(sys.argv) > 1:
        main(sys.argv[1])
    else:
        main()
