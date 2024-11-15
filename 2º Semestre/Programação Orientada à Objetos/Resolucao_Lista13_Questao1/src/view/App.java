/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;
import model.Diretorio;

/**
 *
 * @author rwsouza
 */
public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Informe um diretório: ");
        String diretorio = teclado.nextLine();
        
        try{
          Diretorio dir = new Diretorio(diretorio);
          long tamanho = dir.ObterTamanhoArquivos();
          
          System.out.println("Tamanho dos Arquivos(Byte): "+tamanho);
          System.out.println("Tamanho dos Arquivos(MegaByte): "+(tamanho/1024.0/1024.0));
          
          
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        
        
        
        
    }
}
