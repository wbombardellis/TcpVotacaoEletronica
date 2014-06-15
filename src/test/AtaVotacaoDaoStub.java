package test;

import model.dao.AtaVotacaoDao;

public class AtaVotacaoDaoStub extends AtaVotacaoDao {

	public static AtaVotacaoDaoStub getInstance() {
		return new AtaVotacaoDaoStub();
	}
}
