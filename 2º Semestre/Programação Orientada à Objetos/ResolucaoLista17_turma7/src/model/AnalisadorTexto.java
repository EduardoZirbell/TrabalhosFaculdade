/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author rwsouza
 */
public class AnalisadorTexto {
    private Map<String, Integer> palavras;
    private File arquivo;
    
    
    public AnalisadorTexto(){
       palavras = new HashMap<>();
    }
    
    public void processarArquivo() throws FileNotFoundException{
        
        try(Scanner sc = new Scanner(arquivo)){
            sc.useDelimiter("[ ,;.:?!()\" \n]");
            
            while(sc.hasNext()){               
                String palavra = sc.next().toLowerCase();
                Integer frequencia = palavras.get(palavra);
                if (!palavras.equals("")){
                    if (frequencia == null){
                        frequencia = 1;
                    }else{
                        frequencia++;
                    }
                    
                    palavras.put(palavra,frequencia);
                }
                
            }
        }
        
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

    public Map<String, Integer> getPalavras() {
        return palavras;
    }
    
    
    
    
    
    
}
