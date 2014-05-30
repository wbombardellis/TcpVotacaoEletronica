package model.dao;

import java.util.HashMap;
import java.util.List;

import model.entity.Estado;
import model.entity.Votacao;

public class VotacaoDao extends AbstractDao<Votacao> {

	private static VotacaoDao instance = null;

	public static VotacaoDao getInstance() {
		return null;
	}

	public List<Votacao> getVotacoesByEstado(List<Estado> estados) {
		return null;
	}

	public List<Votacao> getVotacoesSemAta() {
		return null;
	}

	public List<Votacao> getVotacoesByEstadoNot(List<Estado> estados) {
		return null;
	}

}
