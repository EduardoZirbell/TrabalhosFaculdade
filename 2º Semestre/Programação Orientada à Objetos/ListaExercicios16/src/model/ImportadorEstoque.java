/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author eduar
 */
public class ImportadorEstoque {

    private Map<Produto, Integer> estoque;
    private File arquivo;

    public ImportadorEstoque() {
        estoque = new HashMap<>();
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

    public void processarArquivo() throws FileNotFoundException {
        try (Scanner sc = new Scanner(arquivo, "UTF-8")) {
            if (sc.hasNextLine()) {
                sc.nextLine();
            }
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();

                String[] dados = linha.split(";");

                Produto produto = new Produto(dados[0], Double.parseDouble(dados[1]));

                Integer qntEstoque = estoque.get(produto);

                if (qntEstoque != null) {
                    estoque.put(produto, Integer.parseInt(dados[2]) + qntEstoque);
                } else {
                    estoque.put(produto, Integer.parseInt(dados[2]));
                }
            }
        }
    }

    public Map<Produto, Integer> getEstoque() {
        return estoque;
    }

    public Integer totalEmEstoqueGeral(Map<Produto, Integer> listaEstoque) {
        Integer totalEstoque = 0;
        for (Map.Entry<Produto, Integer> entry : listaEstoque.entrySet()) {
            totalEstoque += entry.getValue();
        }
        return totalEstoque;
    }

    public Entry<Produto, Integer> maiorProdutoEstoque(Map<Produto, Integer> listaEstoque) {
        Integer estoqueProduto = 0;
        Entry<Produto, Integer> entry = null;
        for (Map.Entry<Produto, Integer> e : listaEstoque.entrySet()) {
            if (e.getValue() > estoqueProduto) {
                entry = e;
                estoqueProduto = e.getValue();
            }
        }
        return entry;
    }

    public Entry<Produto, Integer> menorProdutoEstoque(Map<Produto, Integer> listaEstoque) {
        Integer estoqueProduto = 0;
        Entry<Produto, Integer> entry = null;
        int cont = 0;
        for (Map.Entry<Produto, Integer> e : listaEstoque.entrySet()) {
            if (cont != 0) {
                if (e.getValue() < estoqueProduto) {
                    estoqueProduto = e.getValue();
                    entry = e;
                }
            } else {
                estoqueProduto = e.getValue();
                entry = e;
            }
            cont++;
        }
        return entry;
    }
}
