package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import model.dao.AtaDao;
import model.dao.AtaVotacaoDao;
import model.dao.MembroDao;
import model.dao.VotacaoDao;
import model.entity.Ata;
import model.entity.Estado;
import model.entity.EstagioProbatorio;
import model.entity.Membro;
import model.entity.TipoVoto;
import model.entity.Votacao;
import model.entity.Voto;

import org.junit.Test;

import controller.GerarAtaController;

public class GerarAtaControllerTest {

	@Test(expected = AssertionError.class)
	public void testCriaAtaFail() {
		GerarAtaController.criaAta(null);
	}
	
	@Test
	public void testCriaAta() {
		//Cria elementos apenas para popular a ata
		MembroDao mDao = MembroDao.getInstance();
		Membro membro1 = new Membro("membro1", "teste1", "1234");
		mDao.insert(membro1);
		Membro membro2 = new Membro("membro2", "teste2", "1234");
		mDao.insert(membro2);
		Membro membro3 = new Membro("membro3", "teste3", "1234");
		mDao.insert(membro3);
				
		ArrayList<Voto> votos = new ArrayList<>();
		votos.add(new Voto(0, TipoVoto.Favoravel, membro1, new Date(), null));
		votos.add(new Voto(1, TipoVoto.Abstencao, membro2, new Date(), null));
		
		//Cria as votações que serão testadas no método
		Date dtIni1 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dtIni1);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		Date dtFim1 = cal.getTime(); 
		
		Votacao votacao1 = new Votacao(0, "teste1", dtIni1, dtFim1, Estado.Aberta, new EstagioProbatorio(new HashMap<Integer, String>(), new HashMap<Integer, String>()), votos);
		List<Votacao> votacoes = new ArrayList<>();
		votacoes.add(votacao1);
		
		////Supõe que AtaDao e AtaVotação estão vazios (sem elementos) e que os lastInsertedIds são zeros
		GerarAtaController.criaAta(votacoes);
		//Portanto pode utilizar o AtaDao e AtaVotacaoDao nas versões originais, sem stub
		AtaVotacaoDao ataVDao = AtaVotacaoDao.getInstance();
		AtaDao ataDao = AtaDao.getInstance();
		assertNotNull(ataDao.getAll());
		assertNotNull(ataVDao.getAll());
		assertEquals(votacao1, ataVDao.getById(ataVDao.getLastInsertedId()).getVotacao());
		
		//Apaga o que foi inserido, para que o objeto singleton seja utilizado mais tarde
		assertTrue(ataVDao.delete(ataVDao.getLastInsertedId()));
		assertTrue(ataDao.delete(ataDao.getLastInsertedId()));
		assertTrue(mDao.delete(membro1.getId()));
		assertTrue(mDao.delete(membro2.getId()));
		assertTrue(mDao.delete(membro3.getId()));
	}

}
