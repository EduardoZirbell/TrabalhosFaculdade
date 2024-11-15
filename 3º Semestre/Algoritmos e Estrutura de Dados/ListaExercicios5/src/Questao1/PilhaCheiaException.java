package Questao1;


public class PilhaCheiaException extends RuntimeException{

    public PilhaCheiaException() {
        super("Capacidade esgotada da pilha!");
    }

    public PilhaCheiaException(String msg) {
        super(msg);
    }
}
