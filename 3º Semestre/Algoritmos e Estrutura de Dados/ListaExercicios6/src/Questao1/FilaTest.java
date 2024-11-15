package Questao1;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FilaTest {
    @Test
    public void TestFilaEstaVaziaTrue(){
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        assertTrue(fila.estaVazia());
    }
    @Test
    public void TestFilaEstaVaziaFalse(){
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        assertFalse(fila.estaVazia());
    }
    @Test
    public void TestFilaEmfileirar(){
        FilaVetor<Integer> fila = new FilaVetor<>(10);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.inserir(40);
        assertEquals(fila.retirar(),10);
        assertEquals(fila.retirar(),20);
        assertEquals(fila.retirar(),30);
        assertEquals(fila.retirar(),40);
        assertTrue(fila.estaVazia());
    }
    @Test
    public void TestFilaCheiaException (){
        FilaVetor<Integer> fila = new FilaVetor<>(3);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            fila.inserir(40);
        });
        assertEquals("Fila cheia!", exception.getMessage());

    }
    @Test
    public void TestFilaVaziaException (){
        FilaVetor<Integer> fila = new FilaVetor<>(10);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            fila.retirar();
        });
        assertEquals("Fila vazia!", exception.getMessage());

    }
    @Test
    public void TestFilaInicio(){
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        assertEquals(10,fila.peek());
    }
    @Test
    public void TestFilaLiberar(){
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.liberar();
        assertTrue(fila.estaVazia());
    }
    @Test
    public void TestFilaConcatenar(){
        FilaVetor<Integer> fila1 = new FilaVetor<>(5);
        fila1.inserir(10);
        fila1.inserir(20);
        fila1.inserir(30);

        FilaVetor<Integer> fila2 = new FilaVetor<>(3);
        fila2.inserir(40);
        fila2.inserir(50);

        FilaVetor<Integer> fila3 = fila1.criarFilaConcatenada(fila2);
        assertEquals("[10, 20, 30, 40, 50]",fila3.toString());
        assertEquals("[10, 20, 30]",fila1.toString());
        assertEquals("[40, 50]",fila2.toString());
        assertEquals(8,fila3.getLimite());

    }
}