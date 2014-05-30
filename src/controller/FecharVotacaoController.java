package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.dao.MembroDao;
import model.dao.VotacaoDao;
import model.entity.Votacao;
import model.entity.Membro;
import model.entity.Voto;

public abstract class FecharVotacaoController {

	public static List<String> fechaVotacao(Votacao votacao) {
		List<String> warnings = new ArrayList<>();
		warnings.add("Alterada a data de fim da votacao");
		
		// Verifica se alguém não votou
		Set<Membro> votantes = new HashSet<>();
		for (Voto voto: votacao.getVotos()) {
			votantes.add(voto.getAutor());
		}
		
		boolean alguemNaoVotou = false;
		for (Membro membro: MembroDao.getInstance().getAll()) {
			if (! votantes.contains(membro)) {
				alguemNaoVotou = true;
				break;
			}
		}
		
		if (alguemNaoVotou) {
			warnings.add("Há membros do colegiado que não votaram");
		}
		
		// Atualiza os dados
		Votacao novaVotacao = new Votacao(votacao, votacao.getDataInicio(), new Date());
		
		VotacaoDao.getInstance().update(votacao.getId(), novaVotacao);
		
		return warnings;
	}

}
