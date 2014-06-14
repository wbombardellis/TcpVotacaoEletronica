package model.dao;

import model.entity.AtaVotacao;

public class AtaVotacaoDao extends AbstractDao<AtaVotacao>{
	private static AtaVotacaoDao instance = null;
	
	protected AtaVotacaoDao(){
		
	}

	public static AtaVotacaoDao getInstance() {
		if (instance == null) {
			instance = new AtaVotacaoDao();
		}
		return instance;
	}
}
