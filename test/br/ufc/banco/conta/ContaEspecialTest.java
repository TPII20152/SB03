package br.ufc.banco.conta;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContaEspecialTest {
	
	@Test
	public void testContaEspecial() {
		String numero = "2345";
		ContaEspecial ce = new ContaEspecial(numero);
		assertEquals(numero, ce.obterNumero());
	}

	@Test
	public void testCreditarNormal() {
		ContaEspecial ce = new ContaEspecial("2345");
		ce.creditar(10.0);
		assertEquals(10.0, ce.obterSaldo(), 0);
	}
	
	@Test
	public void testCreditarNegativo() {
		ContaEspecial ce = new ContaEspecial("2345");
		ce.creditar(-10.0);
		assertEquals(0, ce.obterSaldo(), 0);
	}

	@Test
	public void testBonusNormal() {
		ContaEspecial ce = new ContaEspecial("2345");
		ce.creditar(10.0);
		assertEquals(0.1, ce.obterBonus(), 0);
	}
	
	@Test
	public void testBonusNegativo() {
		ContaEspecial ce = new ContaEspecial("2345");
		ce.creditar(-10.0);
		assertEquals(0, ce.obterBonus(), 0);
	}
	
	@Test
	public void testRendeBonus() {
		ContaEspecial ce = new ContaEspecial("2345");
		ce.creditar(10.0);
		System.out.println("Bonus acumulados: " + ce.obterBonus());
		ce.rendeBonus();
		assertEquals(10.1, ce.obterSaldo(), 0);
	}

	@Test
	public void testObterBonus() {
		ContaEspecial ce = new ContaEspecial("2345");
		ce.creditar(10.0);
		assertEquals(0.1, ce.obterBonus(), 0);
	}
}
