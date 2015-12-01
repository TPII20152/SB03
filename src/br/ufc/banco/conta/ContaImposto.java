package br.ufc.banco.conta;


public class ContaImposto extends ContaAbstrata {

	public ContaImposto(String numero) {
		super(numero);
	}

	public void debitar(double valor) {
		if (valor >= 0)
			this.saldo = this.saldo - (valor + (valor * 0.001));
		else
			System.out.println("Transacao invalida: nao e possivel debitar com valor negativo");
	}
}
