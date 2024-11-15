package Questao1;

public class App {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        pessoa.altura = 1.75;
        pessoa.peso = 78.0;
        
        System.out.println("O IMC da pessoa é: " + pessoa.calcularIMC());
    }
}
