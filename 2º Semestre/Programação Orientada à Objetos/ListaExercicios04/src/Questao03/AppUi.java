package Questao03;

import javax.swing.JOptionPane;

public class AppUi {

    public static void main(String[] args) {
        double altura = (Double.parseDouble(JOptionPane.showInputDialog("Informe a altura do retângulo: ")));
        double comprimento = (Double.parseDouble(JOptionPane.showInputDialog("Informe o comprimento do retângulo: ")));
        Retangulo retangulo = new Retangulo(comprimento, altura);

        JOptionPane.showMessageDialog(null, "Área do retângulo: " + retangulo.calcularArea() + "\n" + "Perímetro do retângulo: " + retangulo.calcularPerimetro());
    }
}
