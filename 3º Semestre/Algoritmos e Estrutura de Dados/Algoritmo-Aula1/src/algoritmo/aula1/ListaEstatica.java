package algoritmo.aula1;

public class ListaEstatica {

    private int[] lista;
    private int tamanhoOcupado;

    public ListaEstatica() {
        lista = new int[10];
        tamanhoOcupado = 0;
    }

    public void inserir(int valor) {
        if (tamanhoOcupado == lista.length) {
            redimensionar();
        }
        lista[tamanhoOcupado] = valor;
        tamanhoOcupado++;
    }

    public void redimensionar() {
        int[] listaAuxiliar = new int[lista.length + 10];

        for (int i = 0; i < lista.length; i++) {
            listaAuxiliar[i] = lista[i];
        }

        lista = listaAuxiliar;
    }

    public int buscar(int valor) {
        for (int i = 0; i < tamanhoOcupado; i++) {
            if (valor == lista[i]) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(int valor) {
        int posicao = buscar(valor);

        if (posicao > -1) {
            for (int i = 0; i < tamanhoOcupado; i++) {
                lista[i] = lista[i + 1];
            }
            tamanhoOcupado--;
        }
    }

    public int getTamanhoOcupado() {
        return tamanhoOcupado;
    }

    @Override
    public String toString() {
        String resultado = "";

        for (int i = 0; i < tamanhoOcupado; i++) {
            if (i > 0) {
                resultado += ",";
            }
            resultado += lista[i];
        }

        return resultado;
    }
}
