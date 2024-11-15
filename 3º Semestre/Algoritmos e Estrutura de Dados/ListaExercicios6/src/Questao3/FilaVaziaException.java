package Questao3;


public class FilaVaziaException extends RuntimeException{

    public FilaVaziaException() {
        super("Fila vazia!");
    }

    public FilaVaziaException(String msg) {
        super(msg);
    }
}
