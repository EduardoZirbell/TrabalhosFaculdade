package listaexercicios4;

public class ListaDupla<T> {

    private NoListaDupla<T> primeiro;

    public ListaDupla() {
        this.primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro() {
        return this.primeiro;
    }

    public void inserir(T valor) {
        NoListaDupla<T> novo = new NoListaDupla<>();
        novo.setInfo(valor);
        novo.setProximo(getPrimeiro());
        novo.setAnterior(null);
        if (primeiro != null) {
            this.primeiro.setAnterior(novo);
        } else {
            this.primeiro = novo;
        }
    }

    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> atual = getPrimeiro();
        while (atual != null) {
            if (atual.getInfo().equals(valor)) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void retirar(T valor) {
        NoListaDupla<T> atual = buscar(valor);

    }

    public void exibirOrdemInversa() {
        NoListaDupla<T> atual = primeiro;
        NoListaDupla<T> ultimo = null;
        while (atual != null) {
            if (atual.getProximo() == null) {
                ultimo = atual;
            }
            atual = atual.getProximo();
        }
        while (ultimo != null) {
            System.out.println(ultimo.getInfo());
            ultimo = ultimo.getAnterior();
        }

    }

    public void liberar() {
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            NoListaDupla<T> proximo = atual.getProximo();
            atual.setProximo(null);
            atual.setAnterior(null);
            atual = proximo;
        }
        primeiro = null;
    }

    @Override
    public String toString() {
        String resultado = "";
        NoListaDupla<T> atual = getPrimeiro();

        while (atual != null) {
            if (atual != getPrimeiro()) {
                resultado += ",";
            }

            resultado += atual.getInfo().toString();
            atual = atual.getProximo();
        }

        return resultado;
    }

    public ListaDupla<T> clonar() {
        ListaDupla<T> listaNova = new ListaDupla<>();

        NoListaDupla<T> atual = this.primeiro;
        while (atual != null) {
            listaNova.inserir(atual.getInfo());
            atual = atual.getAnterior();
        }
        
        return listaNova;
    }
}
