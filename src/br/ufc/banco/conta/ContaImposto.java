package br.ufc.banco.conta;

import br.ufc.banco.conta.excecoes.SIException;

public class ContaImposto extends ContaAbstrata {

	public ContaImposto(String numero) {
		super(numero);
	}

	public void debitar(double valor) throws SIException {
		if (valor >= 0) {
			if (this.saldo >= valor)
				this.saldo = this.saldo - (valor + (valor * 0.001));
			else
				throw new SIException(numero, valor);
		}
		else
			System.out.println("Transação inválida: não é possível debitar com valor negativo");
	}
}
