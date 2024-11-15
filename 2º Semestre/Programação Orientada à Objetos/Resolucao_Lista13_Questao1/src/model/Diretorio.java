/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;

/**
 *
 * @author rwsouza
 */
public class Diretorio {

    private File diretorio;

    public Diretorio(String caminho) {
        diretorio = new File(caminho);

        if (!diretorio.exists()) {
            throw new IllegalArgumentException("O diretório: "
                    + caminho
                    + " não existe.");
        }
    }

    public long ObterTamanhoArquivos() {
        return ObterTamanhoArquivos(diretorio);
    }

    private long ObterTamanhoArquivos(File arquivo) {
        long total = 0;

        File[] dir = arquivo.listFiles();
        if (dir != null) {
            for (File f : dir) {
                if (f.isDirectory()) {
                    total += ObterTamanhoArquivos(f);
                } else {
                    total += f.length();
                }
            }
        }

        return total;
    }

}
