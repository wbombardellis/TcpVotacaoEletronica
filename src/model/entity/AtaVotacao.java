package model.entity;

import java.util.Collections;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AtaVotacao implements Identificavel{

	private int id;

	private String descricao;
	
	private Date dataInicio;

	private Date dataFim;

	private HashMap<Integer, Voto> votos;

	private Votacao votacao;

	private ArrayList<Membro> votantes;

	private ArrayList<Membro> naoVotantes;

	private ArrayList<Membro> abstencoes;

	public AtaVotacao(int id, Votacao votacao, List<Membro> votantes, List<Membro> naoVotantes) {
		this.id = id;
		this.votacao = votacao;
		this.votantes = new ArrayList<Membro>(votantes);
		this.naoVotantes = new ArrayList<Membro>(naoVotantes);
	}

	public int getId() {
		return id;
	}

	public Date getDataInicio() {
		return (Date)dataInicio.clone();
	}

	public Date getDataFim() {
		return (Date)dataFim.clone();
	}

	public String getDescricao() {
		return null;
	}

	public List<Membro> getVotantes() {
		return Collections.unmodifiableList(votantes);
	}

	public List<Membro> getNaoVotantes() {
		return Collections.unmodifiableList(naoVotantes);
	}

	public List<Membro> getAbstencoes() {
		return Collections.unmodifiableList(abstencoes);
	}

	public List<Voto> getVotos() {
		return Collections.unmodifiableList(new ArrayList<Voto>(votos.values()));
	}

	public boolean getResultado() {
		return getQtdVotosFavoriaveis() > getQtdVotosNaoFavoriaveis();
	}

	public Votacao getVotacao() {
		return votacao;
	}
	
	public Integer getQtdVotosFavoriaveis() {
		Integer count = 0;
		for (Voto voto : votos.values()){
			if (voto.getTipo() == TipoVoto.Favoravel){
				count++;
			}
		}
		return count;
	}

	public Integer getQtdVotosNaoFavoriaveis() {
		Integer count = 0;
		for (Voto voto : votos.values()){
			if (voto.getTipo() == TipoVoto.NaoFavoravel){
				count++;
			}
		}
		return count;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AtaVotacao other = (AtaVotacao) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
