package Questao3;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            Pessoa pessoa = new Pessoa();
            System.out.println("Informe a altura "+(i+1)+"ª da pessoa: ");
            pessoa.altura = sc.nextDouble();
            System.out.println("Informe o peso "+(i+1)+"ª da pessoa: ");
            pessoa.peso = sc.nextDouble();
            System.out.println("O IMC da "+(i+1)+"ª pessoa é: " + pessoa.calcularIMC());
        }
    }
}
