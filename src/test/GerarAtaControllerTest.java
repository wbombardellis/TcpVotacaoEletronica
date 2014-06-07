package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.dao.AtaDao;
import model.dao.AtaVotacaoDao;
import model.entity.Ata;
import model.entity.Estado;
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
		
		Votacao votacao1 = new Votacao(0, "teste1", dtIni1, dtFim1, Estado.Aberta, null, votos);
		List<Votacao> votacoes = new ArrayList<>();
		votacoes.add(votacao1);
		
		GerarAtaController.criaAta(votacoes);
		
		assertEquals(votacoes, AtaDao.getInstance().getAll());
		assertEquals(votacao1, AtaVotacaoDao.getInstance().getById(1));		
	}

}
