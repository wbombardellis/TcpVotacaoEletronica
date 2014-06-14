package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import model.dao.VotacaoDao;
import model.entity.Estado;
import model.entity.Membro;
import model.entity.TipoVoto;
import model.entity.Votacao;
import model.entity.Voto;

import org.junit.Test;

import controller.CriarVotacaoController;
import controller.VotarController;

public class VotarControllerTest {

	@Test(expected = AssertionError.class)
	public void testInsereVotoFailNull() {
		VotarController.insereVoto(null, null);
	}
	
	@Test(expected = AssertionError.class)
	public void testInsereVotoFailVotacao() {
		//Cria elementos apenas para popular a ata
		Membro membro1 = new Membro("membro1", "teste1", "1234");
		Membro membro2 = new Membro("membro2", "teste2", "1234");
		Membro membro3 = new Membro("membro3", "teste3", "1234");
		
		ArrayList<Voto> votos = new ArrayList<>();
		votos.add(new Voto(0, TipoVoto.Favoravel, membro1, new Date(), null));
		votos.add(new Voto(1, TipoVoto.Abstencao, membro2, new Date(), null));
		
		//Cria as votações que serão testadas no método
		Date dtIni1 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dtIni1);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		Date dtFim1 = cal.getTime(); 
		
		Votacao votacao1 = new Votacao(1, "teste1", dtIni1, dtFim1, Estado.Aberta, null, votos);
		
		//Deve gerar erro, pois votacao1 não está no dao
		VotarController.insereVoto(votacao1, new Voto(2, TipoVoto.Abstencao, membro3, new Date(), null));
	}
	
	@Test
	public void testInsereVoto() {
		//Cria elementos apenas para popular a ata
		Membro membro1 = new Membro("membro1", "teste1", "1234");
		Membro membro2 = new Membro("membro2", "teste2", "1234");
		Membro membro3 = new Membro("membro3", "teste3", "1234");
		Membro membro4 = new Membro("membro4", "teste4", "1234");
		
		ArrayList<Voto> votos = new ArrayList<>();
		votos.add(new Voto(0, TipoVoto.Favoravel, membro1, new Date(), null));
		votos.add(new Voto(1, TipoVoto.Abstencao, membro2, new Date(), null));
		
		//Cria as votações que serão testadas no método
		Date dtIni1 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dtIni1);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		Date dtFim1 = cal.getTime(); 
		
		Votacao votacao1 = new Votacao(1, "teste1", dtIni1, dtFim1, Estado.Aberta, null, votos);
		
		///Não utiliza o AtaVotacaoDaoStub aqui, pois o controller consulta o AtaVotacaoDao, então supõe que está vazio
		VotacaoDao votacaoDao = VotacaoDao.getInstance();
		votacaoDao.insert(votacao1);
		
		Voto votoAdded = new Voto(2, TipoVoto.Abstencao, membro3, new Date(), null);
		VotarController.insereVoto(votacao1, votoAdded);
		
		//Deve ter adicionado o voto
		votos.add(votoAdded);
		assertEquals(votos, votacaoDao.getById(1).getVotos());
		assertEquals(votoAdded, VotarController.getVotoByAutor(votacao1, membro3));
		
		votos.remove(votoAdded);
		VotarController.removeVoto(votacao1, votoAdded);
		assertEquals(votos, votacaoDao.getById(1).getVotos());
		assertNull(VotarController.getVotoByAutor(votacao1, membro3));
		
		assertNull(VotarController.getVotoByAutor(votacao1, membro4));
	}

	@Test(expected = AssertionError.class)
	public void testRemoveVotoFail() {
		VotarController.removeVoto(null, null);
	}

	@Test(expected = AssertionError.class)
	public void testGetVotoByAutorFail() {
		VotarController.getVotoByAutor(null, null);
	}

}
