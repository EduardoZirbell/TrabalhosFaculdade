package Questao1;

public class ListaEstatica {

    private int[] info;
    private int tamanho;

    public ListaEstatica() {
        info = new int[10];
        tamanho = 0;
    }

    public void inserir(int valor) {
        if (tamanho == info.length) {
            redimensionar();
        }

        int posicao = 0;
        while (posicao < tamanho && info[posicao] < valor) {
            posicao++;
        }

        for (int i = tamanho; i > posicao; i--) {
            info[i] = info[i - 1];
        }

        info[posicao] = valor;
        tamanho++;
    }

    private void redimensionar() {
        int[] novoInfo = new int[info.length + 10];

        for (int i = 0; i < info.length; i++) {
            novoInfo[i] = info[i];
        }

        info = novoInfo;
    }

    public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            int valor = info[i];
            System.out.println("[" + i + "]: " + valor);
        }
    }

    public int buscar(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (valor == info[i]) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(int valor) {
        int posicao = buscar(valor);
        if (posicao > -1) {
            for (int i = posicao; i < tamanho; i++) {
                info[i] = info[i + 1];
            }
            tamanho--;
        }
    }

    public void liberar() {
        info = new int[10];
        tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int obterElemento(int posicao) {
        if (posicao >= 0 && posicao < tamanho) {
            return info[posicao];
        }
        throw new IndexOutOfBoundsException();
    }

    public boolean estarVazia() {
        if (tamanho > 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        String resultado = "";

        for (int i = 0; i < tamanho; i++) {
            if (i > 0) {
                resultado += ",";
            }
            resultado += info[i];
        }

        return resultado;
    }

}
