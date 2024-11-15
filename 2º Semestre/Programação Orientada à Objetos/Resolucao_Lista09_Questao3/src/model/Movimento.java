/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Robson Walter de Souza
 */
public class Movimento {
    private double valor;
    private TipoMovimento tipoMovimento;
    private LocalDate data;
    private LocalTime hora;
    
    public Movimento(double valor, TipoMovimento tipoMovimento){
        this.valor = valor;
        this.tipoMovimento = tipoMovimento;
        this.data = LocalDate.now();
        this.hora = LocalTime.now();
    }

    public double getValor() {
        return valor;
    }

    public TipoMovimento getTipoMovimento() {
        return tipoMovimento;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }
    
    
}
