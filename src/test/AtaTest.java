package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import model.AtaVotacaoFactory;
import model.entity.Ata;
import model.entity.AtaVotacao;
import model.entity.Estado;
import model.entity.Membro;
import model.entity.TipoVoto;
import model.entity.Votacao;
import model.entity.Voto;

import org.junit.Test;

public class AtaTest {

	@Test(expected = AssertionError.class)
	public void testAtaFailNull() {
		new Ata(0, null);
	}
	
	@Test(expected = AssertionError.class)
	public void testAtaFailIdNegativo() {
		//Cria elementos apenas para popular a ata
		Membro membro1 = new Membro("membro1", "teste1", "1234");
		Membro membro2 = new Membro("membro2", "teste2", "1234");
		Membro membro3 = new Membro("membro3", "teste3", "1234");
		
		ArrayList<Membro> votantes = new ArrayList<>();
		votantes.add(membro1);
		votantes.add(membro3);
		
		ArrayList<Membro> naoVotantes = new ArrayList<>();
		votantes.add(membro2);
		
		ArrayList<Voto> votos = new ArrayList<>();
		votos.add(new Voto(0, TipoVoto.Favoravel, membro1, new Date(), null));
		votos.add(new Voto(1, TipoVoto.Abstencao, membro3, new Date(), null));
		
		//Cria as votações que serão testadas no método
		Date dtIni1 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dtIni1);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		Date dtFim1 = cal.getTime(); 
		
		Votacao votacao1 = new Votacao(0, "teste1", dtIni1, dtFim1, Estado.Aberta, null, votos);		
		AtaVotacao ataV1 = AtaVotacaoFactory.criaAtaVotacao(votacao1, votantes, naoVotantes);
		
		HashMap<Integer, AtaVotacao> atas = new HashMap<Integer, AtaVotacao>(); 
		atas.put(0, AtaVotacaoFactory.criaAtaVotacao(votacao1, votantes, naoVotantes));
		
		//Test to fail
		new Ata(-1, null);
	}

	@Test
	public void testGetAtasVotacoes() {
		//Cria elementos apenas para popular a ata
		Membro membro1 = new Membro("membro1", "teste1", "1234");
		Membro membro2 = new Membro("membro2", "teste2", "1234");
		Membro membro3 = new Membro("membro3", "teste3", "1234");
		
		ArrayList<Membro> votantes = new ArrayList<>();
		votantes.add(membro1);
		votantes.add(membro3);
		
		ArrayList<Membro> naoVotantes = new ArrayList<>();
		votantes.add(membro2);
		
		ArrayList<Voto> votos = new ArrayList<>();
		votos.add(new Voto(0, TipoVoto.Favoravel, membro1, new Date(), null));
		votos.add(new Voto(1, TipoVoto.Abstencao, membro3, new Date(), null));
		
		//Cria as votações que serão testadas no método
		Date dtIni1 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dtIni1);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		Date dtFim1 = cal.getTime(); 
		
		Votacao votacao1 = new Votacao(0, "teste1", dtIni1, dtFim1, Estado.Aberta, null, votos);		
		AtaVotacao ataV1 = AtaVotacaoFactory.criaAtaVotacao(votacao1, votantes, naoVotantes);
		
		HashMap<Integer, AtaVotacao> atas = new HashMap<Integer, AtaVotacao>(); 
		atas.put(0, ataV1);
		
		Ata ata1 = new Ata(0, atas);
		assertArrayEquals(atas.values().toArray(), ata1.getAtasVotacoes().toArray());
		
		//Imutabilidade
		atas.remove(0);
		assertNotEquals(atas, ata1.getAtasVotacoes());
	}

}
