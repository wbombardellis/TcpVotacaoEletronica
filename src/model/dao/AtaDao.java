package model.dao;

import java.util.ArrayList;

import model.entity.Ata;
import model.entity.AtaVotacao;
import model.entity.Votacao;

public class AtaDao extends AbstractDao<Ata> {

	private static AtaDao instance = null;

	public static AtaDao getInstance() {
		if (instance == null) {
			instance = new AtaDao();
		}
		return instance;
	}

	public boolean existsAtaByVotacao(Votacao votacao) {
		for (Ata ata : new ArrayList<>(getAll())){
			for (AtaVotacao ataVotacao : ata.getAtasVotacoes()){
				if (ataVotacao.getVotacao().equals(votacao)){
					return true;
				}
			}
		}
		return false;
	}

}
