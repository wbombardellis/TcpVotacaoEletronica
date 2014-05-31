package model.dao;

import model.entity.Ata;
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
		return false;
	}

}
