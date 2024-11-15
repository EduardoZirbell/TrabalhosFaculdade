package exercicios.lista02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class ListaGenericaCarroTest {

    private ListaEstaticaGenerica<Carro> lista = new ListaEstaticaGenerica<>();

    @Test
    @Order(1)
    public void testInserir() {
        lista.inserir(new Carro("ABC-1234", "João"));
        lista.inserir(new Carro("DFG-5678", "José"));
        lista.inserir(new Carro("MMM-5555", "Maria"));
        lista.inserir(new Carro("AAA-1111", "Ana"));

        assertEquals("ABC-1234, DFG-5678, MMM-5555, AAA-1111", lista.toString());
    }

    @Test
    @Order(2)
    public void testarObterTamanho() {
    	lista.inserir(new Carro("ABC-1234", "João"));
        lista.inserir(new Carro("DFG-5678", "José"));
        lista.inserir(new Carro("MMM-5555", "Maria"));
        lista.inserir(new Carro("AAA-1111", "Ana"));
        
        assertEquals(4, lista.getTamanho());
    }

    @Test
    @Order(3)
    public void testarBuscarValorExistente() {
    	lista.inserir(new Carro("ABC-1234", "João"));
        lista.inserir(new Carro("DFG-5678", "José"));
        lista.inserir(new Carro("MMM-5555", "Maria"));
        lista.inserir(new Carro("AAA-1111", "Ana"));

        assertEquals(1, lista.buscar(new Carro("DFG-5678", "José")));
    }

    @Test
    @Order(4)
    public void testBuscarValorInexistente() {
    	lista.inserir(new Carro("ABC-1234", "João"));
        lista.inserir(new Carro("DFG-5678", "José"));
        lista.inserir(new Carro("MMM-5555", "Maria"));
        lista.inserir(new Carro("AAA-1111", "Ana"));

        assertEquals(-1, lista.buscar(new Carro("MMM-1234", "José")));
    }

    @Test
    @Order(5)
    public void testRetirarValor() {
    	lista.inserir(new Carro("ABC-1234", "João"));
        lista.inserir(new Carro("DFG-5678", "José"));
        lista.inserir(new Carro("MMM-5555", "Maria"));
        lista.inserir(new Carro("AAA-1111", "Ana"));

        lista.retirar(new Carro("MMM-5555", "Maria"));

        assertEquals("ABC-1234, DFG-5678, AAA-1111", lista.toString());

        assertEquals(3, lista.getTamanho());
    }

    @Test
    @Order(6)
    public void testarRedimensionamento() {
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

    @Test
    @Order(7)
    public void testarObterElementoExistente() {
    	lista.inserir(new Carro("AAA-1111","Maria"));
    	lista.inserir(new Carro("BBB-2222", "João"));
    	lista.inserir(new Carro("CCC-3333", "Ana"));
    	
    	Carro carroEsperado = new Carro("DDD-4444", "Pedro");
    	lista.inserir(carroEsperado);
		
    	Carro novoCarro = new Carro("DDD-4444", "Pedro");

        Carro valorEncontrado = lista.obterElemento(3);

        assertEquals(novoCarro, valorEncontrado);
    }

    @Test
    @Order(8)
    public void testarObterElementoInexistente() {
    	
    	assertThrows(IndexOutOfBoundsException.class, () -> {
        	lista.inserir(new Carro("AAA-1111","Maria"));
        	lista.inserir(new Carro("BBB-2222", "João"));
        	lista.inserir(new Carro("CCC-3333", "Ana"));
        	lista.inserir(new Carro("DDD-4444", "Pedro"));
  
    		lista.obterElemento(5);
    	});
    }

    @Test
    @Order(9)
    public void testarLiberar() {
    	lista.inserir(new Carro("AAA-1111","Maria"));
    	lista.inserir(new Carro("BBB-2222", "João"));
    	lista.inserir(new Carro("CCC-3333", "Ana"));
    	lista.inserir(new Carro("DDD-4444", "Pedro"));
        
        lista.liberar();

        assertEquals(true, lista.estaVazia());
    }

    @Test
    @Order(10)
    public void testarInverterComPares() {
    	lista.inserir(new Carro("AAA-1111", "João"));
        lista.inserir(new Carro("BBB-2222", "José"));
        lista.inserir(new Carro("CCC-3333", "Maria"));
        lista.inserir(new Carro("DDD-4444", "Ana"));

        lista.inverter();
        
        assertEquals("DDD-4444, CCC-3333, BBB-2222, AAA-1111", lista.toString());
    }
    
    @Test
    @Order(11)
    public void testarInverterComImpar() {
    	lista.inserir(new Carro("AAA-1111", "João"));
        lista.inserir(new Carro("BBB-2222", "José"));
        lista.inserir(new Carro("CCC-3333", "Maria"));
        lista.inserir(new Carro("DDD-4444", "José"));
        lista.inserir(new Carro("EEE-5555", "Maria"));

        lista.inverter();
        
        assertEquals("EEE-5555, DDD-4444, CCC-3333, BBB-2222, AAA-1111", lista.toString());
    }

}