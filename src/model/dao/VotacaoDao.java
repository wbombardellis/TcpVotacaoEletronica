package model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.entity.Ata;
import model.entity.AtaVotacao;
import model.entity.Estado;
import model.entity.Votacao;

public class VotacaoDao extends AbstractDao<Votacao> {

	private static VotacaoDao instance = null;

	public static VotacaoDao getInstance() {
		if (instance == null) {
			instance = new VotacaoDao();
		}
		return instance;
	}

	public List<Votacao> getVotacoesByEstado(List<Estado> estados) {
		List<Votacao> result = new ArrayList<>();
		
		for (Votacao votacao : this.getAll()) {
			for (Estado estado : estados) {
				if (votacao.testaEstado(estado))
					result.add(votacao);
			}
		}
		
		return result;
	}

	public List<Votacao> getVotacoesSemAta() {
		List<Votacao> result = new ArrayList<>();
		
		for (Votacao votacao : this.getAll()) {
			for (Ata ata : AtaDao.getInstance().getAll()) {
				for (AtaVotacao ataVotacao : ata.getAtasVotacoes()) {
					if (ataVotacao.getVotacao().equals(votacao)) {
						result.add(votacao);
					}
				}
			}
		}
		
		return result;
	}

	public List<Votacao> getVotacoesByEstadoNot(List<Estado> estados) {
		List<Votacao> result = new ArrayList<>();
		
		boolean notIn;
		for (Votacao votacao : this.getAll()) {
			notIn = true;
			for (Estado estado : estados) {
				if (votacao.testaEstado(estado))
					notIn = false;
			}
			if (notIn)
				result.add(votacao);
		}
		
		return result;
	}

}
