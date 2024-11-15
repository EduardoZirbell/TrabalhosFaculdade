package listaexercicios31;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RedeSocial {

    public static void main(String[] args) {
        System.out.println("LISTA ENCADEADA COM REDE SOCIAL");
        ListaEncadeada<Publicacao> lista = new ListaEncadeada<>();
        
        inserir(10)
inserir(20)
inserir(30) 
inserir(20) 
inserir(40)
retirar(20)
inserir(50) 
inserir(60)
        
        LocalDate data = LocalDate.parse("2023-03-08", DateTimeFormatter.ISO_DATE);
        long memoryBefore, memoryAfter, memoryUsed, startTime, endTime, usedTime;

        System.out.println("==================");
        System.out.println("A - Inserir Elementos");
        
        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        for (int i = 0; i < 550000; i++) {
            Publicacao publicacao = new Publicacao();
            publicacao.setData(data);
            publicacao.setTextoPublicacao("Olá sejam todos bem vindos a nossa nova rede social! " + i);
            lista.inserir(publicacao);
            data = data.plusDays(1);
        }
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = memoryAfter - memoryBefore;
        endTime = System.currentTimeMillis();
        usedTime = endTime - startTime;
        System.out.println("Tempo usado para inserir: " + usedTime + " ms");
        System.out.println("Memória usada para inserir: " + memoryUsed + " bytes");

        System.out.println("==================");
        System.out.println("E - Obter Tamanho da Lista");
        
        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println(lista.obterComprimento());
        
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = memoryAfter - memoryBefore;
        endTime = System.currentTimeMillis();
        usedTime = endTime - startTime;
        System.out.println("Tempo usado para obter tamanho: " + usedTime + " ms");
        System.out.println("Memória usada para obter tamanho: " + memoryUsed + " bytes");
        
        System.out.println("==================");
        System.out.println("C - Encontrar elemento");
        
        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println(lista.obterNo(0));
        
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = memoryAfter - memoryBefore;
        endTime = System.currentTimeMillis();
        usedTime = endTime - startTime;
        System.out.println("Tempo usado para encontrar um elemento: " + usedTime + " ms");
        System.out.println("Memória usada para encontrar um elemento: " + memoryUsed + " bytes");
        
        System.out.println("==================");
        System.out.println("D - Encontrar índice de um elemento");
        
        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        Publicacao publicacao = new Publicacao();
        publicacao.setTextoPublicacao("Olá sejam todos bem vindos a nossa nova rede social! 549999");
        publicacao.setData(data);
        lista.inserir(publicacao);
        System.out.println(lista.buscar(publicacao));
        
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = memoryAfter - memoryBefore;
        endTime = System.currentTimeMillis();
        usedTime = endTime - startTime;
        System.out.println("Tempo usado para encontrar um índice de um elemento: " + usedTime + " ms");
        System.out.println("Memória usada para encontrar um índice de um elemento: " + memoryUsed + " bytes");
        
        System.out.println("==================");
        System.out.println("B - Retirar Elemento");
        
        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        lista.retirar(publicacao);
        
        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = memoryAfter - memoryBefore;
        endTime = System.currentTimeMillis();
        usedTime = endTime - startTime;
        System.out.println("Tempo usado para retirar: " + usedTime + " ms");
        System.out.println("Memória usada para retirar: " + memoryUsed + " bytes");
    }
}
