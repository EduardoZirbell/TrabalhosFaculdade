package exercicios.lista02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class ListaGenericaIntTest {

    private ListaEstaticaGenerica<Integer> lista = new ListaEstaticaGenerica<>();

    @Test
    @Order(1)
    public void testInserir() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals("5, 10, 15, 20", lista.toString());
    }

    @Test
    @Order(2)
    public void testarObterTamanho() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        assertEquals(4, lista.getTamanho());
    }

    @Test
    @Order(3)
    public void testarBuscarValorExistente() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(2, lista.buscar(15));
    }

    @Test
    @Order(4)
    public void testBuscarValorInexistente() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(-1, lista.buscar(30));
    }

    @Test
    @Order(5)
    public void testRetirarValor() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(10);

        assertEquals("5, 15, 20", lista.toString());

        assertEquals(3, lista.getTamanho());
    }

    @Test
    @Order(6)
    public void testarRedimensionamento() {
        final int QTDE = 15;
     
        for (int valor = 1; valor <= QTDE; valor++) {
            lista.inserir(valor);
        }

        assertEquals("1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15", lista.toString());

        assertEquals(QTDE, lista.getTamanho());
    }

    @Test
    @Order(7)
    public void testarObterElementoExistente() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        int valorEncontrado = lista.obterElemento(3);

        assertEquals(20, valorEncontrado);
    }

    @Test
    @Order(8)
    public void testarObterElementoInexistente() {
    	
    	assertThrows(IndexOutOfBoundsException.class, () -> {
    		lista.inserir(5);
    		lista.inserir(10);
    		lista.inserir(15);
    		lista.inserir(20);
  
    		lista.obterElemento(5);
    	});
    }

    @Test
    @Order(9)
    public void testarLiberar() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        
        lista.liberar();

        assertEquals(true, lista.estaVazia());
    }

    
    @Test
    @Order(10)
    public void testarInverterComPares() {
    	lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.inverter();
        
        assertEquals("20, 15, 10, 5", lista.toString());
    }
    
    @Test
    @Order(11)
    public void testarInverterComImpar() {
    	lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);

        lista.inverter();
        
        assertEquals("15, 10, 5", lista.toString());
    }

}