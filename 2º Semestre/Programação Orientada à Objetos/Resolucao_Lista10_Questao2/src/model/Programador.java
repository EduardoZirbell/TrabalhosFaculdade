/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author rwsouza
 */
public class Programador extends Funcionario {
    private ArrayList<String> linguagens = new ArrayList<>();

    public Programador(String nome, double salarioBase) {
        super(nome, salarioBase);
    }
    
    public void incluirLinguagem(String linguagem){
        linguagens.add(linguagem);
    }
    
    public void removerLinguagem(String linguagem){
      linguagens.remove(linguagem);
    }

    public ArrayList<String> getLinguagens() {
        return linguagens;
    }
    
    @Override
    public double calcularSalario(){
      
        for (String l : linguagens){
            if (l.equalsIgnoreCase("java")){
                return getSalarioBase() + 
                       ((getSalarioBase() * 20)/100);
            }
        }
      
        return getSalarioBase();
        
        
    }
    
}
