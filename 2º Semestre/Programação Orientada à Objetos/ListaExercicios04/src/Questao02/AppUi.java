package Questao02;

import javax.swing.JOptionPane;

public class AppUi {

    public static void main(String[] args) {
        Retangulo retangulo = new Retangulo();
        retangulo.setAltura(Double.parseDouble(JOptionPane.showInputDialog("Informe a altura do retângulo: ")));
        retangulo.setComprimento(Double.parseDouble(JOptionPane.showInputDialog("Informe o comprimento do retângulo: ")));

        JOptionPane.showMessageDialog(null, "Área do retângulo: " + retangulo.calcularArea() + "\n" + "Perímetro do retângulo: " + retangulo.calcularPerimetro());
    }
}
