package br.ufc.banco.bb;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.banco.bb.excecoes.TNRException;
import br.ufc.banco.conta.Conta;
import br.ufc.banco.conta.ContaAbstrata;
import br.ufc.banco.conta.ContaEspecial;
import br.ufc.banco.conta.ContaPoupanca;
import br.ufc.banco.conta.excecoes.SIException;
import br.ufc.banco.dados.VectorContas;
import br.ufc.banco.dados.excecoes.CEException;
import br.ufc.banco.dados.excecoes.CIException;

public class BancoBrasilTest {

	@Test
	public void testBancoBrasil() {
		BancoBrasil bb = new BancoBrasil(new VectorContas());
		assertEquals(0, bb.numeroContas(), 0);
	}

	@Test
	public void testCadastrar() throws CEException {
		ContaAbstrata c1 = new Conta("1234");
		ContaAbstrata c2 = new Conta("2345");
		VectorContas vector = new VectorContas();
		BancoBrasil bb = new BancoBrasil(vector);
		
		bb.cadastrar(c1);
		bb.cadastrar(c2);
		
		assertEquals(2, bb.numeroContas(), 0);
	}

	@Test
	public void testRemover() throws CEException, CIException {
		ContaAbstrata c1 = new Conta("1234");
		ContaAbstrata c2 = new Conta("2345");
		VectorContas vector = new VectorContas();
		BancoBrasil bb = new BancoBrasil(vector);
		
		bb.cadastrar(c1);
		bb.cadastrar(c2);
		
		assertEquals(2, bb.numeroContas(), 0);
		
		bb.remover(c1.obterNumero());
		
		assertEquals(1, bb.numeroContas(), 0);
	}

	@Test
	public void testCreditar() throws CEException, TNRException {
		ContaAbstrata c1 = new Conta("1234");
		VectorContas vector = new VectorContas();
		BancoBrasil bb = new BancoBrasil(vector);
		
		bb.cadastrar(c1);
		bb.creditar(c1.obterNumero(), 10.0);
		
		assertEquals(10.0, c1.obterSaldo(), 0);
	}

	@Test
	public void testDebitar() throws CEException, SIException, TNRException {
		ContaAbstrata c1 = new Conta("1234");
		VectorContas vector = new VectorContas();
		BancoBrasil bb = new BancoBrasil(vector);
		
		bb.cadastrar(c1);
		
		bb.creditar(c1.obterNumero(), 10.0);		
		bb.debitar(c1.obterNumero(), 4.0);
		
		assertEquals(6.0, c1.obterSaldo(), 0);
	}

	@Test
	public void testSaldo() throws CEException, TNRException {
		ContaAbstrata c1 = new Conta("1234");
		VectorContas vector = new VectorContas();
		BancoBrasil bb = new BancoBrasil(vector);
		
		bb.cadastrar(c1);
		
		c1.creditar(10.0);

		assertEquals(10.0, bb.saldo(c1.obterNumero()), 0);
	}

	@Test
	public void testTransferir() throws CEException, TNRException {
		ContaAbstrata c1 = new Conta("1234");
		ContaAbstrata c2 = new Conta("2345");
		VectorContas vector = new VectorContas();
		BancoBrasil bb = new BancoBrasil(vector);
		
		bb.cadastrar(c1);
		bb.cadastrar(c2);
		
		c1.creditar(10.0);
		c2.creditar(10.0);
		
		bb.transferir(c1.obterNumero(), c2.obterNumero(), 4.0);
		
		assertEquals(6.0,  c1.obterSaldo(), 0);
		assertEquals(14.0, c2.obterSaldo(), 0);
		
	}

	@Test(expected = TNRException.class)
	public void testRenderJuros() throws CEException, TNRException {
		ContaAbstrata c1 = new Conta("1234");
		ContaAbstrata c2 = new ContaPoupanca("2345");
		VectorContas vector = new VectorContas();
		BancoBrasil bb = new BancoBrasil(vector);
		
		bb.cadastrar(c1);
		bb.cadastrar(c2);
		c2.creditar(10.0);
		
		bb.renderJuros(c1.obterNumero());
		assertEquals(0, c1.obterSaldo(), 0);
		
		bb.renderJuros(c2.obterNumero());
		assertEquals(10.1, c2.obterSaldo(), 0);
	}

	@Test(expected = TNRException.class)
	public void testRenderBonus() throws CEException, TNRException {
		ContaAbstrata c1 = new Conta("1234");
		ContaAbstrata c2 = new ContaEspecial("2345");
		VectorContas vector = new VectorContas();
		BancoBrasil bb = new BancoBrasil(vector);
		
		bb.cadastrar(c1);
		bb.cadastrar(c2);
		c2.creditar(10.0);
		
		bb.renderBonus(c1.obterNumero());
		assertEquals(0, c1.obterSaldo(), 0);
		
		bb.renderBonus(c2.obterNumero());
		assertEquals(10.1, c2.obterSaldo(), 0);
	}

	@Test
	public void testNumeroContas() throws CEException {
		ContaAbstrata c1 = new Conta("1234");
		ContaAbstrata c2 = new Conta("2345");
		ContaAbstrata c3 = new Conta("3456");
		VectorContas vector = new VectorContas();
		BancoBrasil bb = new BancoBrasil(vector);
		
		bb.cadastrar(c1);
		bb.cadastrar(c2);
		bb.cadastrar(c3);
		
		assertEquals(3, bb.numeroContas(), 0);
	}

	@Test
	public void testSaldoTotal() throws CEException {
		ContaAbstrata c1 = new Conta("1234");
		ContaAbstrata c2 = new Conta("2345");
		ContaAbstrata c3 = new Conta("3456");
		VectorContas vector = new VectorContas();
		BancoBrasil bb = new BancoBrasil(vector);
		
		bb.cadastrar(c1);
		bb.cadastrar(c2);
		bb.cadastrar(c3);
		
		c1.creditar(10.0);
		c2.creditar(20.0);
		c3.creditar(25.0);
		
		assertEquals(55.0, bb.saldoTotal(), 0);
	}

}
