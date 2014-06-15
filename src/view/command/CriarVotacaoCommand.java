package view.command;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	public void execute() throws IOException {
		SaidaHelper.imprimeLinhaFromResources("criar.votacao.info.tipo");
		TipoDocumentacao tipoVoto = MenuHelper.leOpcaoMenu(this.tiposVotacao);
		
		Map<Integer, String> documentosObrigatorios = CriarVotacaoController.getDocumentosObrigatorios(tipoVoto);
		Map<Integer, String> documentosNaoObrigatorios = CriarVotacaoController.getDocumentosNaoObrigatorios(tipoVoto);
		
		// Lê dados da votação
		String titulo = MenuHelper.leStringComMensagemFromResources("votacao.titulo");
		Date dataInicio = MenuHelper.leDateComMensagemFromResources("votacao.dataInicio");
		Date dataFim = MenuHelper.leDateComMensagemFromResources("votacao.dataFim");

		// Lê dados da documentação da votação
		Map<Integer, String> caminhoDocumentacaoObrigatoria = new HashMap<>();
		for (Entry<Integer, String> documento : documentosObrigatorios.entrySet()) {
			caminhoDocumentacaoObrigatoria.put(
					documento.getKey(),
					MenuHelper.leStringOpicionalComMensagem(documento.getValue()+": ")
			);
		}
		Map<Integer, String> caminhoDocumentacaoNaoObrigatoria = new HashMap<>();
		for (Entry<Integer, String> documento : documentosNaoObrigatorios.entrySet()) {
			caminhoDocumentacaoNaoObrigatoria.put(
					documento.getKey(),
					MenuHelper.leStringOpicionalComMensagem(documento.getValue()+": ")
			);
		}
		Documentacao documentacao = tipoVoto.createNewInstance(caminhoDocumentacaoObrigatoria, caminhoDocumentacaoNaoObrigatoria);
		
		// Chama controller para criação da votação
		CriarVotacaoController.criaVotacao(this.sessao, titulo, dataInicio, dataFim, documentacao);
		
		// Mensagens ao usuário
		SaidaHelper.imprimeLinhaFromResources("criar.votacao.sucesso");
		SaidaHelper.imprimeLinhaFromResources("simbolo.linha.branco");

	}

	@Override
	public String getCodigoTela() {
		return this.txtManager.getText("criar.votacao.codigo");
	}

	@Override
	public String getDescricaoTela() {
		return this.txtManager.getText("criar.votacao");
	}

}
