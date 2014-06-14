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
				return AfastamentoPais.staticgetDescricaoDocumentosObrigatorios();
			case ProgressaoFuncional:
				return ProgressaoFuncional.staticgetDescricaoDocumentosObrigatorios();
			case EstagioProbatorio:
				return EstagioProbatorio.staticgetDescricaoDocumentosObrigatorios();
			default:
				assert(false);
				return null;
		}
	}

	public static Map<Integer,String> getDocumentosNaoObrigatorios(TipoDocumentacao tipoDocumentacao) {
		switch (tipoDocumentacao) {
			case AfastamentoPais:
				return AfastamentoPais.staticgetDescricaoDocumentosNaoObrigatorios();
			case ProgressaoFuncional:
				return ProgressaoFuncional.staticgetDescricaoDocumentosNaoObrigatorios();
			case EstagioProbatorio:
				return EstagioProbatorio.staticgetDescricaoDocumentosNaoObrigatorios();
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
		Votacao votacao = new Votacao(votacaoDao.getLastInsertedId()+1,
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
