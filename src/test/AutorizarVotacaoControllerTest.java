package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import model.dao.VotacaoDao;
import model.entity.Estado;
import model.entity.EstagioProbatorio;
import model.entity.Votacao;
import model.entity.Voto;

import org.junit.Test;

import controller.AutorizarVotacaoController;

public class AutorizarVotacaoControllerTest {

	@Test
	public void testAutorizaVotacao() {
		Votacao votacao = new Votacao(1, "teste", new Date(), new Date(), Estado.Bloqueada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		
		VotacaoDao.getInstance().insert(votacao);
		
		AutorizarVotacaoController.autorizaVotacao(votacao);
		
		Votacao alterada = VotacaoDao.getInstance().getById(1);
		
		assertTrue(alterada.testaEstado(Estado.Autorizada));
		
		VotacaoDao.getInstance().delete(1);
	}

}
