package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import negocio.*;

class GerenciadoraClientesTest {

	private GerenciadoraClientes gerClientes;
    private Cliente cliente1;
    private Cliente cliente2;
    
	@BeforeEach
	public void setUp() throws Exception {
		List<ContaCorrente> contas = new ArrayList<>();
		List<Cliente> clientes = new ArrayList<>();
		ContaCorrente conta1 = new ContaCorrente(1, 500, true);
		ContaCorrente conta2 = new ContaCorrente(2, 1000, false);
		contas.add(conta1);
		contas.add(conta2);
		
		Cliente cliente1 = new Cliente(1, "João Souza", 25, "joaosouza@gmail.com", conta1.getId(), true);
		Cliente cliente2 = new Cliente(2, "Maria da Silva", 17, "mariadasilva@gmail.com", conta2.getId(), false);
		clientes.add(cliente1);
		clientes.add(cliente2);
		
		gerClientes = new GerenciadoraClientes(clientes);
	}

	@Test
	void testGetClientesDoBanco() {
		List<Cliente> clientes = gerClientes.getClientesDoBanco();
		assertEquals(2, clientes.size());
		
		Cliente clienteTest1 = clientes.get(0);
		Cliente clienteTest2 = clientes.get(1);
		assertTrue(clientes.contains(clienteTest1));
        assertEquals(1, clienteTest1.getId());
        assertEquals("João Souza", clienteTest1.getNome());

        assertTrue(clientes.contains(clienteTest2));
        assertEquals(2, clienteTest2.getId());
        assertEquals("Maria da Silva", clienteTest2.getNome());
	}

	@Test
	void testPesquisaClienteExistente() {
		Cliente cliente = gerClientes.pesquisaCliente(2);
	    assertNotNull(cliente);
	    assertEquals(2, cliente.getId());
	    assertEquals("Maria da Silva", cliente.getNome());
	}

	@Test
	void testPesquisaClienteInexistente() {
		Cliente cliente = gerClientes.pesquisaCliente(999);
	    assertNull(cliente);
	}
	
	@Test
    public void testClienteAtivo() {
        assertTrue(gerClientes.clienteAtivo(1));
    }

    @Test
    public void testClienteInativo() {
        assertFalse(gerClientes.clienteAtivo(2));
    }
	
    @Test
    public void testLimpaListaClientes() {
        gerClientes.limpa();
        assertEquals(0, gerClientes.getClientesDoBanco().size());
    }
    
    @Test
    public void testValidaIdadeValida() throws IdadeNaoPermitidaException {
        assertTrue(gerClientes.validaIdade(25));
    }

    @Test
    public void testValidaIdadeInvalidaMenor() {
        assertThrows(IdadeNaoPermitidaException.class, () -> gerClientes.validaIdade(17));
    }

    @Test
    public void testValidaIdadeInvalidaMaior() {
        assertThrows(IdadeNaoPermitidaException.class, () -> gerClientes.validaIdade(70));
    }
    
    @Test
    public void testAdicionaCliente() {
        Cliente novoCliente = new Cliente(3, "Ana", 25, "ana@email.com", 1003, true);
        gerClientes.adicionaCliente(novoCliente);

        List<Cliente> clientes = gerClientes.getClientesDoBanco();
        assertEquals(3, clientes.size());

        Cliente c3 = clientes.get(2);
        assertEquals(novoCliente.getNome(), c3.getNome());
        assertEquals(novoCliente.getIdade(), c3.getIdade());
    }

    @Test
    public void testRemoveClienteExistente() {
        boolean removido = gerClientes.removeCliente(1);
        assertTrue(removido);
        assertEquals(1, gerClientes.getClientesDoBanco().size());
    }

}
