package Questao4;

public class Pessoa {
    double altura;
    double peso;
    
    double calcularIMC(){
        return (peso / (altura * altura));
    }
}
