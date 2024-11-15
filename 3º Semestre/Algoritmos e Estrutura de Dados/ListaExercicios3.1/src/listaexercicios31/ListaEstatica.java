package listaexercicios31;

import java.util.Arrays;

public class ListaEstatica {

    private Aluno[] info;
    private int tamanho;

    public ListaEstatica() {
        info = new Aluno[10];
        tamanho = 0;
    }

    private void redimensionar() {
        Aluno[] novoInfo = new Aluno[info.length + 10];
        for (int i = 0; i < info.length; i++) {
            novoInfo[i] = info[i];
        }
        info = novoInfo;
    }

    public void inserir(Aluno valor) {
        if (tamanho == info.length) {
            redimensionar();
        }
        info[tamanho] = valor;

        tamanho++;
    }

    public void exibir() {
        for (int indice = 0; indice < tamanho; indice++) {
            Aluno valor = info[indice];
            System.out.println(valor);
        }
    }

    public int buscar(String nome) {
        for (int indice = 0; indice < tamanho; indice++) {
            Aluno valorLista = info[indice];
            if (valorLista.getNome().equals(nome)) {
                return indice;
            }
        }
        return -1;
    }

    public void retirar(String nome) {
        int indice = buscar(nome);
        if (indice > -1) {
            for (int indiceFor = indice; indiceFor < tamanho - 1; indiceFor++) {
                info[indiceFor] = info[indiceFor + 1];
            }
        }
        tamanho--;
    }

    public void liberar() {
        info = new Aluno[10];
        tamanho = 0;
    }

    public Aluno obterElemento(int posicao) {
        if (posicao >= 0 && (posicao < tamanho)) {
            return info[posicao];
        }
        throw new IndexOutOfBoundsException();
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        String resultado = "";
        for (int indice = 0; indice < tamanho; indice++) {
            if (indice > 0) {
                resultado += ", ";
            }
            Aluno valor = info[indice];
            resultado += valor.toString();
        }
        return resultado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Arrays.deepHashCode(this.info);
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
        final ListaEstatica other = (ListaEstatica) obj;
        return Arrays.deepEquals(this.info, other.info);
    }

}
