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
public class ContaEspecial extends ContaBancaria{
    double limiteCredito;

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
    
    @Override
    public void sacar(double valor){
      if (valor <= 0 || (getSaldo()+getLimiteCredito() < valor)){
          throw new IllegalArgumentException("Valor inválido para saque");
      }
      
        setSaldo(getSaldo()- valor);
        /*Inclusão decorrente ao caso de teste 1*/
        Movimento lancamento = new Movimento(valor, TipoMovimento.DEBITO);
        incluirMovimento(lancamento);
    }
    
    
}
