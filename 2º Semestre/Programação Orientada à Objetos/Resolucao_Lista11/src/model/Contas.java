/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author rwsouza
 */
public class Contas {
    private ArrayList<Pagavel> contas = new ArrayList<>();
    
    public void incluirConta(Pagavel conta){
        contas.add(conta);
    }
    
    public ArrayList<Pagavel> getContas(){
        return contas;
    }
    
    public double calcularTotalContas(){
        double total = 0;
        
        for (Pagavel p : contas){
           total += p.calcularValorPagar();
        }
        
        return total;
    }
}
