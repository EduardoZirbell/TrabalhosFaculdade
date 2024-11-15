/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.ContaEspecial;
import model.Movimento;

/**
 *
 * @author rwsouza
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        
        ContaEspecial c1 = new ContaEspecial();
        
        c1.depositar(5000);
        Thread.sleep(1000);
        
        c1.depositar(500);
        Thread.sleep(1000);
        
        c1.sacar(300);
        Thread.sleep(1000);
        
        c1.sacar(60);
        Thread.sleep(1000);
        
        c1.sacar(500);
        
        System.out.println(" ***** ANTES DA ORDENAÇÃO ****");
        for(Movimento m : c1.getMovimentos()){
          System.out.println("Hora: "+m.getHora()+
                             "Tipo: "+m.getTipoMovimento().toString()+
                             "Valor: "+m.getValor());
        
        }    
        
        c1.ordenaMovimentosHoraDecrescente();
        
        System.out.println(" ***** DEPOIS DA ORDENAÇÃO ****");
        for(Movimento m : c1.getMovimentos()){
          System.out.println("Hora: "+m.getHora()+
                             "Tipo: "+m.getTipoMovimento().toString()+
                             "Valor: "+m.getValor());
        
        }   
    }
}
