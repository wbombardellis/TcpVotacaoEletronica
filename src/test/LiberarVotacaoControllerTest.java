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

import controller.LiberarVotacaoController;

public class LiberarVotacaoControllerTest {

	@Test
	public void testLiberaVotacao() {
		Votacao votacao = new Votacao(1, "teste", new Date(114,11,15), new Date(115,0,1), Estado.Bloqueada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		
		VotacaoDao.getInstance().insert(votacao);
		
		LiberarVotacaoController.liberaVotacao(votacao);
		
		Votacao alterada = VotacaoDao.getInstance().getById(1);
		
		assertTrue(alterada.testaEstado(Estado.Liberada));
		
		VotacaoDao.getInstance().delete(1);
	}

}
