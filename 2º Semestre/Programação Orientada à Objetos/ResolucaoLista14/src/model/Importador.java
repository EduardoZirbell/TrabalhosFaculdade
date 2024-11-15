/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author rwsouza
 */
public class Importador {
    private Pais pais;
    
    public Importador(Pais pais){
        this.pais = pais;
    }

    public Pais getPais() {
        return pais;
    }
    
    public void carregarDados(File arquivo) throws FileNotFoundException{
       
        try(Scanner sc = new Scanner(arquivo, "UTF-8")){
            //ignorar cabeçalho
            if (sc.hasNextLine()){
               sc.nextLine();
            } 
            
            while(sc.hasNextLine()){
                String linha = sc.nextLine();
                
                String[] dados = linha.split(";");
                
                Cidade novaCidade = new Cidade();
                novaCidade.setCodigoIbge(Integer.parseInt(dados[0]));
                novaCidade.setNome(dados[1]);
                
                Estado novoEstado = getPais().procurarEstado(dados[2]);
                
                if (novoEstado == null){
                    novoEstado = new Estado(dados[2]);
                    getPais().incluirEstado(novoEstado);
                }
                
                novaCidade.setEstado(novoEstado);
                
                novaCidade.setPopulacao(Long.parseLong(dados[3]));
                
                getPais().incluirCidade(novaCidade);
                
            }
            
        }
        
    }
    
    
    
}
