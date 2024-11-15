package listaexercicios31;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DiarioClasse {

    public static void main(String[] args) {
        System.out.println("LISTA ESTATICA COM DIARIO DE CLASSE");
        ListaEstatica lista = new ListaEstatica();
        LocalDate data = LocalDate.parse("2023-03-08", DateTimeFormatter.ISO_DATE);

        long memoryBefore, memoryAfter, memoryUsed, startTime, endTime, usedTime;

        System.out.println("==================");
        System.out.println("A - Inserir Elementos");
        
        startTime = System.currentTimeMillis();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        for (int i = 0; i < 550000; i++) {
            Aluno aluno = new Aluno();
            aluno.setDataNascimento(data);
            data = data.plusDays(1);
            aluno.setNome("Teste " + i);
            lista.inserir(aluno);
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

        System.out.println(lista.getTamanho());

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

        System.out.println(lista.obterElemento(0));
        
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

        Aluno aluno = new Aluno();
        aluno.setDataNascimento(data);
        aluno.setNome("Teste " + 549999);
        System.out.println(lista.buscar(aluno.getNome()));
        
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

        lista.retirar(aluno.getNome());

        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        memoryUsed = memoryAfter - memoryBefore;
        endTime = System.currentTimeMillis();
        usedTime = endTime - startTime;
        System.out.println("Tempo usado para retirar: " + usedTime + " ms");
        System.out.println("Memória usada para retirar: " + memoryUsed + " bytes");
    }
}
