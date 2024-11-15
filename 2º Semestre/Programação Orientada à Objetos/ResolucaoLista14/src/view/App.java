/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import java.io.FileNotFoundException;
import model.Cidade;
import model.Importador;
import model.Pais;

/**
 *
 * @author rwsouza
 */
public class App {
    public static void main(String[] args) throws FileNotFoundException {
        
        Pais p = new Pais();
        
        Importador importadorDados = new Importador(p);
        importadorDados.carregarDados(new File("C:\\Exe14\\L14_municipios.csv") );
        
        Cidade maiorPopulacao = p.obterCidadeMaiorPoupulacao();
        Cidade menorPopulacao = p.obterCidadeMenorPopulacao();
        
        
        System.out.println("**** Dados Cidade Maior População **** ");
        System.out.println("CodigoIbge: "+maiorPopulacao.getCodigoIbge());
        System.out.println("Nome Cidade: "+maiorPopulacao.getNome());
        System.out.println("Nome Estado: "+maiorPopulacao.getEstado().getNome());
        System.out.println("População: "+maiorPopulacao.getPopulacao());
        
        System.out.println("**** Dados Cidade Menor População **** ");
        System.out.println("CodigoIbge: "+menorPopulacao.getCodigoIbge());
        System.out.println("Nome Cidade: "+menorPopulacao.getNome());
        System.out.println("Nome Estado: "+menorPopulacao.getEstado().getNome());
        System.out.println("População: "+menorPopulacao.getPopulacao());
        
    }   
}
