package Questao2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();
        System.out.println("Informe a altura da pessoa: ");
        pessoa.altura = sc.nextDouble();
        System.out.println("Informe o peso da pessoa: ");
        pessoa.peso = sc.nextDouble();
        
        System.out.println("O IMC da pessoa é: " + pessoa.calcularIMC());
    }
}
