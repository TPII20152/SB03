package br.ufc.banco.conta;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContaPoupancaTest {

	@Test
	public void testContaPoupanca() {
		String numero = "3456";
		ContaPoupanca cp = new ContaPoupanca(numero);
		assertEquals(numero, cp.obterNumero());
	}

	@Test
	public void testRendeJuros() {
		double taxaJuros = 0.01;
		ContaPoupanca cp = new ContaPoupanca("3456");
		cp.creditar(10.0);
		cp.rendeJuros(taxaJuros);
		assertEquals(10.1, cp.obterSaldo(), 0);
	}

}
