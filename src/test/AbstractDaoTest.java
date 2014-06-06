package test;

import static org.junit.Assert.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import model.dao.MembroDao;
import model.entity.Membro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Para testar o AbstractDao será usado o MembroDao, já que AbstractDao é Abstrato
 */
public class AbstractDaoTest {

	private static final Integer LIMITE_TESTES_DELETE = 10000;

	@Test(expected = AssertionError.class)
	public void testInsertNull() {
		MembroDao mDao = MembroDao.getInstance();
		//Test to fail
		mDao.insert(null);
	}
	
	@Test
	public void testInsert() {
		MembroDao mDao = MembroDao.getInstance();
		Membro m1 = new Membro("t1", "t1", "1234");
		Membro m2 = new Membro("t2", "t2", "1234");
		
		//membros funciona como um oráculo
		List<Membro> membros = new ArrayList<>();
		membros.add(m1);
		
		//Test to pass - Uma inserção
		assertEquals(0, mDao.getLastInsertedId());
		assertTrue(mDao.getAll().isEmpty());
		assertTrue(mDao.insert(m1));
		assertEquals(1, mDao.getLastInsertedId());
		assertEquals(m1, mDao.getById(1));
		assertEquals(membros, mDao.getAll());

		//Duas inserções
		membros.add(m2);
		assertTrue(mDao.insert(m2));
		assertEquals(2, mDao.getLastInsertedId());
		assertEquals(m2, mDao.getById(2));
		assertEquals(membros, mDao.getAll());
		
		//Repetida
		assertFalse(mDao.insert(m1));
		assertFalse(mDao.insert(m2));
	}

	@Test
	public void testDeleteGetByIdGetAll() {
		MembroDao mDao = MembroDao.getInstance();
		Membro m1 = new Membro("t1", "t1", "1234");
		Membro m2 = new Membro("t2", "t2", "1234");
		
		//membros funciona como um oráculo
		List<Membro> membros = new ArrayList<>();
		membros.add(m1);
		
		//Test to pass - Uma inserção
		assertEquals(0, mDao.getLastInsertedId());
		assertTrue(mDao.getAll().isEmpty());
		assertTrue(mDao.insert(m1));
		assertEquals(1, mDao.getLastInsertedId());
		assertEquals(m1, mDao.getById(1));
		assertEquals(membros, mDao.getAll());

		//Remove um
		assertFalse(mDao.delete(0)); //Não existe
		assertFalse(mDao.delete(10)); //Não existe
		assertFalse(mDao.delete(-1)); //Não existe
		assertTrue(mDao.delete(1));
		membros.remove(m1);
		
		//Teste Randômico
		int i;
		int lastId;
		Random rand = new Random(new Date().getTime());
		for (i = 0, lastId = 0; i < AbstractDaoTest.LIMITE_TESTES_DELETE; i++){
			//Se random for par (metade das operações)
			if ((rand.nextInt() % 2 == 0)){
				//Insere
				Membro m = new Membro(String.valueOf(i), String.valueOf(i), String.valueOf(i));
				membros.add(m);
				lastId++;
				assertTrue(mDao.insert(m));
				assertEquals(lastId, mDao.getLastInsertedId());
				assertEquals(m, mDao.getById(lastId));
				assertEquals(membros, mDao.getAll());
			}else{
				//Escolhe elemento a remover
				int randId = rand.nextInt() % lastId;
				Membro randMembro = mDao.getById(randId);
				int lastIdBefore = mDao.getLastInsertedId();
				
				//Se este membro não existe mais no dao
				if (randMembro == null){
					//Deve retornar false, estar coeso
					assertFalse(mDao.delete(randId));
					//Não deve ocorrer no oráculo também
					for (Membro m : membros){
						if (m.getId() == randId){
							fail();
						}
					}
					
				}else{
					//Se ele existe, então deve ser true
					assertTrue(mDao.delete(randId));
					//Porém deve ser removido da lista também (devia existir lá)
					assertTrue(membros.remove(randMembro));
					//Deve sair
					assertNull(mDao.getById(randId));
				}
				//Não pode mudar last inserted id
				assertEquals(lastIdBefore, mDao.getLastInsertedId());
			}
		}
	}
	
	@Test(expected = AssertionError.class)
	public void testUpdateFail(){
		MembroDao mDao = MembroDao.getInstance();
		Membro m1 = new Membro("t1", "t1", "1234");
		
		//Test to pass - Uma inserção
		assertTrue(mDao.insert(m1));
		mDao.update(1, null);
	}

	@Test
	public void testUpdate() {
		MembroDao mDao = MembroDao.getInstance();
		Membro m1 = new Membro("t1", "t1", "1234");
		Membro m2 = new Membro("t2", "t2", "1234");
		
		//Test to pass - Uma inserção
		assertTrue(mDao.insert(m1));
		assertFalse(mDao.update(2, m2)); //Não existe id 2
		assertTrue(mDao.update(1, m2));
		assertEquals(mDao.getById(1), m2);
		assertNotEquals(mDao.getById(1), m1);
	}

}
