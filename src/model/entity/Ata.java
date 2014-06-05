package model.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import view.command.Imprimivel;

public class Ata implements Imprimivel, Identificavel {

	private int id;

	private HashMap<Integer,AtaVotacao> atasVotacoes;

	public Ata(int id, HashMap<Integer,AtaVotacao> atasVotacoes) {
		assert id >=0;
		assert atasVotacoes != null;
		assert !atasVotacoes.isEmpty();
		this.id = id;
		//Faz uma cópia raza, porém já é suficiente, pois Integer e AtaVotacao são imutáveis
		this.atasVotacoes = (HashMap<Integer,AtaVotacao>)atasVotacoes.clone();
	}
	
	@Override
	public int getId() {
		return this.id;
	}

	public List<AtaVotacao> getAtasVotacoes() {
		return Collections.unmodifiableList(new ArrayList<>(atasVotacoes.values()));
	}

	@Override
	public String getCodigoTela() {
		return "A";
	}

	@Override
	public String getDescricaoTela() {
		return "Ata";
	}

}
