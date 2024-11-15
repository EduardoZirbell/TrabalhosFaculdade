import Questao1.FilaVetor;

public class Main {
    public static void main(String[] args) {
        FilaVetor<String> fila1 = new FilaVetor<>(5);
        FilaVetor<String> fila2 = new FilaVetor<>(5);
        fila1.inserir("5");
        fila1.inserir("10");
        fila1.inserir("15");
        fila1.inserir("20");
        System.out.println("Retirando da lista 1: "+fila1.retirar());
        System.out.println("Retirando da lista 1: "+fila1.retirar());

        fila2.inserir("20");
        fila2.inserir("15");
        fila2.inserir("10");
        fila2.inserir("5");
        System.out.println("Retirando da lista 2: "+fila2.retirar());
        FilaVetor<String> fila3 = fila1.criarFilaConcatenada(fila2);
        System.out.println(fila3.toString());
    }
}