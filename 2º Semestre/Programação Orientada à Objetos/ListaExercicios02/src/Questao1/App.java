package Questao1;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pessoa[] pessoas = new Pessoa[3];
        for (int i = 0; i < pessoas.length; i++) {
            Pessoa pessoa = new Pessoa();
            System.out.println("Informe a altura "+(i+1)+"ª da pessoa: ");
            pessoa.setAltura(sc.nextDouble());
            System.out.println("Informe o peso "+(i+1)+"ª da pessoa: ");
            pessoa.setPeso(sc.nextDouble());
            pessoas[i] = pessoa;
        }
        
        for (int i = pessoas.length-1; i >= 0; i--) {
            System.out.println("O IMC da "+(i+1)+"ª pessoa é: " + pessoas[i].calcularIMC());
        }
    }
}
