package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import model.AtaVotacaoFactory;
import model.dao.AtaVotacaoDao;
import model.entity.AtaVotacao;
import model.entity.Estado;
import model.entity.EstagioProbatorio;
import model.entity.Membro;
import model.entity.TipoVoto;
import model.entity.Votacao;
import model.entity.Voto;

import org.junit.Test;

public class AtaVotacaoFactoryTest {

	@Test(expected = AssertionError.class)
	public void testCriaAtaNull() {
		//Tests to fail
		AtaVotacaoFactory.criaAtaVotacao(null, null, null);
	}
	
	@Test
	public void testCriaAta() {
		//Cria elementos apenas para popular a ata
		Membro membro1 = new Membro("membro1", "teste1", "1234");
		Membro membro2 = new Membro("membro2", "teste2", "1234");
		
		ArrayList<Membro> votantes = new ArrayList<>();
		votantes.add(membro1);
		
		ArrayList<Membro> naoVotantes = new ArrayList<>();
		votantes.add(membro2);
		
		ArrayList<Voto> votos = new ArrayList<>();
		votos.add(new Voto(0, TipoVoto.Favoravel, membro1, new Date(), null));
		
		//Cria as votações que serão testadas no método
		Votacao votacao1 = new Votacao(0, "teste1", new Date(), new Date(), Estado.Aberta, new EstagioProbatorio(new HashMap<Integer, String>(), new HashMap<Integer, String>()), votos);
		Votacao votacao2 = new Votacao(1, "teste2", new Date(), new Date(), Estado.Aberta, new EstagioProbatorio(new HashMap<Integer, String>(), new HashMap<Integer, String>()), new ArrayList<Voto>());
		
		
		///Não utiliza o AtaVotacaoDaoStub aqui, pois o factory consulta o AtaVotacaoDao, então supõe que está vazio e que o lastInsertId é zero
		AtaVotacaoDao ataVotacaoDao = AtaVotacaoDao.getInstance();
		
		//Teste trivial primeira inserção
		AtaVotacao ataVotacao1 = AtaVotacaoFactory.criaAtaVotacao(votacao1, votantes, naoVotantes);
		assertNotNull(ataVotacao1);
		assertEquals(ataVotacaoDao.getLastInsertedId()+1, ataVotacao1.getId());
		
		ataVotacaoDao.insert(ataVotacao1);
		
		//Teste segunda inserção
		AtaVotacao ataVotacao2 = AtaVotacaoFactory.criaAtaVotacao(votacao2, votantes, naoVotantes);
		assertEquals(ataVotacaoDao.getLastInsertedId()+1, ataVotacao2.getId());
		
		ataVotacaoDao.insert(ataVotacao2);
		
		//Inserção após remoção
		ataVotacaoDao.delete(0);
		AtaVotacao ataVotacao3 = AtaVotacaoFactory.criaAtaVotacao(votacao2, votantes, naoVotantes);
		assertEquals(ataVotacaoDao.getLastInsertedId()+1, ataVotacao3.getId());
		
		ataVotacaoDao.insert(ataVotacao3);
		
		//Remove para que o Dao possa ser utilizado por outros testes
		ataVotacaoDao.delete(ataVotacao1.getId());
		ataVotacaoDao.delete(ataVotacao2.getId());
		ataVotacaoDao.delete(ataVotacao3.getId());
	}

}
