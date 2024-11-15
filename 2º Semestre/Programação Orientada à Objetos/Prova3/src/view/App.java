/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import model.Chapa;
import model.ImportadorUrna;

/**
 *
 * @author eduar
 */
public class App {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        ImportadorUrna importador = new ImportadorUrna();
        System.out.println("Informe o caminho do arquivo com os dados das urnas: ");
        String caminho = sc.next();
        importador.setArquivo(new File(caminho));
        importador.processarArquivo();

        Map<Chapa, Integer> listaVotos = importador.getVotos();

        System.out.println("Resultado das Votações:");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
        for (Map.Entry<Chapa, Integer> entry : listaVotos.entrySet()) {
            System.out.println("Chapa: " + entry.getKey().getNome() + "\n"
                    + " Presidente: " + entry.getKey().getPresidente()
                    + " Curso: " + entry.getKey().getCursoPresidente() + "\n"
                    + " Vice Presidente: " + entry.getKey().getVicePresidente()
                    + " Curso: " + entry.getKey().getCursoVicePresidente() + "\n"
                    + " Votos da Chapa: " + entry.getValue());
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - \n");
        }

        System.out.println("Total das Votações:");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
        int totalVotos = importador.obterTotalVotos();
        System.out.println("A quantidade total de votos foi: " + totalVotos);
        Map.Entry<Chapa, Integer> chapaVencedora = importador.obterChapaVencedora();
        DecimalFormat df = new DecimalFormat("0.00");
        double porcentagemVencedor = (chapaVencedora.getValue() / (double) totalVotos) * 100;
        System.out.println("A chapa vencedora foi: " + chapaVencedora.getKey().getNome()
                + " representando " + df.format(porcentagemVencedor) + "% do total dos votos");
    }
}
