package model.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AtaVotacao implements Identificavel{

	private int id;

	private String descricao;
	
	private Date dataInicio;

	private Date dataFim;

	private ArrayList<Voto> votos;

	private Votacao votacao;

	private ArrayList<Membro> votantes;

	private ArrayList<Membro> naoVotantes;

	private ArrayList<Membro> abstencoes;
	
	private boolean resultado;

	public AtaVotacao(int id, Votacao votacao, List<Membro> votantes, List<Membro> naoVotantes) {
		assert id >= 0;
		assert votacao != null;
		assert votantes != null;
		assert naoVotantes != null;
		
		this.id = id;
		this.votacao = votacao;
		this.votantes = new ArrayList<>(votantes);
		this.naoVotantes = new ArrayList<>(naoVotantes);
		this.dataInicio = votacao.getDataInicio();
		this.dataFim = votacao.getDataFim();
		this.votos = new ArrayList<Voto>(votacao.getVotos());
		
		this.abstencoes = new ArrayList<>();
		for (Voto voto : this.votos){
			if (voto.getTipo() == TipoVoto.Abstencao){
				this.abstencoes.add(voto.getAutor());
			}
		}
		this.resultado = getQtdVotosFavoriaveis() > getQtdVotosNaoFavoriaveis();

		this.descricao = "[AtaVotacao]:{id:"+this.id+",inicio:"+this.dataInicio+",fim:"+this.dataFim+",resultado:"+this.resultado;
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
		return descricao;
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
		return Collections.unmodifiableList(votos);
	}

	public boolean getResultado() {
		return resultado;
	}

	public Votacao getVotacao() {
		return votacao;
	}
	
	public int getQtdVotosFavoriaveis() {
		Integer count = 0;
		for (Voto voto : votos){
			if (voto.getTipo() == TipoVoto.Favoravel){
				count++;
			}
		}
		return count;
	}

	public int getQtdVotosNaoFavoriaveis() {
		Integer count = 0;
		for (Voto voto : votos){
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
