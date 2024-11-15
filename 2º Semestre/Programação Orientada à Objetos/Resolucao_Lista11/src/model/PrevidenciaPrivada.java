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
public class PrevidenciaPrivada extends Investimento{
    
    private double valor;
       
    
    @Override
    public double calcularValorPagar() {
        return valor;
    }
    
    public void setValor(double valor){
        this.valor = valor;
    }
    
    public void investir(){
        setSaldo(getSaldo()+valor);
    }
  
    
    
}
