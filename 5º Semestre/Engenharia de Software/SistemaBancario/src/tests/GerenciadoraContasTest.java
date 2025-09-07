package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import negocio.*;

public class GerenciadoraContasTest {

    private GerenciadoraContas gerContas;
    private ContaCorrente conta1;
    private ContaCorrente conta2;

    @BeforeEach
    public void setUp() {
    	List<ContaCorrente> contas = new ArrayList<>();
    	conta1 = new ContaCorrente(1, 1000.0, true);
        conta2 = new ContaCorrente(2, 2000.0, false);

        contas.add(conta1);
        contas.add(conta2);

        gerContas = new GerenciadoraContas(contas);
    }

    @Test
    public void testGetContasDoBanco() {
        List<ContaCorrente> contas = gerContas.getContasDoBanco();
        assertEquals(2, contas.size());
        
        assertTrue(contas.contains(conta1));
        assertEquals(1, conta1.getId());
        
        assertTrue(contas.contains(conta2));
        assertEquals(2, conta2.getId());
    }

    @Test
    public void testPesquisaContaExistente() {
        ContaCorrente conta = gerContas.pesquisaConta(1);
        assertNotNull(conta);
        assertEquals(1, conta.getId());
    }

    @Test
    public void testPesquisaContaInexistente() {
        ContaCorrente conta = gerContas.pesquisaConta(999);
        assertNull(conta);
    }

    @Test
    public void testAdicionaConta() {
        ContaCorrente novaConta = new ContaCorrente(3, 500.0, true);
        gerContas.adicionaConta(novaConta);

        assertEquals(3, gerContas.getContasDoBanco().size());
        assertTrue(gerContas.getContasDoBanco().contains(novaConta));
    }

    @Test
    public void testRemoveContaExistente() {
        boolean removida = gerContas.removeConta(1);
        assertTrue(removida);
        assertNull(gerContas.pesquisaConta(1));
    }

    @Test
    public void testRemoveContaInexistente() {
        boolean removida = gerContas.removeConta(999);
        assertFalse(removida);
        assertEquals(2, gerContas.getContasDoBanco().size());
    }

    @Test
    public void testContaAtivaComContaAtiva() {
        assertTrue(gerContas.contaAtiva(1));
    }

    @Test
    public void testContaAtivaComContaInativa() {
        assertFalse(gerContas.contaAtiva(2));
    }

    @Test
    public void testTransfereValorComSucesso() {
        boolean sucesso = gerContas.transfereValor(1, 200.0, 2);
        assertTrue(sucesso);
        assertEquals(800.0, conta1.getSaldo(), 0.01);
        assertEquals(2200.0, conta2.getSaldo(), 0.01);
    }

    @Test
    public void testTransfereValorContaOrigemInexistente() {
        boolean sucesso = gerContas.transfereValor(999, 100.0, 2);
        assertFalse(sucesso);
    }

    @Test
    public void testTransfereValorContaDestinoInexistente() {
        boolean sucesso = gerContas.transfereValor(1, 100.0, 999);
        assertFalse(sucesso);
    }

    @Test
    public void testTransfereValorSemSaldo() {
        conta1.setSaldo(50.0);
        boolean sucesso = gerContas.transfereValor(1, 100.0, 2);
        assertFalse(sucesso); 
    }
    
    @Test
    public void testTransfereValorSaldoNegativo() {
        conta1.setSaldo(50.0);
        boolean sucesso = gerContas.transfereValor(1, -100.0, 2);
        assertFalse(sucesso); 
    }
}
