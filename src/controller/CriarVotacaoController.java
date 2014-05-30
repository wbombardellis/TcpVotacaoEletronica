package controller;

import java.util.ArrayList;
import java.util.Map;

import model.dao.VotacaoDao;
import model.entity.AfastamentoPais;
import model.entity.Estado;
import model.entity.EstagioProbatorio;
import model.entity.ProgressaoFuncional;
import model.entity.Secretario;
import model.entity.TipoDocumentacao;
import model.entity.Votacao;
import model.entity.Voto;
import view.command.Sessao;

import java.util.Date;

import model.entity.Documentacao;

public abstract class CriarVotacaoController {

	public static Map<Integer,String> getDocumentosObrigatorios(TipoDocumentacao tipoDocumentacao) {
		switch (tipoDocumentacao) {
			case AfastamentoPais:
				return AfastamentoPais.getDescricaoDocumentosObrigatorios();
			case ProgressaoFuncional:
				return ProgressaoFuncional.getDescricaoDocumentosObrigatorios();
			case EstagioProbatorio:
				return EstagioProbatorio.getDescricaoDocumentosObrigatorios();
			default:
				assert(false);
				return null;
		}
	}

	public static Map<Integer,String> getDocumentosNaoObrigatorios(TipoDocumentacao tipoDocumentacao) {
		switch (tipoDocumentacao) {
			case AfastamentoPais:
				return AfastamentoPais.getDescricaoDocumentosNaoObrigatorios();
			case ProgressaoFuncional:
				return ProgressaoFuncional.getDescricaoDocumentosNaoObrigatorios();
			case EstagioProbatorio:
				return EstagioProbatorio.getDescricaoDocumentosNaoObrigatorios();
			default:
				assert(false);
				return null;
		}
	}

	public static void criaVotacao(Sessao sessao, String titulo, Date dataInicio, Date dataFim, Documentacao documentacao) {
		
		Estado estado;
		if (sessao.getMembro() instanceof Secretario) {
			estado = Estado.Bloqueada;
		} else {
			estado = Estado.Autorizada;
		}
		
		VotacaoDao votacaoDao = VotacaoDao.getInstance();
		Votacao votacao = new Votacao(votacaoDao.getLastInsertedId(),
				titulo,
				dataInicio,
				dataFim,
				estado,
				documentacao,
				new ArrayList<Voto>()
			);
		
		votacaoDao.insert(votacao);
	}

}
