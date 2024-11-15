package Questao3;

import org.junit.Test;
import static org.junit.Assert.*;

public class PilhaTest {

    @Test
    public void testEstaVaziaPilhaVazia() {
        PilhaLista<Integer> pilha = new PilhaLista<Integer>();
        assertTrue(pilha.estaVazia());
    }

    @Test
    public void testEstaVaziaPilhaNaoVazia() {
        PilhaLista<Integer> pilha = new PilhaLista<Integer>();
        pilha.push(10);
        assertFalse(pilha.estaVazia());
    }

    @Test
    public void testEmpilharDesempilhar() {
        PilhaLista<Integer> pilha = new PilhaLista<Integer>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        assertEquals(Integer.valueOf(30), pilha.pop());
        assertEquals(Integer.valueOf(20), pilha.pop());
        assertEquals(Integer.valueOf(10), pilha.pop());
        assertTrue(pilha.estaVazia());
    }

    @Test
    public void testPeek() {
        PilhaLista<Integer> pilha = new PilhaLista<Integer>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        assertEquals(Integer.valueOf(30), pilha.peek());
        assertEquals(Integer.valueOf(30), pilha.pop());
    }

    @Test
    public void testLiberar() {
        PilhaLista<Integer> pilha = new PilhaLista<Integer>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.liberar();
        assertTrue(pilha.estaVazia());
    }
}
