package Questao3;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FilaTest {
    @Test
    public void TestFilaEstaVaziaTrue(){
        FilaLista<Integer> fila = new FilaLista<>();
        assertTrue(fila.estaVazia());
    }
    @Test
    public void TestFilaEstaVaziaFalse(){
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        assertFalse(fila.estaVazia());
    }
    @Test
    public void TestFilaEmfileirar(){
        FilaLista<Integer> fila = new FilaLista<>();
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
    public void TestFilaInicio(){
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        assertEquals(10,fila.peek());
    }
    @Test
    public void TestFilaLiberar(){
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.liberar();
        assertTrue(fila.estaVazia());
    }
}