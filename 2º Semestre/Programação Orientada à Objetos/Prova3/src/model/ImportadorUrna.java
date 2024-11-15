/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author eduar
 */
public class ImportadorUrna {

    private Map<Chapa, Integer> votos;
    private File arquivo;

    public ImportadorUrna() {
        votos = new HashMap<>();  
    }

    public Map<Chapa, Integer> getVotos() {
        return votos;
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

                Chapa chapa = new Chapa();
                chapa.setNome(dados[0]);
                chapa.setPresidente(dados[1]);
                chapa.setCursoPresidente(dados[2]);
                chapa.setVicePresidente(dados[3]);
                chapa.setCursoVicePresidente(dados[4]);

                Integer qntVotos = getVotos().get(chapa);

                if (qntVotos != null) {
                    votos.put(chapa, Integer.parseInt(dados[5]) + qntVotos);
                } else {
                    votos.put(chapa, Integer.parseInt(dados[5]));
                }
            }
        }
    }

    public int obterTotalVotos() {
        int totalVotos = 0;
        for (Map.Entry<Chapa, Integer> entry : getVotos().entrySet()) {
            totalVotos += entry.getValue();
        }
        return totalVotos;
    }

    public Map.Entry<Chapa, Integer> obterChapaVencedora() {
        int votosVencedor = 0;
        Map.Entry<Chapa, Integer> entry = null;
        for (Map.Entry<Chapa, Integer> e : getVotos().entrySet()) {
            if (e.getValue() > votosVencedor) {
                entry = e;
                votosVencedor = e.getValue();
            }
        }
        return entry;
    }
}
