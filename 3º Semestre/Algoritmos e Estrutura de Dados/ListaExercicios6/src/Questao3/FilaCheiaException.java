package Questao3;


public class FilaCheiaException extends RuntimeException{

    public FilaCheiaException() {
        super("Fila cheia!");
    }

    public FilaCheiaException(String msg) {
        super(msg);
    }
}
