package br.ufc.banco.dados;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

import br.ufc.banco.conta.ContaAbstrata;
import br.ufc.banco.dados.excecoes.CEException;
import br.ufc.banco.dados.excecoes.CIException;

public class Persistencia implements IRepositorioContas {

	XStream xstream = new XStream();
	PersistenceStrategy strategy = new FilePersistenceStrategy(new File("/data"));
	List list = new XmlArrayList(strategy);
	
	@Override
	public void inserir(ContaAbstrata conta) throws CEException {
		if (!list.contains(conta)) {
			list.add(conta);
		} else {
			throw new CEException(conta.obterNumero());
		}		
	}

	@Override
	public void apagar(String numero) throws CIException {
		if (list.contains(numero)) {
			list.remove(numero);
		} else {
			throw new CIException(numero);
		}
		
	}

	@Override
	public ContaAbstrata procurar(String numero) {
		ContaAbstrata conta = null;
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				conta = (ContaAbstrata) list.get(i);
				if (list.equals(numero)) {
					return conta;
				}
			}
		}
		return null;
	}

	@Override
	public ArrayList<ContaAbstrata> listar() {
		ArrayList<ContaAbstrata> lista = null;
		if (list.size() > 0) {
			lista = new ArrayList<ContaAbstrata>(list.size());
			for (int i = 0; i < list.size(); i++) {
				lista.add((ContaAbstrata) list.get(i));
			}
		}
		return lista;
	}

	@Override
	public int numeroContas() {
		return list.size();
	}

}
