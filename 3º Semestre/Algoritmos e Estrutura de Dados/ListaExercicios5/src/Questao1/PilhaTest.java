package Questao1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PilhaTest {
    //Ao invocar estaVazia() deve resultar em true
   @Test
   public void TestPilhaEstaVaziaTrue(){
     PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
       assertTrue(pilha.estaVazia());
   }
   //Ao invocar estaVazia() deve resultar em false.
    @Test
    public void TestPilhaEstaVaziaFalse(){
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        assertFalse(pilha.estaVazia());
    }
    //Desempilhar um dado. Deve ser retornado 30
    //Desempilhar outro dado. Deve ser retornado 20.
    //Desempilhar outro dado. Deve ser retornado 10.
    //O método estaVazia() deve resultar em true
    @Test
    public void TestPilhaEmpilhar(){
        PilhaVetor<Integer> pilha = new PilhaVetor<>(10);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);
        assertEquals(pilha.pop(),40);
        assertEquals(pilha.pop(),30);
        assertEquals(pilha.pop(),20);
        assertEquals(pilha.pop(),10);
        assertTrue(pilha.estaVazia());
    }
    //A exceção PilhaCheiaException deve ser lançada
    @Test
    public void TestPilhaCheiaException (){
        PilhaVetor<Integer> pilha = new PilhaVetor<>(3);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            pilha.push(40);
        });
        assertEquals("Capacidade esgotada da pilha!", exception.getMessage());

    }
    //A exceção PilhaVaziaException deve ser lançada.
    @Test
    public void TestPilhaVaziaException (){
        PilhaVetor<Integer> pilha = new PilhaVetor<>(10);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            pilha.pop();
        });
        assertEquals("Pilha está vazia!", exception.getMessage());

    }
    //Deve retornar 30.
    //Em seguida, retirar o último elemento da pilha. Deve
    //resultar em 30.
    @Test
    public void TestPilhaTopo(){
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        assertEquals(30,pilha.peek());
    }
    //O método estaVazia() deve resultar em true.
    @Test
    public void TestPilhaLiberar(){
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.liberar();
        assertTrue(pilha.estaVazia());
    }
    //Ao utilizar toString(), deve resultar em 50,40,30,20,10.
    @Test
    public void TestPilhaConcatenar(){
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        PilhaVetor<Integer> pilha2 = new PilhaVetor<>(2);
        pilha2.push(40);
        pilha2.push(50);

        pilha.concatenar(pilha2);
        assertEquals("[10, 20, 30, 40, 50]",pilha.toString());

    }
}