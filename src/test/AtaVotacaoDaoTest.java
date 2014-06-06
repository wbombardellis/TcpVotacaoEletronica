package test;

import static org.junit.Assert.*;
import model.dao.AtaDao;

import org.junit.Before;
import org.junit.Test;

public class AtaVotacaoDaoTest {

	@Test
	public void testGetInstance() {
		AtaDao dao1 = AtaDao.getInstance();
		AtaDao dao2 = AtaDao.getInstance();
		assertSame(dao1, dao2);
		assertNotNull(dao1);
	}

}
