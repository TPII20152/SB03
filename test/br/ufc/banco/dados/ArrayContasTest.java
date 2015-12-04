package br.ufc.banco.dados;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import br.ufc.banco.conta.Conta;
import br.ufc.banco.conta.ContaAbstrata;
import br.ufc.banco.dados.excecoes.CEException;
import br.ufc.banco.dados.excecoes.CIException;

public class ArrayContasTest {

	@Test
	public void testArrayContas() {
		ArrayContas array = new ArrayContas();
		assertEquals(0, array.numeroContas(), 0);
	}

	@Test
	public void testApagar() throws CEException, CIException {
		ContaAbstrata c1 = new Conta("1234");
		ContaAbstrata c2 = new Conta("2345");
		ContaAbstrata c3 = new Conta("3456");
		ArrayContas array = new ArrayContas();
		
		array.inserir(c1);
		array.inserir(c2);
		array.inserir(c3);
		
		assertEquals(3, array.numeroContas(), 0);
		
		array.apagar("1234");
		
		assertEquals(2, array.numeroContas(), 0);
	}

	@Test
	public void testInserir() throws CEException {
		ContaAbstrata c1 = new Conta("1234");
		ContaAbstrata c2 = new Conta("2345");
		ContaAbstrata c3 = new Conta("3456");
		ArrayContas array = new ArrayContas();
		
		array.inserir(c1);
		array.inserir(c2);
		array.inserir(c3);
		
		assertEquals(3, array.numeroContas(), 0);
	}

	@Test
	public void testListar() throws CEException {
		ContaAbstrata c1 = new Conta("1234");
		ContaAbstrata c2 = new Conta("2345");
		ContaAbstrata c3 = new Conta("3456");
		ArrayContas array = new ArrayContas();
		
		array.inserir(c1);
		array.inserir(c2);
		array.inserir(c3);
	
		ArrayList<ContaAbstrata> lista = new ArrayList<ContaAbstrata>();
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		
		assertEquals(lista, array.listar());
	}

	@Test
	public void testNumeroContas() throws CEException {
		ContaAbstrata c1 = new Conta("1234");
		ContaAbstrata c2 = new Conta("2345");
		ArrayContas array = new ArrayContas();
		
		array.inserir(c1);
		array.inserir(c2);
		
		assertEquals(2, array.numeroContas(), 0);
	}

	@Test
	public void testProcurar() throws CEException {
		ContaAbstrata c1 = new Conta("1234");
		ContaAbstrata c2 = new Conta("2345");
		ContaAbstrata c3 = new Conta("3456");
		ArrayContas array = new ArrayContas();
		
		array.inserir(c1);
		array.inserir(c2);
		array.inserir(c3);
		
		assertEquals(c1, array.procurar("1234"));
	}
}
