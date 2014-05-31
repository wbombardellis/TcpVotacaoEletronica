package model.entity;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AtaVotacao {

	private int id;

	private String descricao;

	private boolean resultado;

	private Date dataInicio;

	private Date dataFim;

	private ArrayList votos;

	private Votacao votacao;

	private HashMap hashMap;

	private List votantes;

	private List naoVotantes;

	private List abstencoes;

	public AtaVotacao(Votacao votacao, List<Membro> votantes, List<Membro> naoVotantes) {

	}

	public int getId() {
		return 0;
	}

	public Date getDataInicio() {
		return null;
	}

	public Date getDataFim() {
		return null;
	}

	public String getDescricao() {
		return null;
	}

	public List<Membro> getVotantes() {
		return null;
	}

	public List<Membro> getNaoVotantes() {
		return null;
	}

	public List<Membro> getAbstencoes() {
		return null;
	}

	public List<Voto> getVotos() {
		return null;
	}

	public boolean getResultado() {
		return false;
	}

	public Votacao getVotacao() {
		return null;
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
