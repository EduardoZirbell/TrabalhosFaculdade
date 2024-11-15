package Questao1;


public class PilhaVetor<T> implements Pilha<T> {

    private T info[];
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        info = (T[]) new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
    }

    @Override
    public void push(T info) {
        if (limite == tamanho) {
            throw new PilhaCheiaException();
        }
        this.info[tamanho] = info;
        tamanho++;
    }

    @Override
    public T pop() {
        T valor;
        if (estaVazia()) {
            throw new PilhaVaziaException();
        } else {
            valor = peek();
            tamanho--;
        }
        return valor;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
        return info[tamanho - 1];
    }

    @Override
    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    @Override
    public void liberar() {
        info = (T[]) new Object[limite];
        tamanho = 0;
    }

    public void concatenar(PilhaVetor<T> p) {
        int capacidadeTotal = this.tamanho + p.tamanho;
        if (capacidadeTotal > this.limite) {
            throw new RuntimeException("Listas concatenadas excedem o limite da lista.");
        }

        for (int i = 0; i < p.tamanho; i++) {
            this.info[this.tamanho + i] = p.info[i];
        }

        this.tamanho = capacidadeTotal;
    }

    @Override
    public String toString() {
        String resultado = "[";
        for (int i = 0; i < tamanho; i++) {
            resultado += info[i];
            if (i < tamanho - 1) {
                resultado += ", ";
            }
        }
        resultado += "]";
        return resultado;
    }
}
