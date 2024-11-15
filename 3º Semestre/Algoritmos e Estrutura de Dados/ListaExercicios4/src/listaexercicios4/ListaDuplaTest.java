package listaexercicios4;

import org.junit.jupiter.api.Test;

public class ListaDuplaTest {

    private ListaDupla<T> lista = new ListaDupla<>;

    @Test // Caso 1
    public void testInclusaoItensLista() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals("5,10,15,20", lista.toString());
    }

    @Test // Caso 2
    public void testarObtencaoTamanhoLista() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(4, lista.getTamanho());
    }

    @Test // Caso 3
    public void testarBuscarElementoExistente() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(2, lista.buscar(15));
    }

    @Test // Caso 4
    public void testBuscarElementoInexistente() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(-1, lista.buscar(30));
    }

    @Test // Caso 5
    public void testRetirarElemento() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(10);

        assertEquals("5,15,20", lista.toString());

        assertEquals(3, lista.getTamanho());
    }

    @Test // Caso 6
    public void testarRealocacao() {
        final int QTDE = 15;
        for (int i = 1; i <= QTDE; i++) {
            lista.inserir(i);
        }

        assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15", lista.toString());

        assertEquals(QTDE, lista.getTamanho());
    }

    @Test // Caso 7
    public void testarObterElemento() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        int valorEncontrado = lista.obterElemento(3);

        assertEquals(20, valorEncontrado);
    }

    @Test // Caso 8
    public void testarObterElementoInexistente() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            lista.inserir(5);
            lista.inserir(10);
            lista.inserir(15);
            lista.inserir(20);

            lista.obterElemento(5);
        });
    }

    @Test // Caso 9
    public void testarLiberar() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.liberar();
        boolean estaVazia = lista.estarVazia();
        assertEquals(true, estaVazia);
    }
}
