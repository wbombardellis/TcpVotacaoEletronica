package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.dao.AtaDao;
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
			//Adiciona nova Ata de Votação no hash
			AtaVotacao ataVotacao = new AtaVotacao(votacao, votantes, naoVotantes);
			atasVotacoes.put(ataVotacao.getId(), ataVotacao);
		}
		
		AtaDao.getInstance().insert(new Ata(atasVotacoes));
	}

	public static Integer getQtdVotosFavoriaveis(List<Voto> votos) {
		Integer count = 0;
		for (Voto voto : votos){
			if (voto.getTipo() == TipoVoto.Favoravel){
				count++;
			}
		}
		return count;
	}

	public static Integer getQtdVotosNaoFavoriaveis(List<Voto> votos) {
		Integer count = 0;
		for (Voto voto : votos){
			if (voto.getTipo() == TipoVoto.NaoFavoravel){
				count++;
			}
		}
		return count;
	}

}
