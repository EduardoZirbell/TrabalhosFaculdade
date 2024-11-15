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
public class Vendedor extends Funcionario {
    private double percentualComissao;
    private ArrayList<Venda> vendas = new ArrayList<>();

    public Vendedor(String nome, double salarioBase, double percentualComissao) {
        super(nome, salarioBase);
        this.percentualComissao = percentualComissao;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public ArrayList<Venda> getVendas() {
        return vendas;
    }
    
    
    public void incluirVenda(Venda v){
       vendas.add(v);
    }
    
    @Override
    public double calcularSalario(){
        double total = 0;
        
        for(Venda v : vendas){
            total += v.getValor();
        }
        
        
        return getSalarioBase() +
                ((total* getPercentualComissao())/100);
    }
    
    
    
    
    
}
