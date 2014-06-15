package model;

import java.util.List;

import model.dao.AtaVotacaoDao;
import model.entity.AtaVotacao;
import model.entity.Membro;
import model.entity.Votacao;

public class AtaVotacaoFactory {

	public static AtaVotacao criaAtaVotacao(Votacao votacao, List<Membro> votantes, List<Membro> naoVotantes){
		Integer id = AtaVotacaoDao.getInstance().getLastInsertedId();
		id++;
		
		return new AtaVotacao(id, votacao, votantes, naoVotantes);
	}
}
