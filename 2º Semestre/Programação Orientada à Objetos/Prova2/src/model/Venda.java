/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author eduar
 */
public class Venda {

    private ArrayList<Produto> produtos = new ArrayList(10);
    private TipoEntrega tipoEntrega;
    private Vendedor vendedor;
    private Cliente cliente;

    public void inserirProduto(Produto p) {
        if (produtos.size() == 10) {
            throw new IllegalArgumentException("Não é possível adicionar mais que 10 produtos na venda.");
        }
        produtos.add(p);
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public TipoEntrega getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(TipoEntrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double calcularValorEntrega() {
        if (tipoEntrega == null) {
            throw new IllegalArgumentException("Nenhum tipo de entrega cadastrado a venda.");
        }
        double valorEntrega = 0;
        switch (tipoEntrega) {
            case SEDEX:
                valorEntrega = 10;
                for (Produto p : produtos) {
                    valorEntrega += 0.025 * p.getPeso();
                }
            case ENCOMENDA_PAC:
                valorEntrega = 7.75;
                break;
            default:
                throw new AssertionError();
        }
        return valorEntrega;
    }

    public double calcularValorProdutos() {
        if (getProdutos().isEmpty()) {
            throw new IllegalArgumentException("Nenhum produto cadastrado a venda.");
        }
        if (cliente == null) {
            throw new IllegalArgumentException("Nenhum cliente cadastrado a venda.");
        }
        double valorTotal = 0;
        for (Produto p : produtos) {
            valorTotal += p.getValor();
        }
        if (cliente.isMesAniversario()) {
            valorTotal = (valorTotal * 5) / 100;
        }
        return valorTotal;
    }

    public double calcularComissao() {
        
    }
}
