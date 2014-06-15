package test;

import model.dao.AtaDao;

public class AtaDaoStub extends AtaDao {

	public static AtaDaoStub getInstance() {
		return new AtaDaoStub();
	}
}
