package listaexercicios31;

import java.util.Objects;

public class NoLista<Publicacao> {

    private Publicacao info;
    private NoLista<Publicacao> proximo;

    public Publicacao getInfo() {
        return info;
    }

    public void setInfo(Publicacao info) {
        this.info = info;
    }

    public NoLista<Publicacao> getProximo() {
        return proximo;
    }

    public void setProximo(NoLista<Publicacao> proximo) {
        this.proximo = proximo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NoLista<?> other = (NoLista<?>) obj;
        return Objects.equals(this.info, other.info);
    }

}
