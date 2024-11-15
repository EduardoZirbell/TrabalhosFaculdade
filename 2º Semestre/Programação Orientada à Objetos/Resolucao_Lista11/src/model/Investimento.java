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
public abstract class Investimento implements Pagavel {
   private double saldo;
   
   public double getSaldo(){
       return saldo;
   }
   
   protected void setSaldo(double saldo){
      this.saldo = saldo; 
   }
}
