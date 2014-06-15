package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import model.entity.Estado;
import model.entity.EstagioProbatorio;
import model.entity.Membro;
import model.entity.TipoVoto;
import model.entity.Votacao;
import model.entity.Voto;

import org.junit.Test;

public class VotacaoTest {

	@Test
	public void testTestaEstado() {
		Date ini, fim;
		Votacao votacao = new Votacao(1,
				"teste",
				(ini = new Date()),
				(fim = new Date(115,0,1)),
				Estado.Bloqueada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		assertTrue(votacao.testaEstado(Estado.Bloqueada));
		assertFalse(votacao.testaEstado(Estado.Autorizada));
		assertFalse(votacao.testaEstado(Estado.Liberada));
		assertFalse(votacao.testaEstado(Estado.Aberta));
		assertFalse(votacao.testaEstado(Estado.Finalizada));
		
		votacao = new Votacao(1,
				"teste",
				(ini = new Date()),
				(fim = new Date(115,0,1)),
				Estado.Autorizada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		assertTrue(votacao.testaEstado(Estado.Bloqueada));
		assertTrue(votacao.testaEstado(Estado.Autorizada));
		assertFalse(votacao.testaEstado(Estado.Liberada));
		assertFalse(votacao.testaEstado(Estado.Aberta));
		assertFalse(votacao.testaEstado(Estado.Finalizada));
		
		votacao = new Votacao(1,
				"teste",
				(ini = new Date()),
				(fim = new Date(115,0,1)),
				Estado.Liberada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		assertFalse(votacao.testaEstado(Estado.Bloqueada));
		assertFalse(votacao.testaEstado(Estado.Autorizada));
		assertTrue(votacao.testaEstado(Estado.Liberada));
		assertFalse(votacao.testaEstado(Estado.Aberta));
		assertFalse(votacao.testaEstado(Estado.Finalizada));
		
		votacao = new Votacao(1,
				"teste",
				(ini = new Date(114, 11,30)),
				(fim = new Date(115,0,1)),
				Estado.Liberada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		assertFalse(votacao.testaEstado(Estado.Bloqueada));
		assertFalse(votacao.testaEstado(Estado.Autorizada));
		assertTrue(votacao.testaEstado(Estado.Liberada));
		assertFalse(votacao.testaEstado(Estado.Aberta));
		assertFalse(votacao.testaEstado(Estado.Finalizada));
		
		votacao = new Votacao(1,
				"teste",
				(ini = new Date(114, 11,30)),
				(fim = new Date(115,0,1)),
				Estado.Aberta,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		assertTrue(votacao.testaEstado(Estado.Bloqueada));
		assertFalse(votacao.testaEstado(Estado.Autorizada));
		assertFalse(votacao.testaEstado(Estado.Liberada));
		assertFalse(votacao.testaEstado(Estado.Aberta));
		assertFalse(votacao.testaEstado(Estado.Finalizada));
		
		votacao = new Votacao(1,
				"teste",
				(ini = new Date(114, 0,1)),
				(fim = new Date(114,3,31)),
				Estado.Aberta,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		assertTrue(votacao.testaEstado(Estado.Bloqueada));
		assertFalse(votacao.testaEstado(Estado.Autorizada));
		assertFalse(votacao.testaEstado(Estado.Liberada));
		assertFalse(votacao.testaEstado(Estado.Aberta));
		assertTrue(votacao.testaEstado(Estado.Finalizada));
		
		votacao = new Votacao(1,
				"teste",
				(ini = new Date(114, 0,1)),
				(fim = new Date(114,10,30)),
				Estado.Liberada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		assertFalse(votacao.testaEstado(Estado.Bloqueada));
		assertFalse(votacao.testaEstado(Estado.Autorizada));
		assertTrue(votacao.testaEstado(Estado.Liberada));
		assertTrue(votacao.testaEstado(Estado.Aberta));
		assertFalse(votacao.testaEstado(Estado.Finalizada));
		
		HashMap<Integer, String> docsObrig = new HashMap<Integer,String>();
		docsObrig.put(0, "Doc1");
		docsObrig.put(1, "Doc2");
		votacao = new Votacao(1,
				"teste",
				(ini = new Date(115, 0,1)),
				(fim = new Date(115,10,30)),
				Estado.Autorizada,
				new EstagioProbatorio(docsObrig, new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		assertFalse(votacao.testaEstado(Estado.Bloqueada));
		assertTrue(votacao.testaEstado(Estado.Autorizada));
		assertTrue(votacao.testaEstado(Estado.Liberada));
		assertFalse(votacao.testaEstado(Estado.Aberta));
		assertFalse(votacao.testaEstado(Estado.Finalizada));
		
		votacao = new Votacao(1,
				"teste",
				(ini = new Date(114, 0,1)),
				(fim = new Date(115,10,30)),
				Estado.Autorizada,
				new EstagioProbatorio(docsObrig, new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		assertFalse(votacao.testaEstado(Estado.Bloqueada));
		assertTrue(votacao.testaEstado(Estado.Autorizada));
		assertTrue(votacao.testaEstado(Estado.Liberada));
		assertTrue(votacao.testaEstado(Estado.Aberta));
		assertFalse(votacao.testaEstado(Estado.Finalizada));
		
		votacao = new Votacao(1,
				"teste",
				(ini = new Date(113, 0,1)),
				(fim = new Date(113,10,30)),
				Estado.Bloqueada,
				new EstagioProbatorio(docsObrig, new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		assertFalse(votacao.testaEstado(Estado.Bloqueada));
		assertFalse(votacao.testaEstado(Estado.Autorizada));
		assertTrue(votacao.testaEstado(Estado.Liberada));
		assertFalse(votacao.testaEstado(Estado.Aberta));
		assertTrue(votacao.testaEstado(Estado.Finalizada));
	}

	@Test
	public void testVotacaoIntStringDateDateEstadoDocumentacaoListOfVoto() {
		Date ini, fim;
		Votacao votacao = new Votacao(1,
				"teste",
				(ini = new Date()),
				(fim = new Date(115,0,1)),
				Estado.Bloqueada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		assertEquals(1, votacao.getId());
		assertEquals("teste", votacao.getTitulo());
		assertEquals(ini, votacao.getDataInicio());
		assertEquals(fim, votacao.getDataFim());
		assertEquals(Estado.Bloqueada, votacao.getEstado());
		
		votacao = new Votacao(1,
				"teste",
				(ini = new Date()),
				(fim = new Date(115,0,1)),
				Estado.Autorizada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		assertEquals(Estado.Autorizada, votacao.getEstado());
		
		votacao = new Votacao(1,
				"teste",
				(ini = new Date()),
				(fim = new Date(115,0,1)),
				Estado.Liberada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		assertEquals(Estado.Liberada, votacao.getEstado());
		
		votacao = new Votacao(1,
				"teste",
				(ini = new Date(114, 11,30)),
				(fim = new Date(115,0,1)),
				Estado.Liberada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		assertEquals(Estado.Liberada, votacao.getEstado());
		
		votacao = new Votacao(1,
				"teste",
				(ini = new Date(114, 11,30)),
				(fim = new Date(115,0,1)),
				Estado.Aberta,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		assertEquals(Estado.Bloqueada, votacao.getEstado());
		
		votacao = new Votacao(1,
				"teste",
				(ini = new Date(114, 0,1)),
				(fim = new Date(114,3,31)),
				Estado.Aberta,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		assertEquals(Estado.Finalizada, votacao.getEstado());
		
		votacao = new Votacao(1,
				"teste",
				(ini = new Date(114, 0,1)),
				(fim = new Date(114,10,30)),
				Estado.Liberada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		assertEquals(Estado.Aberta, votacao.getEstado());
		
		HashMap<Integer, String> docsObrig = new HashMap<Integer,String>();
		docsObrig.put(0, "Doc1");
		docsObrig.put(1, "Doc2");
		votacao = new Votacao(1,
				"teste",
				(ini = new Date(115, 0,1)),
				(fim = new Date(115,10,30)),
				Estado.Autorizada,
				new EstagioProbatorio(docsObrig, new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		assertEquals(Estado.Liberada, votacao.getEstado());
		
		votacao = new Votacao(1,
				"teste",
				(ini = new Date(114, 0,1)),
				(fim = new Date(115,10,30)),
				Estado.Autorizada,
				new EstagioProbatorio(docsObrig, new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		assertEquals(Estado.Aberta, votacao.getEstado());
		
		votacao = new Votacao(1,
				"teste",
				(ini = new Date(113, 0,1)),
				(fim = new Date(113,10,30)),
				Estado.Bloqueada,
				new EstagioProbatorio(docsObrig, new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		assertEquals(Estado.Finalizada, votacao.getEstado());
	}

	@Test
	public void testVotacaoVotacaoEstado() {
		Date ini, fim;
		Votacao base = new Votacao(1,
				"teste",
				(ini = new Date(114, 5,13)),
				(fim = new Date(115,0,1)),
				Estado.Bloqueada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		
		Votacao votacao = new Votacao(base, Estado.Autorizada);
		assertEquals(Estado.Autorizada, votacao.getEstado());
		
		votacao = new Votacao(base, Estado.Liberada);
		assertEquals(Estado.Aberta, votacao.getEstado());
		
		votacao = new Votacao(base, Estado.Finalizada);
		assertEquals(Estado.Bloqueada, votacao.getEstado());
		
		votacao = new Votacao(base, Estado.Aberta);
		assertEquals(Estado.Aberta, votacao.getEstado());
	}

	@Test
	public void testVotacaoVotacaoDateDate() {
		Date ini, fim;
		Votacao base = new Votacao(1,
				"teste",
				(ini = new Date(114, 4,13)),
				(fim = new Date(115,0,1)),
				Estado.Bloqueada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		
		Date ini2 = new Date(100, 0, 15), fim2 = new Date(115,2,10);
		Votacao votacao = new Votacao(base, ini2, fim2);
		
		assertEquals(ini2, votacao.getDataInicio());
		assertEquals(fim2, votacao.getDataFim());
	}

	@Test
	public void testVotacaoVotacaoListOfVoto() {
		Date ini, fim;
		Votacao base = new Votacao(1,
				"teste",
				(ini = new Date(114, 4,13)),
				(fim = new Date(115,0,1)),
				Estado.Bloqueada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		
		List<Voto> votos = new ArrayList<>();
		Voto voto1, voto2, voto3;
		votos.add(voto1 = new Voto(10, TipoVoto.Favoravel, new Membro("Fernando", "fernando", "1234"), new Date(), "justificativa 1"));
		votos.add(voto2 = new Voto(11, TipoVoto.Abstencao, new Membro("Guilherme", "guilherme", "4321"), new Date(), "justificativa 2"));
		votos.add(voto3 = new Voto(12, TipoVoto.NaoFavoravel, new Membro("William", "william", "0000"), new Date(), "justificativa 3"));
		Votacao votacao = new Votacao(base,  votos);
		
		assertEquals(voto1, votacao.getVotos().get(0));
		assertEquals(voto2, votacao.getVotos().get(1));
		assertEquals(voto3, votacao.getVotos().get(2));
	}

}
