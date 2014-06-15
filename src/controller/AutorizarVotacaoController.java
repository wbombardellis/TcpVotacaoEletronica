package controller;

import model.dao.VotacaoDao;
import model.entity.Estado;
import model.entity.Votacao;

public abstract class AutorizarVotacaoController {

	public static void autorizaVotacao(Votacao votacao) {
		Votacao novaVotacao = new Votacao(votacao, Estado.Autorizada);
		
		VotacaoDao.getInstance().update(votacao.getId(), novaVotacao);
	}

}
