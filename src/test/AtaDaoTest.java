package test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import model.dao.AtaDao;
import model.entity.Ata;
import model.entity.AtaVotacao;
import model.entity.Estado;
import model.entity.EstagioProbatorio;
import model.entity.Membro;
import model.entity.TipoVoto;
import model.entity.Votacao;
import model.entity.Voto;

import org.junit.Before;
import org.junit.Test;


public class AtaDaoTest {

	@Test
	public void testGetInstance() {
		AtaDao dao1 = AtaDao.getInstance();
		AtaDao dao2 = AtaDao.getInstance();
		assertSame(dao1, dao2);
		assertNotNull(dao1);
	}

	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void testExistsAtaByVotacaoUniqueInsertions() {
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
		Votacao votacao1_1 = new Votacao(0, "teste1", new Date(), new Date(), Estado.Aberta, new EstagioProbatorio(new HashMap<Integer, String>(), new HashMap<Integer, String>()), votos);
		Votacao votacao1_2 = votacao1;
		
		AtaVotacao ataVotacao1 = new AtaVotacao(0, votacao1, votantes, naoVotantes);
		
		HashMap<Integer, AtaVotacao> atasVotacoes1 = new HashMap<>();
		atasVotacoes1.put(0, ataVotacao1);

		Ata ata1 = new Ata(0, atasVotacoes1);
		AtaDao ataDao = AtaDaoStub.getInstance();

		ataDao.insert(ata1);
				
		//Teste trivial
		assertFalse(ataDao.existsAtaByVotacao(null));
		//Votacao1 ocorre na ata1
		assertTrue(ataDao.existsAtaByVotacao(votacao1));
		//Não pode comparar pela referência, mas sim pelos valores do objeto
		assertTrue(ataDao.existsAtaByVotacao(votacao1_1));
		//Referêmcia também funciona
		assertTrue(ataDao.existsAtaByVotacao(votacao1_2));
		//Votacao2 não ocorre em nenhuma ata
		assertFalse(ataDao.existsAtaByVotacao(votacao2));		
		
	}
	
	@Test
	public void testExistsAtaByVotacaoMultipleInsertions() {
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
		Votacao votacao1 = new Votacao(0, "teste", new Date(), new Date(), Estado.Aberta, new EstagioProbatorio(new HashMap<Integer, String>(), new HashMap<Integer, String>()), votos);
		Votacao votacao2 = new Votacao(1, "teste", new Date(), new Date(), Estado.Aberta, new EstagioProbatorio(new HashMap<Integer, String>(), new HashMap<Integer, String>()), new ArrayList<Voto>());
		
		AtaVotacao ataVotacao1 = new AtaVotacao(0, votacao1, votantes, naoVotantes);
		AtaVotacao ataVotacao2 = new AtaVotacao(1, votacao2, votantes, naoVotantes);
		
		HashMap<Integer, AtaVotacao> atasVotacoes1 = new HashMap<>();
		atasVotacoes1.put(0, ataVotacao1);
		atasVotacoes1.put(1, ataVotacao2);
		
		Ata ata1 = new Ata(0, atasVotacoes1);
		AtaDao ataDao = AtaDaoStub.getInstance();
		
		ataDao.insert(ata1);
		
		//Tests to pass
		//Votacao1 ocorre na ata1
		assertTrue(ataDao.existsAtaByVotacao(votacao1));
		//Votacao2 ocorre na ata1
		assertTrue(ataDao.existsAtaByVotacao(votacao2));
		
		//Votacao2 ocorre na ata1 e ata2
		HashMap<Integer, AtaVotacao> atasVotacoes2 = new HashMap<>();
		atasVotacoes2.put(0, ataVotacao2);
		
		Ata ata2 = new Ata(1, atasVotacoes2);
		ataDao.insert(ata2);
		
		assertTrue(ataDao.existsAtaByVotacao(votacao2));
		
		//Remover ata1. Votacao 1 agora não ocorre mais
		ataDao.delete(0);
		assertFalse(ataDao.existsAtaByVotacao(votacao1));
		//Ata2 continua presente
		assertTrue(ataDao.existsAtaByVotacao(votacao2));
		
		
	}

}
