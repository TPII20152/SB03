package br.ufc.banco.conta;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.banco.conta.excecoes.SIException;

public class ContaTest {

	@Test
	public void testConta() {
		String numero = "1234";
		Conta conta = new Conta(numero);
		assertEquals(numero, conta.obterNumero());
	}

	@Test
	public void testCreditarNormal() {
		Conta conta = new Conta("1234");
		conta.creditar(10.0);
		assertEquals(10.0, conta.obterSaldo(), 0);
	}
	
	@Test
	public void testCreditarNegativo() {
		Conta conta = new Conta("1234");
		conta.creditar(-10.0);
		assertEquals(0, conta.obterSaldo(), 0);
	}

	@Test
	public void testDebitarNormal() throws SIException {
		Conta conta = new Conta("1234");
		conta.creditar(10.0);
		conta.debitar(4.0);
		assertEquals(6.0, conta.obterSaldo(), 0);
	}
	
	@Test
	public void testDebitarNegativo() throws SIException {
		Conta conta = new Conta("1234");
		conta.creditar(10.0);
		conta.debitar(-4.0);
		assertEquals(10.0, conta.obterSaldo(), 0);
	}
	
	@Test
	public void testObterNumero() {
		String numero = "1234";
		Conta conta = new Conta(numero);
		assertEquals(numero, conta.obterNumero());
	}

	@Test
	public void testObterSaldo() {
		Conta conta = new Conta("1234");
		assertEquals(0, conta.obterSaldo(), 0);
	}

}
