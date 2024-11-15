/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;
import model.Circulo;
import model.Figura;
import model.Quadrado;
import model.Retangulo;
import model.Triangulo;

/**
 *
 * @author rwsouza
 */
public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Escolha uma Figura Geométrica para criar:");
        System.out.println(" 1 - Quadrado \n 2 - Retangulo \n 3 - Triangulo \n 4 - Círculo");
        int opcaoEscolhida = Integer.parseInt(teclado.nextLine());
        
        Figura figuraGeometrica = null;
        
        switch(opcaoEscolhida){
            case 1 : //Quadrado
                    System.out.println(" Informe a medida do Quadrado: ");
                    int medida = Integer.parseInt(teclado.nextLine());
                    figuraGeometrica = new Quadrado(medida);
                    break;
            case 2 : //Retangulo
                    System.out.println("Informe a Largura do Retangulo:");
                    int largura = Integer.parseInt(teclado.nextLine());
                    System.out.println("Informe a Altura do Retangulo:");
                    int altura = Integer.parseInt(teclado.nextLine());
                    
                    figuraGeometrica = new Retangulo(largura, altura);
                    break;
            case 3 : //Triangulo
                    System.out.println("Informe o lado1 do Triangulo:");
                    int lado1 = Integer.parseInt(teclado.nextLine());
                    System.out.println("Informe o lado2 do Triangulo:");
                    int lado2 = Integer.parseInt(teclado.nextLine());
                    System.out.println("Informe o lado3 do Triangulo:");
                    int lado3 = Integer.parseInt(teclado.nextLine());
                    
                    figuraGeometrica = new Triangulo(lado1, lado2, lado3);
                    
                    break;
            case 4 : //Círculo
                    System.out.println("Informe o raio do circulo:");
                    int raio = Integer.parseInt(teclado.nextLine());
                    
                    figuraGeometrica = new Circulo(raio);
                    
                    break;
        }
        
        
        System.out.println("A área da figura geométrica é: "+
                           figuraGeometrica.calcularArea());
    }
}
