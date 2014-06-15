package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.AtaFactory;
import model.AtaVotacaoFactory;
import model.dao.AtaDao;
import model.dao.AtaVotacaoDao;
import model.dao.MembroDao;
import model.entity.Ata;
import model.entity.AtaVotacao;
import model.entity.Membro;
import model.entity.TipoVoto;
import model.entity.Votacao;
import model.entity.Voto;

public abstract class GerarAtaController {

	public static void criaAta(List<Votacao> votacoes) {
		assert votacoes != null;
		assert !votacoes.isEmpty();
		
		HashMap<Integer,AtaVotacao> atasVotacoes = new HashMap<>();
		
		List<Membro> membros = MembroDao.getInstance().getMembrosQueVotam();
		
		List<Membro> votantes = new ArrayList<>();
		List<Membro> naoVotantes = new ArrayList<>();
		
		//Loop para criar Atas de Votação para cada votação
		for (Votacao votacao : votacoes){
			votantes.clear();
			naoVotantes.clear();
			
			//Loop para processar quem votou ou não nesta votação
			if (membros != null){
				for (Membro membro : membros){
					Voto voto = VotarController.getVotoByAutor(votacao, membro);
					//Este membro votou nesta votação
					if (voto != null){
						votantes.add(membro);
					}else{
						//Não votou
						naoVotantes.add(membro);
					}
				}
			}
			//Adiciona nova Ata de Votação no hash
			AtaVotacao ataVotacao = AtaVotacaoFactory.criaAtaVotacao(votacao, votantes, naoVotantes);
			atasVotacoes.put(ataVotacao.getId(), ataVotacao);
			AtaVotacaoDao.getInstance().insert(ataVotacao);
		}
		
		AtaDao.getInstance().insert(AtaFactory.criaAta(atasVotacoes));
	}

}
