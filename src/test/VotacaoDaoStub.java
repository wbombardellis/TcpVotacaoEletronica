package test;

import model.dao.VotacaoDao;

public class VotacaoDaoStub extends VotacaoDao {

	public static VotacaoDaoStub getInstance() {
		return new VotacaoDaoStub();
	}
}
