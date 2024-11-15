package Questao1;


public class PilhaVaziaException extends RuntimeException {

    public PilhaVaziaException() {
        super("Pilha está vazia!");
    }

    public PilhaVaziaException(String msg) {
        super(msg);
    }
}
