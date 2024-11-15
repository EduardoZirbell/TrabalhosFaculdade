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
public class MensalidadeEnsino implements Pagavel {
   private int nrCreditos;
   private double precoCredito;
   
   public MensalidadeEnsino(int nrCreditos, double precoCredito){
       this.nrCreditos = nrCreditos;
       this.precoCredito = precoCredito;
   }

    @Override
    public double calcularValorPagar() {
        return nrCreditos * precoCredito;
    }
   
}
