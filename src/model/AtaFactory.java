package model;

import java.util.HashMap;

import model.dao.AtaDao;
import model.entity.Ata;
import model.entity.AtaVotacao;

public class AtaFactory {

	public static Ata criaAta(HashMap<Integer,AtaVotacao> atasVotacoes){
		Integer id = AtaDao.getInstance().getLastInsertedId();
		id++;
		
		return new Ata(id, atasVotacoes);
	}
	
}
