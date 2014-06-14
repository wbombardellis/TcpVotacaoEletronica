package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import model.AtaFactory;
import model.dao.AtaDao;
import model.dao.AtaVotacaoDao;
import model.entity.Ata;
import model.entity.AtaVotacao;
import model.entity.Estado;
import model.entity.Membro;
import model.entity.TipoVoto;
import model.entity.Votacao;
import model.entity.Voto;

import org.junit.Test;

public class AtaFactoryTest {

	@Test(expected = AssertionError.class)
	public void testCriaAtaNull() {
		//Tests to fail
		AtaFactory.criaAta(null);
	}
	
	@Test(expected = AssertionError.class)
	public void testCriaAtaEmpty() {
		//Tests to fail
		AtaFactory.criaAta(new HashMap<Integer, AtaVotacao>());
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
		Votacao votacao1 = new Votacao(0, "teste1", new Date(), new Date(), Estado.Aberta, null, votos);
		Votacao votacao2 = new Votacao(1, "teste2", new Date(), new Date(), Estado.Aberta, null, new ArrayList<Voto>());
		
		AtaVotacao ataVotacao1 = new AtaVotacao(0, votacao1, votantes, naoVotantes);
		HashMap<Integer, AtaVotacao> atasVotacoes1 = new HashMap<>();
		atasVotacoes1.put(0, ataVotacao1);
		
		AtaVotacao ataVotacao2 = new AtaVotacao(1, votacao2, votantes, naoVotantes);
		HashMap<Integer, AtaVotacao> atasVotacoes2 = new HashMap<>();
		atasVotacoes2.put(0, ataVotacao2);
		
		
		//Teste trivial primeira inserção
		assertEquals(0, AtaDao.getInstance().getLastInsertedId());
		Ata ata1 = AtaFactory.criaAta(atasVotacoes1);
		assertNotNull(ata1);
		assertEquals(1, ata1.getId());
		AtaDao.getInstance().insert(ata1);
		assertEquals(1, AtaDao.getInstance().getLastInsertedId());
		
		//Teste segunda inserção
		Ata ata2 = AtaFactory.criaAta(atasVotacoes2);
		assertEquals(2, ata2.getId());
		AtaDao.getInstance().insert(ata2);
		assertEquals(2, AtaDao.getInstance().getLastInsertedId());
		
		//Inserção após remoção
		AtaDao.getInstance().delete(1);
		Ata ata3 = AtaFactory.criaAta(atasVotacoes2);
		assertEquals(3, ata3.getId());
		AtaDao.getInstance().insert(ata3);
		assertEquals(3, AtaDao.getInstance().getLastInsertedId());
	}

}
