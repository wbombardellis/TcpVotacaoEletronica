package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import model.entity.Estado;
import model.entity.EstagioProbatorio;
import model.entity.Votacao;
import model.entity.Voto;

import org.junit.Test;

public class VotacaoTest {

	@Test
	public void testTestaEstado() {
		fail("Not yet implemented");
	}

	@Test
	public void testVotacaoIntStringDateDateEstadoDocumentacaoListOfVoto() {
		Date ini, fim;
		Votacao votacao = new Votacao(1,
				"teste",
				(ini = new Date()),
				(fim = new Date(2014,0,1)),
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
				(fim = new Date(2014,0,1)),
				Estado.Autorizada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		
		assertEquals(Estado.Autorizada, votacao.getEstado());
		
		votacao = new Votacao(1,
				"teste",
				(ini = new Date()),
				(fim = new Date(2014,0,1)),
				Estado.Liberada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		
		assertEquals(Estado.Liberada, votacao.getEstado());
		
		votacao = new Votacao(1,
				"teste",
				(ini = new Date(2014, 11,30)),
				(fim = new Date(2015,0,1)),
				Estado.Liberada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		
		assertEquals(Estado.Liberada, votacao.getEstado());
	}

	@Test
	public void testVotacaoVotacaoEstado() {
		fail("Not yet implemented");
	}

	@Test
	public void testVotacaoVotacaoDateDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testVotacaoVotacaoListOfVoto() {
		fail("Not yet implemented");
	}

}
