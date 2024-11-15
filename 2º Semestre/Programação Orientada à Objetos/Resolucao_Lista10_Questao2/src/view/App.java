/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Empresa;
import model.Funcionario;
import model.Programador;
import model.Venda;
import model.Vendedor;

/**
 *
 * @author rwsouza
 */
public class App {
    public static void main(String[] args) {
        Empresa minhaEmpresa = new Empresa("Robson S/A");
        
        //Luiz
        Vendedor vendedor1 = new Vendedor("Luiz", 1000, 10);
        Venda venda1 = new Venda(200);
        Venda venda2 = new Venda(100);
        
        vendedor1.incluirVenda(venda1);
        vendedor1.incluirVenda(venda2);
        
        minhaEmpresa.incluirFuncionario(vendedor1);
        
        //Paula
        
        Vendedor vendedor2 = new Vendedor("Paula", 1200, 7);
        Venda venda01 = new Venda(500);
        Venda venda02 = new Venda(350);
        Venda venda03 = new Venda(280);
        
        vendedor2.incluirVenda(venda01);
        vendedor2.incluirVenda(venda02);
        vendedor2.incluirVenda(venda03);
        
        minhaEmpresa.incluirFuncionario(vendedor2);
        //julio
        Programador julio = new Programador("Julio", 1000);
        julio.incluirLinguagem("C");
        julio.incluirLinguagem("Java");
        
        minhaEmpresa.incluirFuncionario(julio);
        
        //ana
        Programador ana = new Programador("Ana", 1000);
        ana.incluirLinguagem("Java");
        ana.incluirLinguagem("C#");
        
        minhaEmpresa.incluirFuncionario(ana);
        
        //Anderson
        Programador anderson = new Programador("Anderson", 1200);
        anderson.incluirLinguagem("Phyton");
        
        minhaEmpresa.incluirFuncionario(anderson);
        
        //demais funcionários
        
        Funcionario jose = new Funcionario("José", 1000);
        minhaEmpresa.incluirFuncionario(jose);
        
        
        Funcionario maria = new Funcionario("maria", 1400);
        minhaEmpresa.incluirFuncionario(maria);
        
        
        System.out.println("*********Custo Total de Salários **********");
        System.out.println("R$ "+minhaEmpresa.calcularCustosSalarios());
        
        System.out.println("********* Lista de Funcionários **********");
        for (Funcionario f : minhaEmpresa.getFuncionarios()){
            System.out.println("Nome: "+f.getNome()+ 
                               " Salario: "+f.calcularSalario());
        }
        
        System.out.println("********* Lista de Vendedores **********");
        for (Funcionario f : minhaEmpresa.getFuncionarios()){
            if (f instanceof Vendedor){ 
                Vendedor vendedor = (Vendedor)f;
                System.out.println("Nome: "+f.getNome()+ 
                                   " Percentual Comissão: "+
                                    vendedor.getPercentualComissao());   
            }
        }
        
        System.out.println("********* Lista de Programadores **********");
        for (Funcionario f : minhaEmpresa.getFuncionarios()){
            if (f instanceof Programador){ 
                Programador programador = (Programador)f;
                System.out.println("Nome: "+f.getNome()+ 
                                   " Linguagens de Programação: "+
                                    programador.getLinguagens());   
            }
        }
        
        
    }
}
