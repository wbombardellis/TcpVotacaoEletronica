package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import model.dao.VotacaoDao;
import model.entity.Estado;
import model.entity.EstagioProbatorio;
import model.entity.Votacao;
import model.entity.Voto;

import org.junit.Test;

public class VotacaoDaoTest {

	@Test
	public void testGetVotacoesByEstado() {

		List<Votacao> listExpected = new ArrayList<>();
		Votacao votacao = new Votacao(1, "teste", new Date(), new Date(115,0,1), Estado.Bloqueada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		listExpected.add(votacao);
		VotacaoDao.getInstance().insert(votacao);
		
		votacao = new Votacao(2, "teste", new Date(), new Date(115,0,1), Estado.Bloqueada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		listExpected.add(votacao);
		VotacaoDao.getInstance().insert(votacao);
		
		votacao = new Votacao(3, "teste", new Date(114,11,15), new Date(115,0,1), Estado.Liberada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		VotacaoDao.getInstance().insert(votacao);
		
		List<Estado> listEstados = new ArrayList<>();
		listEstados.add(Estado.Bloqueada);
		List result = VotacaoDao.getInstance().getVotacoesByEstado(listEstados);
		
		assertEquals(listExpected, result);
		
		listExpected.add(votacao);
		listEstados.add(Estado.Liberada);
		result = VotacaoDao.getInstance().getVotacoesByEstado(listEstados);
		assertEquals(listExpected, result);
		
		
		votacao = new Votacao(4, "teste", new Date(114,11,15), new Date(115,0,1), Estado.Autorizada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		VotacaoDao.getInstance().insert(votacao);
		
		listExpected.add(votacao);
		listEstados.add(Estado.Autorizada);
		result = VotacaoDao.getInstance().getVotacoesByEstado(listEstados);
		assertEquals(listExpected, result);
		
		VotacaoDao.getInstance().delete(1);
		VotacaoDao.getInstance().delete(2);
		VotacaoDao.getInstance().delete(3);
		VotacaoDao.getInstance().delete(4);
	}

	@Test
	public void testGetVotacoesByEstadoNot() {
		List<Votacao> listExpected = new ArrayList<>();
		Votacao votacao = new Votacao(1, "teste", new Date(), new Date(115,0,1), Estado.Bloqueada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		listExpected.add(votacao);
		VotacaoDao.getInstance().insert(votacao);
		
		votacao = new Votacao(2, "teste", new Date(), new Date(115,0,1), Estado.Bloqueada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		listExpected.add(votacao);
		VotacaoDao.getInstance().insert(votacao);
		
		votacao = new Votacao(3, "teste", new Date(114,11,15), new Date(115,0,1), Estado.Liberada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		listExpected.add(votacao);
		VotacaoDao.getInstance().insert(votacao);
		
		List<Estado> listEstados = new ArrayList<>();
		listEstados.add(Estado.Autorizada);
		List result = VotacaoDao.getInstance().getVotacoesByEstadoNot(listEstados);
		
		assertEquals(listExpected, result);
		
		listExpected.remove(2);
		listEstados.add(Estado.Liberada);
		result = VotacaoDao.getInstance().getVotacoesByEstadoNot(listEstados);
		assertEquals(listExpected, result);
		
		
		votacao = new Votacao(4, "teste", new Date(), new Date(115,0,1), Estado.Autorizada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		VotacaoDao.getInstance().insert(votacao);
		
		result = VotacaoDao.getInstance().getVotacoesByEstadoNot(listEstados);
		assertEquals(listExpected, result);

		VotacaoDao.getInstance().delete(1);
		VotacaoDao.getInstance().delete(2);
		VotacaoDao.getInstance().delete(3);
		VotacaoDao.getInstance().delete(4);
	}

}
