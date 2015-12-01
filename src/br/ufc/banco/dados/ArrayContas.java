package br.ufc.banco.dados;

import java.util.ArrayList;

import br.ufc.banco.conta.ContaAbstrata;
import br.ufc.banco.dados.excecoes.CEException;
import br.ufc.banco.dados.excecoes.CIException;

public class ArrayContas implements IRepositorioContas {

	private ArrayList<ContaAbstrata> contas = null;

	public ArrayContas() {
		this.contas = new ArrayList<ContaAbstrata>();
	}

	public void apagar(String numero) throws CIException {
		if (this.procurar(numero) != null) {
			for (int i = 0; i < contas.size(); i++) {
				if (!contas.isEmpty() && contas.get(i).equals(numero))
					contas.remove(i);
			}
		}
		else {
			throw new CIException(numero);
		}
	}

	public void inserir(ContaAbstrata conta) throws CEException {
		if (this.procurar(conta.obterNumero()) == null) {
			contas.add(conta);
		} else {
			throw new CEException(conta.obterNumero());
		}
	}

	public ArrayList<ContaAbstrata> listar() {
		ArrayList<ContaAbstrata> lista = new ArrayList<ContaAbstrata>();
		for (int i = 0; i < contas.size(); i++) {
			lista.add(contas.get(i));
		}
		
		return lista;
	}

	public int numeroContas() {
		return contas.size();
	}

	public ContaAbstrata procurar(String numero) {
		for (int i = 0; i < contas.size(); i++) {
			if (!contas.isEmpty() && contas.get(i).equals(numero)) {
				return contas.get(i);
			}
		}
		return null;
	}
}
