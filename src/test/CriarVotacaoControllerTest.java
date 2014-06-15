package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import model.dao.VotacaoDao;
import model.entity.AfastamentoPais;
import model.entity.EstagioProbatorio;
import model.entity.ProgressaoFuncional;
import model.entity.TipoDocumentacao;
import model.entity.Votacao;

import org.junit.Test;

import view.command.Sessao;
import controller.CriarVotacaoController;

public class CriarVotacaoControllerTest {

	@Test
	public void testGetDocumentosObrigatorios() {
		Map<Integer, String> docs;
		docs = CriarVotacaoController.getDocumentosObrigatorios(TipoDocumentacao.AfastamentoPais);
		assertEquals(docs, AfastamentoPais.staticgetDescricaoDocumentosObrigatorios());
		
		docs = CriarVotacaoController.getDocumentosObrigatorios(TipoDocumentacao.EstagioProbatorio);
		assertEquals(docs, EstagioProbatorio.staticgetDescricaoDocumentosObrigatorios());
		
		docs = CriarVotacaoController.getDocumentosObrigatorios(TipoDocumentacao.ProgressaoFuncional);
		assertEquals(docs, ProgressaoFuncional.staticgetDescricaoDocumentosObrigatorios());
	}

	@Test
	public void testGetDocumentosNaoObrigatorios() {
		Map<Integer, String> docs;
		docs = CriarVotacaoController.getDocumentosNaoObrigatorios(TipoDocumentacao.AfastamentoPais);
		assertEquals(docs, AfastamentoPais.staticgetDescricaoDocumentosNaoObrigatorios());
		
		docs = CriarVotacaoController.getDocumentosNaoObrigatorios(TipoDocumentacao.EstagioProbatorio);
		assertEquals(docs, EstagioProbatorio.staticgetDescricaoDocumentosNaoObrigatorios());
		
		docs = CriarVotacaoController.getDocumentosNaoObrigatorios(TipoDocumentacao.ProgressaoFuncional);
		assertEquals(docs, ProgressaoFuncional.staticgetDescricaoDocumentosNaoObrigatorios());
	}

	@Test
	public void testCriaVotacao() {
		Date ini, fim;
		CriarVotacaoController.criaVotacao(Sessao.getInstance(), "Título", ini = new Date(), fim = new Date(),
				new EstagioProbatorio(new HashMap<Integer,String>(), new HashMap<Integer,String>()));
		
		Votacao votacao = (Votacao)VotacaoDao.getInstance().getAll().toArray()[0];
		assertEquals("Título", votacao.getTitulo());
		assertEquals(ini, votacao.getDataInicio());
		assertEquals(fim, votacao.getDataFim());
		assertTrue(votacao.getDocumentacao()  instanceof EstagioProbatorio);
		VotacaoDao.getInstance().delete(votacao.getId());

		CriarVotacaoController.criaVotacao(Sessao.getInstance(), "Título", ini = new Date(), fim = new Date(),
				new AfastamentoPais(new HashMap<Integer,String>(), new HashMap<Integer,String>()));
		votacao = (Votacao)VotacaoDao.getInstance().getAll().toArray()[0];
		assertTrue(votacao.getDocumentacao()  instanceof AfastamentoPais);
		VotacaoDao.getInstance().delete(votacao.getId());
		
		CriarVotacaoController.criaVotacao(Sessao.getInstance(), "Título", ini = new Date(), fim = new Date(),
				new ProgressaoFuncional(new HashMap<Integer,String>(), new HashMap<Integer,String>()));
		votacao = (Votacao)VotacaoDao.getInstance().getAll().toArray()[0];
		assertTrue(votacao.getDocumentacao()  instanceof ProgressaoFuncional);
		VotacaoDao.getInstance().delete(votacao.getId());
	}

}
