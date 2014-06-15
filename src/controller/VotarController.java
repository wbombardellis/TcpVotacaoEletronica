package controller;

import model.dao.VotacaoDao;
import model.dao.VotoDao;
import model.entity.Votacao;
import model.entity.Voto;
import model.entity.Membro;

import java.util.ArrayList;
import java.util.List;

public abstract class VotarController {

	public static void insereVoto(Votacao votacao, Voto voto) {
		assert votacao != null;
		assert voto != null;
		assert VotacaoDao.getInstance().getById(votacao.getId()) != null;
		
		//Copia os votos da votação enviada
		ArrayList<Voto> novosVotos = new ArrayList<>(votacao.getVotos());
		//Adiciona novo voto
		novosVotos.add(voto);
		VotoDao.getInstance().insert(voto);
		
		//Atualiza a votação no DAO com uma nova instância. Faz isso pois Votacao é imutável
		VotacaoDao.getInstance().update(votacao.getId(), new Votacao(votacao, novosVotos));
	}

	public static void removeVoto(Votacao votacao, Voto voto) {
		assert votacao != null;
		assert voto != null;
		assert VotacaoDao.getInstance().getById(votacao.getId()) != null;
		
		//Copia os votos da votação enviada
		ArrayList<Voto> novosVotos = new ArrayList<>(votacao.getVotos());
		//Remove tal voto
		novosVotos.remove(voto);
		
		//Atualiza a votação no DAO com uma nova instância. Faz isso pois Votacao é imutável
		VotacaoDao.getInstance().update(votacao.getId(), new Votacao(votacao, novosVotos));
	}
	
	public static void alteraVoto(Votacao votacao, Voto votoAntigo, Voto votoNovo){
		assert votacao != null;
		assert votoAntigo != null;
		assert votoNovo != null;
		assert VotacaoDao.getInstance().getById(votacao.getId()) != null;
		
		VotarController.removeVoto(votacao, votoAntigo);
		
		VotarController.insereVoto(VotacaoDao.getInstance().getById(votacao.getId()), votoNovo);		
	}

	public static Voto getVotoByAutor(Votacao votacao, Membro autor) {
		assert votacao != null;
		assert autor != null;
		
		List<Voto> votos = votacao.getVotos();
		
		for(Voto voto : votos){
			if (voto.getAutor().equals(autor)){
				return voto;
			}
		}
		return null;
	}

}
