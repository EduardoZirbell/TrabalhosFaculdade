package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Questao.ListaAbstract;
import Questao.ListaOrdenada;
import org.junit.jupiter.api.Test;

public class ListaOrdenadaTest {

	private ListaAbstract<Integer> lista = new ListaOrdenada<>();

	@Test
	public void testInserirMantemDados() {
 		lista.inserir(100);
		lista.inserir(20);
		lista.inserir(70);
		lista.inserir(1);
		assertEquals( "1,20,70,100", lista.toString() );
	}

	@Test
	public void testBuscar1() {
		lista.inserir(0);
		lista.inserir(10);
		lista.inserir(20);
		lista.inserir(30);
		lista.inserir(40);
		lista.inserir(50);
		lista.inserir(60);
		lista.inserir(70);
		lista.inserir(80);
		lista.inserir(90);
		lista.inserir(100);
		assertEquals(2, lista.buscar(20));
	}
	@Test
	public void testBuscar2() {
		lista.inserir(0);
		lista.inserir(10);
		lista.inserir(20);
		lista.inserir(30);
		lista.inserir(40);
		lista.inserir(50);
		lista.inserir(60);
		lista.inserir(70);
		lista.inserir(80);
		lista.inserir(90);
		lista.inserir(100);
		assertEquals(4, lista.buscar(40));
	}
	@Test
	public void testBuscar3() {
		lista.inserir(0);
		lista.inserir(10);
		lista.inserir(20);
		lista.inserir(30);
		lista.inserir(40);
		lista.inserir(50);
		lista.inserir(60);
		lista.inserir(70);
		lista.inserir(80);
		lista.inserir(90);
		lista.inserir(100);
		assertEquals(7, lista.buscar(70));
	}
	@Test
	public void testBuscar4() {
		lista.inserir(0);
		lista.inserir(10);
		lista.inserir(20);
		lista.inserir(30);
		lista.inserir(40);
		lista.inserir(50);
		lista.inserir(60);
		lista.inserir(70);
		lista.inserir(80);
		lista.inserir(90);
		lista.inserir(100);
		assertEquals(10, lista.buscar(100));
	}
	@Test
	public void testBuscar5() {
		lista.inserir(0);
		lista.inserir(10);
		lista.inserir(20);
		lista.inserir(30);
		lista.inserir(40);
		lista.inserir(50);
		lista.inserir(60);
		lista.inserir(70);
		lista.inserir(80);
		lista.inserir(90);
		lista.inserir(100);
		assertEquals(-1, lista.buscar(85));
	}

}
