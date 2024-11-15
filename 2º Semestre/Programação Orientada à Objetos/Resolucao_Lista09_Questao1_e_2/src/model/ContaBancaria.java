/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Robson Walter de Souza
 */
public class ContaBancaria {
    private String numero;
    private double saldo;
    private Cliente titular;

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
    }
    
    
    public void sacar(double valor){
      if (valor <= 0 || getSaldo() < valor){
          throw new IllegalArgumentException("Valor inválido para saque");
      }
      
      setSaldo(getSaldo() - valor);
    }
    
    public void transferir(ContaBancaria contaDestino, double valor){
        sacar(valor);
        contaDestino.depositar(valor);
    }
    
    
}
