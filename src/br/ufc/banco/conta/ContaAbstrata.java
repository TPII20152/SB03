package br.ufc.banco.conta;

import br.ufc.banco.conta.excecoes.SIException;


public abstract class ContaAbstrata {

	protected String numero;
	protected double saldo;

	public ContaAbstrata(String numero) {
		this.numero = numero;
		saldo = 0;
	}

	public void creditar(double valor) {
		if (valor >= 0)
			saldo = saldo + valor;
		else
			System.out.println("Transacao nao permitida: credito de valor negativo");
	}

	public abstract void debitar(double valor) throws SIException;

	public String obterNumero() {
		return numero;
	}

	public double obterSaldo() {
		return saldo;
	}
}
