/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Robson Walter de Souza
 */
public class ContaBancaria {
    private String numero;
    private double saldo;
    private Cliente titular;
    private ArrayList<Movimento> movimentos = new ArrayList<>();
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
      return titular;
    }

    public void setTitular(Cliente titular) {
      this.titular = titular;
    }
    
    public void depositar(double valor){  
        if (valor <= 0){
            throw new IllegalArgumentException("O valor deve ser maior que zero para depósito");
        }
        
        setSaldo(getSaldo() + valor);   
        Movimento lancamento = new Movimento(valor, TipoMovimento.CREDITO);
        incluirMovimento(lancamento);
    }
    
    
    public void sacar(double valor){
      if (valor <= 0 || getSaldo() < valor){
          throw new IllegalArgumentException("Valor inválido para saque");
      }
      
      setSaldo(getSaldo() - valor);
      
      Movimento lancamento = new Movimento(valor, TipoMovimento.DEBITO);
      incluirMovimento(lancamento);
    }
    
    public void transferir(ContaBancaria c, double valor){
        sacar(valor);
        c.depositar(valor);
    }

    public ArrayList<Movimento> getMovimentos() {
        return movimentos;
    }
    
    protected void incluirMovimento(Movimento m){
        movimentos.add(m);
    }
    
    
    
}
