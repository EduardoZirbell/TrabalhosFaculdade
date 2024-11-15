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
public class Empresa {
    private String nome;
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public Empresa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void incluirFuncionario(Funcionario f){
       funcionarios.add(f);
    }
    
    public void removerFuncionario(Funcionario f){
       funcionarios.remove(f);
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    
    public double calcularCustosSalarios(){
       double totalSalarios = 0;
       
       for (Funcionario f : funcionarios){
           totalSalarios += f.calcularSalario();
       }
       
       return totalSalarios;
        
    }
}
