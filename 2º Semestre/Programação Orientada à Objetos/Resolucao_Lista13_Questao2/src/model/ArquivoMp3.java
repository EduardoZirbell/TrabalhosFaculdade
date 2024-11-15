/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.text.html.HTML;

/**
 *
 * @author rwsouza
 */
public class ArquivoMp3 {
    private TagMp3 tag;
    
    private String extrairTexto(byte[] dados, int posicaoInicial, int qtdBytes ){
                
        byte[] dados2 = new byte[qtdBytes];

        for (int i = 0; i < qtdBytes; i++) {
            dados2[i] = dados[posicaoInicial + i];
        }
        
        return new String(dados2);
        
    }
            
           
    public ArquivoMp3(String nomeArquivo) throws FileNotFoundException, IOException{
        File arquivo = new File(nomeArquivo);
        
        if (!arquivo.exists()){
            throw new FileNotFoundException(nomeArquivo);
        }
        
        if (!arquivo.isFile()){
            throw new ArgumentoNaoEhArquivoException(nomeArquivo);
        }
        
        
        try(FileInputStream fis = new FileInputStream(arquivo)){
           
            fis.skip(arquivo.length()-128);
            
            byte[] dados = new byte[128];
            
            fis.read(dados);
            
           /* int qtdBytes = 3, posicaoInicial = 0;
            
            byte[] dados2 = new byte[qtdBytes];
            
            for(int i = 0; i < qtdBytes;i++){
               dados2[i] = dados[posicaoInicial+i];  
            }*/
            
            
                      
            String cabecalho = extrairTexto(dados,0,3) ;
            
            if (cabecalho.equals("TAG")){
               tag = new TagMp3();
               
               String titulo = extrairTexto(dados, 3, 30);
               tag.setTitulo(titulo);
                               
               String artista = extrairTexto(dados, 33, 30);
               tag.setArtista(artista);
               
               String album = extrairTexto(dados, 63, 30);
               tag.setAlbum(album);
               
               int ano = Integer.parseInt(extrairTexto(dados, 93, 4));
               tag.setAno(ano);
               
               String comentario = extrairTexto(dados, 97, 28);
               tag.setComentario(comentario);
               
               //String flag = extrairTexto(dados, 125, 1);
               //System.out.println(flag);
               
               try{
                  int numeroFaixa = Integer.parseInt(extrairTexto(dados, 126, 1));
                  tag.setNumeroFaixa(numeroFaixa);               
               }catch(NumberFormatException e){
                   tag.setNumeroFaixa(0); 
               }
               
               try{
                  int genero = Integer.parseInt(extrairTexto(dados, 127, 1));
                  tag.setGenero(genero);
                
               }catch(NumberFormatException e){
                   tag.setGenero(0);
               }
               
               
            }else{
                throw new ArquivoNaoTemTagMp3(nomeArquivo);
            }
            
            
            
        }
        
        
        
        
    }

    public TagMp3 getTag() {
        return tag;
    }
    
    
}
