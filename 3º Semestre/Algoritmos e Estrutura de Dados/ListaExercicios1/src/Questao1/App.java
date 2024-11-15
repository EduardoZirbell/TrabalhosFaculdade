/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Questao1;

/**
 *
 * @author eduardo
 */
public class App {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica();
        
        lista.inserir(5);
        lista.inserir(15);
        lista.inserir(10);
        lista.inserir(20);

        System.out.println(lista.toString());
       
    }
}
