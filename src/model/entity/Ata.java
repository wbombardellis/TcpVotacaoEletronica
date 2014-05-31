package model.entity;

import java.util.HashMap;
import java.util.List;

import view.command.Imprimivel;

public class Ata implements Imprimivel, Identificavel {

	private int id;

	private HashMap<Integer,AtaVotacao> atasVotacoes;

	public Ata(HashMap<Integer,AtaVotacao> atasVotacoes) {

	}

	public List<String> getDescricao() {
		return null;
	}

	public List<AtaVotacao> getAtasVotacoes() {
		return null;
	}

	@Override
	public String getCodigoTela() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescricaoTela() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void imprimeOpcaoTela() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getId() {
		return this.id;
	}

}
