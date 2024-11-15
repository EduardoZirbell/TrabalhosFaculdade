/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author rwsouza
 */
public class Triangulo extends Figura {
    private int lado1;
    private int lado2;
    private int lado3;

    public Triangulo(int lado1, int lado2, int lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }
    
    
    
    @Override
    public double calcularArea() {
       double p = (lado1+lado2+lado3)/2.0; 
       
       double a = Math.sqrt(p * (p - lado1) * (p - lado2) * (p - lado3));
       
       return a;
    }
    
}
