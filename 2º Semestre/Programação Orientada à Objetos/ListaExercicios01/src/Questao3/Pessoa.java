package Questao3;

public class Pessoa {
    double altura;
    double peso;
    
    double calcularIMC(){
        return (peso / (altura * altura));
    }
}
