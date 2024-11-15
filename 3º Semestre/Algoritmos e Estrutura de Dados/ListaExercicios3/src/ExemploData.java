package exercicios.lista03;

import java.time.LocalDate;

public class ExemploData {

    public static void main(String[] args) {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inserir(20);
        lista.inserir(40);
        lista.retirar(20);
        lista.inserir(50);
        lista.inserir(60);

        System.out.println(lista.getPrimeiro().getInfo());

    }

}
