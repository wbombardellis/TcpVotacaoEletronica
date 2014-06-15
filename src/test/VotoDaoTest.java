package test;

import static org.junit.Assert.*;
import model.dao.VotoDao;

import org.junit.Test;

public class VotoDaoTest {

	@Test
	public void testGetInstance() {
		VotoDao dao1 = VotoDao.getInstance();
		VotoDao dao2 = VotoDao.getInstance();
		assertSame(dao1, dao2);
		assertNotNull(dao1);
	}

}
