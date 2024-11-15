package Questao3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ListaEstaticaCarrosTest {
	private ListaEstaticaCarros lista = new ListaEstaticaCarros();
	
    @Test // Caso 1
    public void testInclusaoItensLista() {
    	lista.inserir(new Carro("ABC-1234", "João"));
        lista.inserir(new Carro("DFG-5678", "José"));
        lista.inserir(new Carro("MMM-5555", "Maria"));
        lista.inserir(new Carro("AAA-1111", "Ana"));

        assertEquals("ABC-1234, DFG-5678, MMM-5555, AAA-1111", lista.toString());
    }
    
    @Test // Caso 2
    public void testarObtencaoTamanhoLista() {
    	lista.inserir(new Carro("ABC-1234", "João"));
        lista.inserir(new Carro("DFG-5678", "José"));
        lista.inserir(new Carro("MMM-5555", "Maria"));
        lista.inserir(new Carro("AAA-1111", "Ana"));
        
        assertEquals(4, lista.getTamanho());
    }

    @Test // Caso 3
    public void testarBuscarElementoExistente() {
    	lista.inserir(new Carro("ABC-1234", "João"));
        lista.inserir(new Carro("DFG-5678", "José"));
        lista.inserir(new Carro("MMM-5555", "Maria"));
        lista.inserir(new Carro("AAA-1111", "Ana"));

        assertEquals(1, lista.buscar("DFG-5678"));
    }
    
    @Test // Caso 4
    public void testBuscarElementoInexistente() {
    	lista.inserir(new Carro("ABC-1234", "João"));
        lista.inserir(new Carro("DFG-5678", "José"));
        lista.inserir(new Carro("MMM-5555", "Maria"));
        lista.inserir(new Carro("AAA-1111", "Ana"));

        assertEquals(-1, lista.buscar("MMM-1234"));
    }
    
    @Test // Caso 5
    public void testRetirarElemento() {
    	lista.inserir(new Carro("ABC-1234", "João"));
        lista.inserir(new Carro("DFG-5678", "José"));
        lista.inserir(new Carro("MMM-5555", "Maria"));
        lista.inserir(new Carro("AAA-1111", "Ana"));

        lista.retirar("MMM-5555");

        assertEquals("ABC-1234, DFG-5678, AAA-1111", lista.toString());

        assertEquals(3, lista.getTamanho());
    }
    
    @Test // Caso 6
    public void testarRealocacao() {
    	lista.inserir(new Carro("AAA-1111","Maria"));
    	lista.inserir(new Carro("BBB-2222", "João"));
    	lista.inserir(new Carro("CCC-3333", "Ana"));
    	lista.inserir(new Carro("DDD-4444", "Pedro"));
    	lista.inserir(new Carro("EEE-5555", "Sofia"));
    	lista.inserir(new Carro("FFF-6666", "Luís"));
    	lista.inserir(new Carro("GGG-7777", "Inês"));
    	lista.inserir(new Carro("HHH-8888", "Miguel"));
    	lista.inserir(new Carro("III-9999", "Carolina"));
    	lista.inserir(new Carro("JJJ-0101", "Tiago"));
    	lista.inserir(new Carro("KKK-0202", "Catarina"));
    	lista.inserir(new Carro("LLL-0303", "André"));
    	lista.inserir(new Carro("MMM-0404", "Rita"));
    	lista.inserir(new Carro("NNN-0505", "Bruno"));

        assertEquals("AAA-1111, BBB-2222, CCC-3333, DDD-4444, EEE-5555, FFF-6666, GGG-7777, HHH-8888, III-9999, JJJ-0101, KKK-0202, LLL-0303, MMM-0404, NNN-0505", lista.toString());

        assertEquals(14, lista.getTamanho());
    }
    
    @Test // Caso 7
    public void testarObterElemento() {
    	Carro novoCarro = new Carro("DDD-4444", "Pedro");
    	lista.inserir(new Carro("AAA-1111","Maria"));
    	lista.inserir(new Carro("BBB-2222", "João"));
    	lista.inserir(new Carro("CCC-3333", "Ana"));
    	lista.inserir(novoCarro);

        Carro valorEncontrado = lista.obterElemento(3);
    	
    	assertEquals(novoCarro, valorEncontrado);
    }
    
    @Test // Caso 8
    public void testarObterElementoInexistente() {
    	assertThrows(IndexOutOfBoundsException.class, ()->{
        	lista.inserir(new Carro("AAA-1111","Maria"));
        	lista.inserir(new Carro("BBB-2222", "João"));
        	lista.inserir(new Carro("CCC-3333", "Ana"));
        	lista.inserir(new Carro("DDD-4444", "Pedro"));

        	lista.obterElemento(5);    		
    	});
    }
    
    @Test // Caso 9
    public void testarLiberar() {
    	lista.inserir(new Carro("AAA-1111","Maria"));
    	lista.inserir(new Carro("BBB-2222", "João"));
    	lista.inserir(new Carro("CCC-3333", "Ana"));
    	lista.inserir(new Carro("DDD-4444", "Pedro"));
        
        lista.liberar();
        boolean estaVazia = lista.estaVazia();
        assertEquals(true, estaVazia);
    }
}
