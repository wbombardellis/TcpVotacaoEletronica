package view.command;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import controller.CriarVotacaoController;
import model.entity.Documentacao;
import model.entity.TipoDocumentacao;

public class CriarVotacaoCommand extends VotacaoCommand {
	
	protected List<TipoDocumentacao> tiposVotacao;

	public CriarVotacaoCommand(Sessao sessao) {
		super(sessao);
		
		this.tiposVotacao = TipoDocumentacao.getListaTodosPossiveis();
	}

	@Override
	public void execute() {
		TipoDocumentacao tipoVoto = MenuHelper.leOpcaoMenu(this.tiposVotacao);
		
		Map<Integer, String> documentosObrigatorios = CriarVotacaoController.getDocumentosObrigatorios(tipoVoto);
		Map<Integer, String> documentosNaoObrigatorios = CriarVotacaoController.getDocumentosNaoObrigatorios(tipoVoto);
		
		// Lê dados da votação
		String titulo = "";
		Date dataInicio = new Date();
		Date dataFim = new Date();
		Documentacao documentacao = null;
		
		CriarVotacaoController.criaVotacao(this.sessao, titulo, dataInicio, dataFim, documentacao);
		
		// Mensagens ao usuário
	}

	@Override
	public String getCodigoTela() {
		return "C";
	}

	@Override
	public String getDescricaoTela() {
		return "Criar Votação";
	}

}
