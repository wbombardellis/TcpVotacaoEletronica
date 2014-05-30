package controller;

import java.util.Map;
import model.entity.TipoDocumentacao;
import view.command.Sessao;
import java.util.Date;
import model.entity.Documentacao;

public abstract class CriarVotacaoController {

	public static Map<Integer,String> getDocumentosObrigatorios(TipoDocumentacao tipodocumentacao) {
		return null;
	}

	public static Map<Integer,String> getDocumentosNaoObrigatorios(TipoDocumentacao tipoDocumentacao) {
		return null;
	}

	public static void criaVotacao(Sessao sessao, String titulo, Date dataInicio, Date dataFim, Documentacao documentacao) {

	}

}
