/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import model.ImportadorEstoque;
import model.Produto;

/**
 *
 * @author rwsouza
 */
public class App {
    public static void main(String[] args) throws FileNotFoundException {
        ImportadorEstoque importador = new ImportadorEstoque();
        importador.setArquivo(new File("C:\\Exe15_turma7\\L16_Estoque.csv"));
        importador.processarArquivo();
        
        Map<Produto,Integer> listaEstoque = importador.getEstoque();
        
        for( Map.Entry<Produto, Integer> entry : listaEstoque.entrySet()){
            System.out.println("Produto: "+entry.getKey().getNome()+
                               " Valor: "+entry.getKey().getValor()+
                               " Qtd. Estoque: "+entry.getValue());
        }
        
    }
}
