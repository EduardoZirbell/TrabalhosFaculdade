/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import model.ArgumentoNaoEhArquivoException;
import model.ArquivoMp3;
import model.ArquivoNaoTemTagMp3;
import model.TagMp3;

/**
 *
 * @author rwsouza
 */
public class App {
    public static void main(String[] args) {
        
       try{
           ArquivoMp3 arquivo = new ArquivoMp3("C:\\Users\\eduar\\Downloads\\L14_municipios.csv");
           TagMp3 minhaTag = arquivo.getTag();
           System.out.println(arquivo.getTag());
           
           System.out.println("Título: "+ minhaTag.getTitulo());
           System.out.println("Artista: "+ minhaTag.getArtista());
           System.out.println("Album: "+ minhaTag.getAlbum());
           System.out.println("Ano: "+ minhaTag.getAno());
           System.out.println("Comentário: "+ minhaTag.getComentario());
           System.out.println("Número Faixa: "+ minhaTag.getNumeroFaixa());
           System.out.println("Genero: "+ minhaTag.getGenero());
        }catch(FileNotFoundException e){
            System.out.println("O arquivo "+e.getMessage() + " não existe.");
        }catch(ArgumentoNaoEhArquivoException e){
            System.out.println("O arquivo "+e.getMessage() + " não é um arquivo mp3.");
        }catch(ArquivoNaoTemTagMp3 e){
            System.out.println("O arquivo "+e.getMessage() + " não possui tag mp3.");
        }catch(IOException e){
            System.out.println("Erro na leitura do arquivo mp3");
        }
        
        
    }
}
