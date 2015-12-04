package br.ufc.banco.dados;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import br.ufc.banco.conta.Conta;
import br.ufc.banco.conta.ContaAbstrata;
import br.ufc.banco.dados.excecoes.CEException;
import br.ufc.banco.dados.excecoes.CIException;

public class VectorContasTest {

	@Test
	public void testVectorContas() {
		VectorContas vector = new VectorContas();
		assertEquals(0, vector.numeroContas(), 0);
	}

	@Test
	public void testApagar() throws CEException, CIException {
		VectorContas vector = new VectorContas();
		ContaAbstrata c1 = new Conta("1234");
		ContaAbstrata c2 = new Conta("2345");
		ContaAbstrata c3 = new Conta("3456");
		
		vector.inserir(c1);
		vector.inserir(c2);
		vector.inserir(c3);
		
		assertEquals(3, vector.numeroContas(), 0);
		
		vector.apagar("1234");
		
		assertEquals(2, vector.numeroContas(), 0);
	}

	@Test
	public void testInserir() throws CEException {
		VectorContas vector = new VectorContas();
		ContaAbstrata c1 = new Conta("1234");
		ContaAbstrata c2 = new Conta("2345");
		ContaAbstrata c3 = new Conta("3456");
		
		vector.inserir(c1);
		vector.inserir(c2);
		vector.inserir(c3);
		
		assertEquals(3, vector.numeroContas(), 0);
	}

	@Test
	public void testListar() throws CEException {
		VectorContas vector = new VectorContas();
		ContaAbstrata c1 = new Conta("1234");
		ContaAbstrata c2 = new Conta("2345");
		ContaAbstrata c3 = new Conta("3456");
		
		vector.inserir(c1);
		vector.inserir(c2);
		vector.inserir(c3);
		
		Vector<ContaAbstrata> lista = new Vector<ContaAbstrata>();		
		lista.addElement(c1);
		lista.addElement(c2);
		lista.addElement(c3);
		
		assertEquals(lista, vector.listar());
	}

	@Test
	public void testNumeroContas() throws CEException {
		VectorContas vector = new VectorContas();
		ContaAbstrata c1 = new Conta("1234");
		ContaAbstrata c2 = new Conta("2345");
		ContaAbstrata c3 = new Conta("3456");
		
		vector.inserir(c1);
		vector.inserir(c2);
		vector.inserir(c3);
		
		assertEquals(3, vector.numeroContas(), 0);
	}

	@Test
	public void testProcurar() throws CEException {
		VectorContas vector = new VectorContas();
		ContaAbstrata c1 = new Conta("1234");
		ContaAbstrata c2 = new Conta("2345");
		ContaAbstrata c3 = new Conta("3456");
		
		vector.inserir(c1);
		vector.inserir(c2);
		vector.inserir(c3);
		
		assertEquals(c2, vector.procurar("2345"));
	}

}
