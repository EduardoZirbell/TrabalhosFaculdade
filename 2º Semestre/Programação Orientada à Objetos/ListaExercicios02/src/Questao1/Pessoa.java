package Questao1;

public class Pessoa {
    private double altura;
    private double peso;

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    double calcularIMC(){
        return (getPeso() / (getAltura() * getAltura()));
    }
}
