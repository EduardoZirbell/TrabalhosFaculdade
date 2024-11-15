package listaexercicios31;

import java.util.Objects;

public class ListaEncadeada<Publicacao> {

    private NoLista<Publicacao> primeiro;

    /**
     * Getter da variável primeiro
     *
     * @return Primeiro valor da lista
     */
    public NoLista<Publicacao> getPrimeiro() {
        return this.primeiro;
    }

    /**
     * Insere um novo valor na lista
     *
     * @param info Valor a ser inserido na lista
     */
    public void inserir(Publicacao info) {
        NoLista<Publicacao> novo = new NoLista<>();
        novo.setInfo(info);
        novo.setProximo(getPrimeiro());
        this.primeiro = novo;
    }

    /**
     * Avalia se a lista está vazia ou não
     *
     * @return true se a lista estiver vazia
     */
    public boolean estaVazia() {
        return this.primeiro == null;
    }

    /**
     * Busca um elemento na lista encadeada
     *
     * @param info Dado a ser localizado
     * @return Elemento contendo o dado localizado
     */
    public NoLista<Publicacao> buscar(Publicacao info) {
        NoLista<Publicacao> atual = getPrimeiro();
        while (atual != null) {
            if (atual.getInfo().equals(info)) {
                return atual;
            }
            atual = atual.getProximo();
        }

        return null;
    }

    /**
     * Retira um dado da lista encadeada
     *
     * @param valor passado como parâmetro para ser retirado da lista encadeada
     */
    public void retirar(Publicacao valor) {
        NoLista<Publicacao> anterior = null;
        NoLista<Publicacao> atual = getPrimeiro();

        while ((atual != null) && (!atual.getInfo().equals(valor))) {
            anterior = atual;
            atual = atual.getProximo();
        }

        if (atual != null) {
            if (atual == primeiro) {
                primeiro = atual.getProximo();
            } else {
                anterior.setProximo(atual.getProximo());
            }
        }
    }

    /**
     * Calcula a quantidade de nós da lista
     *
     * @return quantidade de elementos da lista
     */
    public int obterComprimento() {
        int qtdeNos = 0;

        NoLista<Publicacao> atual = getPrimeiro();

        while (atual != null) {
            qtdeNos++;
            atual = atual.getProximo();
        }

        return qtdeNos;
    }

    public NoLista<Publicacao> obterNo(int posicao) {
        if ((posicao < 0) || (posicao > obterComprimento() - 1)) {
            throw new IllegalArgumentException("Indice não existe");
        }

        NoLista<Publicacao> p = getPrimeiro();
        for (int i = 0; i < posicao; i++) {
            p = p.getProximo();
        }

        return p;
    }

    public void exibir() {
        NoLista<Publicacao> atual = primeiro;
        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getProximo();
        }
    }

    @Override
    public String toString() {
        String resultado = "";
        NoLista<Publicacao> atual = getPrimeiro();

        while (atual != null) {
            if (atual != getPrimeiro()) {
                resultado += ",";
            }

            resultado += atual.getInfo().toString();
            atual = atual.getProximo();
        }

        return resultado;
    }
}
