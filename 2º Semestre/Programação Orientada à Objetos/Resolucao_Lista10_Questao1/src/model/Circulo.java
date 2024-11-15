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
public class Circulo extends Figura {
   private int raio;

    public Circulo(int raio) {
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        //𝐴 = 𝜋 × 𝑟²
        return Math.PI * Math.pow(raio,2);
    }
   
   
   
}
