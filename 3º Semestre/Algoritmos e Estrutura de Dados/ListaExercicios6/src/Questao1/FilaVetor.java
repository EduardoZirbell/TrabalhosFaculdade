package Questao1;

public class FilaVetor<T> implements Fila<T> {
    private T info[];
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite){
        this.info = (T[]) new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
        this.inicio = 0;
    }

    @Override
    public void inserir(T valor){
        if(this.tamanho == this.limite){
            throw new FilaCheiaException();
        }
        int posicaoInserir;
        posicaoInserir = (this.inicio + this.tamanho) % this.limite;
        this.info[posicaoInserir] = valor;
        this.tamanho++;
    }
    @Override
    public boolean estaVazia(){
        return this.tamanho == 0;
    }
    @Override
    public T peek(){
        if(estaVazia()){
            throw new FilaVaziaException();
        }
        return this.info[this.inicio];
    }
    @Override
    public T retirar(){
        T valor = peek();

        this.inicio = (this.inicio + 1) % this.limite;
        this.tamanho--;
        return valor;
    }
    @Override
    public void liberar(){
        this.info = (T[]) new Object[this.limite];
        this.tamanho = 0;
        this.inicio = 0;
    }
    public int getLimite(){
        return this.limite;
    }
    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> filaVetor2){
        int limiteFila3 = this.getLimite() + filaVetor2.getLimite();
        FilaVetor<T> filaVetor3 = new FilaVetor<T>(limiteFila3);
        for(T i: this.info){
            if (i != null){
                filaVetor3.inserir(i);
            }
        }
        for(T i: filaVetor2.info){
            if (i != null) {
                filaVetor3.inserir(i);
            }
        }
        return filaVetor3;
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
