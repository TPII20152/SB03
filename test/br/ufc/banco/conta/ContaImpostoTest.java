package br.ufc.banco.conta;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.banco.conta.excecoes.SIException;

public class ContaImpostoTest {
	
	@Test
	public void testContaImposto() {
		String numero = "4567";
		ContaImposto ci = new ContaImposto(numero);
		assertEquals(numero, ci.obterNumero());
	}

	@Test
	public void testDebitarNormal() throws SIException {
		ContaImposto ci = new ContaImposto("4567");
		ci.creditar(10.0);
		ci.debitar(4.0);
		assertEquals(5.996, ci.obterSaldo(), 0);
	}
	
	@Test
	public void testDebitarNegativo() throws SIException {
		ContaImposto ci = new ContaImposto("4567");
		ci.creditar(10.0);
		ci.debitar(-4.0);
		assertEquals(10.0, ci.obterSaldo(), 0);
	}
}
