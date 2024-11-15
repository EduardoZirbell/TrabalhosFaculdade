package Questao03;

public class Retangulo {

    private double comprimento;
    private double altura;

    //Construtor da classe vazio para caso deseje informar os atributos após a criação do objeto.
    public Retangulo() {
    }

    //Construtor da classe com os valores dos atributos.
    public Retangulo(double comprimento, double altura) {
        this.comprimento = comprimento;
        this.altura = altura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        if (comprimento <= 0) {
            throw new IllegalArgumentException("O comprimento informado é inválidO: " + comprimento);
        }
        this.comprimento = comprimento;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("A altura informado é inválidO: " + altura);
        }
        this.altura = altura;
    }

    //Função para retornar o calculo do perimetro do retângulo desejado.
    public double calcularPerimetro() {
        return (altura + comprimento);
    }

    //Função para retornar o calculo da área do retângulo desejado.
    public double calcularArea() {
        return (altura * comprimento);
    }
}
