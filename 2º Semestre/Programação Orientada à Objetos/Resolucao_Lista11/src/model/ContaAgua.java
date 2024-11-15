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
public class ContaAgua implements Pagavel{
    private int metrosCubicos;
    private double precoMetroCubico;
    
    public ContaAgua(int metrosCubicos, double precoMetroCubico){
        this.metrosCubicos = metrosCubicos;
        this.precoMetroCubico = precoMetroCubico;
    }

    @Override
    public double calcularValorPagar() {
       return metrosCubicos * precoMetroCubico; 
    }
}
