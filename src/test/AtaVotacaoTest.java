package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.AtaVotacaoFactory;
import model.entity.AtaVotacao;
import model.entity.Estado;
import model.entity.Membro;
import model.entity.TipoVoto;
import model.entity.Votacao;
import model.entity.Voto;

import org.junit.Before;
import org.junit.Test;

public class AtaVotacaoTest {
	
	@Test(expected = AssertionError.class)
	public void testAtaVotacaoFail() {
		new AtaVotacao(0, null, null, null);
	}

	@Test
	public void testAtaVotacao() {
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
		AtaVotacao ataV1 = new AtaVotacao(1, votacao1, votantes, naoVotantes);
		
		//Verifica Atributos
		assertEquals(dtIni1, ataV1.getDataInicio());
		assertEquals(dtFim1, ataV1.getDataFim());
		assertEquals(1, ataV1.getId());
		assertEquals(votos, ataV1.getVotos());
		assertEquals(votacao1, ataV1.getVotacao());
		assertEquals(votantes, ataV1.getVotantes());
		assertEquals(naoVotantes, ataV1.getNaoVotantes());
		List<Membro> abst = new ArrayList<>();
		abst.add(membro3);
		assertEquals(abst, ataV1.getAbstencoes());
		
		//Imutabilidade
		votos.add(new Voto(1, TipoVoto.Favoravel, membro1, new Date(), null));
		assertNotEquals(votos, ataV1.getVotos());
		votantes.add(new Membro("a","a","1234"));
		assertNotEquals(votantes, ataV1.getVotantes());
		naoVotantes.add(new Membro("b","b","1234"));
		assertNotEquals(naoVotantes, ataV1.getNaoVotantes());

		//Testes Triviais
		Votacao votacao2 = new Votacao(2, "teste2", new Date(), new Date(), Estado.Aberta, null, new ArrayList<Voto>());
		AtaVotacao ataV2 = new AtaVotacao(2, votacao2, new ArrayList<Membro>(), new ArrayList<Membro>());
		
		assertEquals(new ArrayList<Voto>(), ataV2.getVotos());
		assertEquals(new ArrayList<Membro>(), ataV2.getVotantes());
		assertEquals(new ArrayList<Membro>(), ataV2.getNaoVotantes());
		assertEquals(new ArrayList<Membro>(), ataV2.getAbstencoes());
	}
	
	@Test
	public void testAtaVotacaoResultado1() {
		//Cria elementos apenas para popular a ata
		Membro membro1 = new Membro("membro1", "teste1", "1234");
		Membro membro2 = new Membro("membro2", "teste2", "1234");
		Membro membro3 = new Membro("membro3", "teste3", "1234");
		Membro membro4 = new Membro("membro4", "teste4", "1234");
		Membro membro5 = new Membro("membro5", "teste5", "1234");
		Membro membro6 = new Membro("membro6", "teste6", "1234");
		Membro membro7 = new Membro("membro7", "teste7", "1234");
		
		ArrayList<Membro> votantes = new ArrayList<>();
		votantes.add(membro1);
		votantes.add(membro3);
		
		ArrayList<Membro> naoVotantes = new ArrayList<>();
		votantes.add(membro2);
		
		ArrayList<Voto> votos = new ArrayList<>();
		votos.add(new Voto(0, TipoVoto.Favoravel, membro1, new Date(), null));
		votos.add(new Voto(1, TipoVoto.Abstencao, membro3, new Date(), null));
		votos.add(new Voto(2, TipoVoto.NaoFavoravel, membro4, new Date(), null));
		
		//Cria as votações que serão testadas no método
		Date dtIni1 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dtIni1);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		Date dtFim1 = cal.getTime(); 
		
		//Cenário 1 - Empate
		Votacao votacao1 = new Votacao(0, "teste1", dtIni1, dtFim1, Estado.Aberta, null, votos);		
		AtaVotacao ataV1 = new AtaVotacao(1, votacao1, votantes, naoVotantes);
		assertEquals(1, ataV1.getQtdVotosFavoriaveis());
		assertEquals(1, ataV1.getQtdVotosNaoFavoriaveis());
		assertFalse(ataV1.getResultado());
		
		//Cenário 2 - Resultado Positivo
		votos.add(new Voto(3, TipoVoto.Favoravel, membro5, new Date(), null));
		votantes.add(membro5);
		Votacao votacao2 = new Votacao(votacao1, votos);		
		AtaVotacao ataV2 = new AtaVotacao(2, votacao2, votantes, naoVotantes);
		assertEquals(2, ataV1.getQtdVotosFavoriaveis());
		assertEquals(1, ataV1.getQtdVotosNaoFavoriaveis());
		assertTrue(ataV2.getResultado());
		
		//Cenário 2 - Resultado Positivo
		votos.add(new Voto(4, TipoVoto.NaoFavoravel, membro6, new Date(), null));
		votos.add(new Voto(5, TipoVoto.NaoFavoravel, membro7, new Date(), null));
		votantes.add(membro6);
		votantes.add(membro7);
		Votacao votacao3 = new Votacao(votacao1, votos);		
		AtaVotacao ataV3 = new AtaVotacao(3, votacao3, votantes, naoVotantes);
		assertEquals(2, ataV1.getQtdVotosFavoriaveis());
		assertEquals(3, ataV1.getQtdVotosNaoFavoriaveis());
		assertFalse(ataV2.getResultado());
	}

}