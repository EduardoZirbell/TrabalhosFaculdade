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
public class ImportadorEstoque {
    private Map<Produto, Integer> estoque;
    private File arquivo;
    
    public ImportadorEstoque(){
        estoque = new HashMap<>();
    }
    
    public void setArquivo(File arquivo){
        this.arquivo = arquivo;
    }
    
    public void processarArquivo() throws FileNotFoundException{
        try(Scanner sc = new Scanner(arquivo, "UTF-8") ){
           if (sc.hasNextLine()){
               sc.nextLine();
           }
            
           while(sc.hasNextLine()){
              String linha = sc.nextLine();
              
              //Smart Tv 50 HQ 4K 3 HDMI 2 Usb Wi-Fi Design Slim;1749.00;50
              String[] dados = linha.split(";");
              
              Produto meuProduto = new Produto(dados[0],
                                      Double.parseDouble(dados[1]) );
              
             Integer qtdEstoque = estoque.get(meuProduto);
             
             if (qtdEstoque != null){
                estoque.put(meuProduto, Integer.parseInt(dados[2])+qtdEstoque);   
             }else{
                estoque.put(meuProduto, Integer.parseInt(dados[2])); 
             }
              
              
           }
           
           
        }
    }

    public Map<Produto, Integer> getEstoque() {
        return estoque;
    }
    
    
    
    
}
