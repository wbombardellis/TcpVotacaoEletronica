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

import controller.FecharVotacaoController;

public class FecharVotacaoControllerTest {

	@Test
	public void testFechaVotacao() {
		
		Votacao votacao = new Votacao(1, "teste", new Date(), new Date(115,0,1), Estado.Bloqueada,
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()),
				new ArrayList<Voto>());
		
		VotacaoDao.getInstance().insert(votacao);
		
		FecharVotacaoController.fechaVotacao(votacao);
		
		// sleep por 1 segundo pra testar abaixo se os teste de finalização de votação é verdadeiro
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Votacao alterada = VotacaoDao.getInstance().getById(1);
		
		assertTrue(alterada.testaEstado(Estado.Finalizada));
		
		VotacaoDao.getInstance().delete(1);
	}

}
