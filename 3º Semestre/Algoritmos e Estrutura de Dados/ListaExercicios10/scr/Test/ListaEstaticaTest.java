package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import Questao.ListaEstatica;
import org.junit.jupiter.api.Test;

public class ListaEstaticaTest {

	
	private ListaEstatica<Integer> lista = new ListaEstatica<>();

	public void testeString() {
		ListaEstatica<String> nomes = new ListaEstatica<>();
		nomes.inserir("André");
		nomes.inserir("Ana");
		String primeiroNome = nomes.obterElemento(0);
		System.out.println(primeiroNome);

		ListaEstatica nomes2 = new ListaEstatica();
		nomes2.inserir("André");
		nomes2.inserir("Ana");
		String primeiroNomeLista2 = (String) nomes2.obterElemento(0);

	}
	
	@Test // caso 1
	public void testInclusaoItensLista() {
		ListaEstatica<Integer> lista = new ListaEstatica<>();
		lista.inserir(5); // lista.inserir( Integer.valueOf(5) );
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
			
		assertEquals("5,10,15,20", lista.toString());
	}
	
	
	@Test // caso 2
	public void testObtencaoTamanhoLista() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		assertEquals(4, lista.getTamanho());
	}
	
	
	@Test // caso 3
	public void testBuscarElementoExistente() {
		
		Integer t;
		
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		
		assertEquals(2, lista.buscar(15));

	}
	
	@Test // caso 4
	public void testBuscarElementoInexistente() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		
		assertEquals(-1, lista.buscar(30));
	}
	
	@Test // caso 5
	public void testRetirarElemento() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		
		lista.retirar(10);
		
		assertEquals("5,15,20", lista.toString());
	}	
	
	
	@Test // caso 6
	public void testRealocacao() {
		final int QTDE = 15;
		for (int i = 1; i<=QTDE; i++) {
			lista.inserir(i);
		}
		
		assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15", lista.toString());
		
		assertEquals(QTDE, lista.getTamanho());
	}
	
	
	@Test // caso 7
	public void testObterElemento() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		
		Object valorEncontrado = lista.obterElemento(3);
		
		assertEquals(20, valorEncontrado);
	}	
	
	
	
	@Test // caso 8
	public void testObterElementoInexistente() {
		assertThrows(IndexOutOfBoundsException.class, () ->{
			lista.inserir(5);
			lista.inserir(10);
			lista.inserir(15);
			lista.inserir(20);
			
			Object valorEncontrado = lista.obterElemento(5);
			
			assertEquals(20, valorEncontrado);
		});
	}
	
	
	@Test // caso 9
	public void testLiberacao() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		lista.liberar();
		
		assertEquals(true, lista.estaVazia());
	}
	
	
}
