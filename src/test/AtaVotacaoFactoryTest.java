package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import model.AtaVotacaoFactory;
import model.dao.AtaVotacaoDao;
import model.entity.AtaVotacao;
import model.entity.Estado;
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
		Votacao votacao1 = new Votacao(0, "teste1", new Date(), new Date(), Estado.Aberta, null, votos);
		Votacao votacao2 = new Votacao(1, "teste2", new Date(), new Date(), Estado.Aberta, null, new ArrayList<Voto>());
		
		//Teste trivial primeira inserção
		assertEquals(0, AtaVotacaoDao.getInstance().getLastInsertedId());
		AtaVotacao ataVotacao1 = AtaVotacaoFactory.criaAtaVotacao(votacao1, votantes, naoVotantes);
		assertNotNull(ataVotacao1);
		assertEquals(1, AtaVotacaoDao.getInstance().getLastInsertedId());
		assertEquals(1, ataVotacao1.getId());
		
		//Teste segunda inserção
		AtaVotacao ataVotacao2 = AtaVotacaoFactory.criaAtaVotacao(votacao2, votantes, naoVotantes);
		assertEquals(2, AtaVotacaoDao.getInstance().getLastInsertedId());
		assertEquals(2, ataVotacao2.getId());
		
		//Inserção após remoção
		AtaVotacaoDao.getInstance().delete(0);
		AtaVotacao ataVotacao3 = AtaVotacaoFactory.criaAtaVotacao(votacao2, votantes, naoVotantes);
		assertEquals(3, AtaVotacaoDao.getInstance().getLastInsertedId());
		assertEquals(3, ataVotacao2.getId());
	}

}
