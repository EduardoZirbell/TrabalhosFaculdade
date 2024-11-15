/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import model.AnalisadorTexto;
import model.OrdenacaoPorFrequenciaDecrescente;

/**
 *
 * @author rwsouza
 */
public class App {
    public static void main(String[] args) {
        AnalisadorTexto at = new AnalisadorTexto();        
        at.setArquivo(new File("c:\\Teste\\L17_artigo.txt"));
        try{
          at.processarArquivo();
          
          System.out.println("****** ANTES DA ORDENAÇÃO *****");
          for(Entry<String, Integer> entrada : at.getPalavras().entrySet() ){
              System.out.println(entrada.getKey()+" - "+
                                 entrada.getValue());
          }
          
            List<Entry<String, Integer>> listaFrequencia = new ArrayList<>(at.getPalavras().entrySet());
            
            Collections.sort(listaFrequencia, new OrdenacaoPorFrequenciaDecrescente());
          
          System.out.println("****** DEPOIS DA ORDENAÇÃO *****");
          for(Entry<String, Integer> entrada : listaFrequencia ){
              System.out.println(entrada.getKey()+" - "+
                                 entrada.getValue());
          }
          
        }catch(FileNotFoundException ex){
            System.out.println("Arquivo não encontrado.");
        }
    }
}
