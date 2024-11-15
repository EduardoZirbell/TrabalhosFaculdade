/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.DecimalFormat;
import model.ContaAgua;
import model.Contas;
import model.MensalidadeEnsino;
import model.Pagavel;
import model.PrevidenciaPrivada;

/**
 *
 * @author rwsouza
 */
public class App {
    public static void main(String[] args) {
        
        Contas conta = new Contas();
        
        //conta água
        conta.incluirConta(new ContaAgua(12, 8));
        //Mensalidade Ensino
        conta.incluirConta(new MensalidadeEnsino(5, 200));
        
        //previdencia privada
        
        PrevidenciaPrivada pp = new PrevidenciaPrivada();
        pp.setValor(600);
        pp.investir();
        pp.investir();
        pp.setValor(400);
        pp.investir();
        
        conta.incluirConta(pp);
        
        DecimalFormat df = new DecimalFormat("R$ 0.00");
        System.out.println("********Valor Total de Pagamentos *******");
        System.out.println(df.format(conta.calcularTotalContas()));
        
        System.out.println("********Lista de Pagamentos *******");
        
        for (Pagavel p : conta.getContas()){
          if (p instanceof PrevidenciaPrivada){
              System.out.println("Valor Pagamento: "+ 
                             df.format(p.calcularValorPagar())+
                               " - Saldo: "+
                             ((PrevidenciaPrivada)p).getSaldo() ); 
          }else{
            System.out.println("Valor Pagamento: "+ 
                             df.format(p.calcularValorPagar()));
              
          }
            
        }
        
        
        
        
        
        
        
        
        
    }
}
