package Questao2;

public class Pessoa {
    double altura;
    double peso;
    
    double calcularIMC(){
        return (peso / (altura * altura));
    }
}
