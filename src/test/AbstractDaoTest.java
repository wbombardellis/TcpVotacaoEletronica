package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import model.dao.MembroDao;
import model.entity.Membro;

import org.junit.Test;

/**
 * Para testar o AbstractDao será usado o MembroDao, já que AbstractDao é Abstrato
 */
public class AbstractDaoTest {

	private static final Integer LIMITE_TESTES_DELETE = 100;

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
		
		//membros funciona como um oráculo
		List<Membro> membros = new ArrayList<>();
		membros.add(m1);
		
		//Test to pass - Uma inserção
		int lastId = mDao.getLastInsertedId();
		assertEquals(lastId, mDao.getLastInsertedId());
		assertTrue(mDao.insert(m1));
		assertEquals(lastId+1, mDao.getLastInsertedId());
		assertEquals(m1, mDao.getById(lastId+1));
		//assertEquals(membros, mDao.getAll());

		//Duas inserções
		Membro m2 = new Membro("t2", "t2", "1234");
		membros.add(m2);
		assertTrue(mDao.insert(m2));
		assertEquals(lastId+2, mDao.getLastInsertedId());
		assertEquals(m2, mDao.getById(lastId+2));
		//assertEquals(membros, mDao.getAll());
		
		//Repetida
		assertFalse(mDao.insert(m1));
		assertFalse(mDao.insert(m2));
		
		assertTrue(mDao.delete(lastId+1));
		assertTrue(mDao.delete(lastId+2));
	}

	
	public void testDeleteGetByIdGetAll() {
		MembroDao mDao = MembroDao.getInstance();
		Membro m1 = new Membro("t1", "t1", "1234");
		
		//membros funciona como um oráculo
		List<Membro> membros = new ArrayList<>();
		membros.add(m1);
		
		//Test to pass - Uma inserção
		assertEquals(0, mDao.getLastInsertedId());
		assertTrue(mDao.getAll().isEmpty());
		assertTrue(mDao.insert(m1));
		assertEquals(1, mDao.getLastInsertedId());
		assertEquals(m1, mDao.getById(1));
		assertArrayEquals(membros.toArray(), mDao.getAll().toArray());

		//Remove um
		assertFalse(mDao.delete(0)); //Não existe
		assertFalse(mDao.delete(10)); //Não existe
		assertFalse(mDao.delete(-1)); //Não existe
		assertTrue(mDao.delete(1));
		membros = new ArrayList<>();
		assertArrayEquals(membros.toArray(), mDao.getAll().toArray());
		
		
		//Teste Randômico
		int i;
		int lastId = mDao.getLastInsertedId();
		int idBegin = mDao.getLastInsertedId();
		Random rand = new Random(new Date().getTime());
		
		for (i = 0; i < AbstractDaoTest.LIMITE_TESTES_DELETE; i++){
			
			//Se random for par (metade das operações)
			if ((rand.nextInt() % 2 == 0)){
				//Insere
				Membro m = new Membro(String.valueOf(i), String.valueOf(i), String.valueOf(i));
				membros.add(m);
				lastId++;
				assertTrue(mDao.insert(m));
				assertEquals(lastId, mDao.getLastInsertedId());
				assertEquals(m, mDao.getById(lastId));
			}else if (lastId > 0){
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

			assertEquals(new HashSet<>(membros), new HashSet<>(mDao.getAll()));
		}
		//Tenta remover tudo, para utilizar o dao mais tarde
		for (i = 0; i < AbstractDaoTest.LIMITE_TESTES_DELETE; i++){
			mDao.delete(idBegin);
			idBegin++;
		}
	}
	
	@Test
	public void testUpdateNull(){
		MembroDao mDao = MembroDao.getInstance();
		Membro m1 = new Membro("t1", "t1", "1234");
		
		//Test to pass - Uma inserção
		assertTrue(mDao.insert(m1));
		assertFalse(mDao.update(1, null));
		assertTrue(mDao.delete(m1.getId()));
	}

	@Test
	public void testUpdate() {
		MembroDao mDao = MembroDao.getInstance();
		Membro m1 = new Membro("t1", "t1", "1234");
		
		//Test to pass - Uma inserção
		assertTrue(mDao.insert(m1));
		Membro m2 = new Membro("t2", "t2", "1234");
		assertFalse(mDao.update(m2.getId(), m2)); //Não existe id m2.getid() pois ele não foi inserido ainda
		assertTrue(mDao.update(m1.getId(), m2));
		assertEquals(mDao.getById(m1.getId()), m2);
		assertNotEquals(mDao.getById(m1.getId()), m1);
	}

}
