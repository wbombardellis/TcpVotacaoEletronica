package test;

import org.junit.Before;
import org.junit.Test;

import model.dao.MembroDao;
import model.entity.Chefe;
import model.entity.Discente;
import model.entity.Docente;
import model.entity.Membro;
import model.entity.Secretario;
import model.entity.ViceChefe;
import junit.framework.TestCase;

public class MembroDaoTest extends TestCase
{
	private MembroDao membroDao;
	private Membro membro;
	
	@Before
	public void setUp()
	{
		membroDao = MembroDao.getInstance();
		assertTrue(membroDao.insert(Chefe.substituirChefe("Chefe", "1", "chefe")));
		assertTrue(membroDao.insert(new ViceChefe("Vice Chefe", "2", "viceChefe")));
		assertTrue(membroDao.insert(new Secretario("Secretario", "3", "secretario")));
		assertTrue(membroDao.insert(new Docente("Docente", "4", "docente")));
		assertTrue(membroDao.insert(new Discente("Discente", "5", "Discente")));
	}
	
	@Test
	public void testGetMembro()
	{
		membro = membroDao.getMembroByUsername("1");
		assertEquals("Chefe", membro.getNome());
		
		membro = membroDao.getMembroByUsername("2");
		assertEquals("Vice Chefe", membro.getNome());
		
		membro = membroDao.getMembroByUsername("3");
		assertEquals("Secretario", membro.getNome());
		
		membro = membroDao.getMembroByUsername("4");
		assertEquals("Docente", membro.getNome());
		
		membro = membroDao.getMembroByUsername("5");
		assertEquals("Discente", membro.getNome());
	}
	
	
}
