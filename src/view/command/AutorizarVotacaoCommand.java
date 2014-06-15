package view.command;

import java.io.IOException;

import controller.AutorizarVotacaoController;
import model.entity.Estado;
import model.entity.Votacao;

public class AutorizarVotacaoCommand extends VotacaoCommand {

	public AutorizarVotacaoCommand(Sessao sessao) {
		super(sessao);
		
		this.listaEstados.add(Estado.Bloqueada);
	}

	@Override
	public void execute() throws IOException {
		Votacao votacao = leOpcaoListaVotacao(this.listaEstados);
		
		if (votacao != null) {
			AutorizarVotacaoController.autorizaVotacao(votacao);
			
			// Mensagens ao usuário
			SaidaHelper.imprimeLinhaFromResources("autorizar.votacao.sucesso");
			SaidaHelper.imprimeLinhaFromResources("simbolo.linha.branco");

		} else {
			SaidaHelper.imprimeLinhaFromResources("mensagem.votacao.semVotacoes");
			SaidaHelper.imprimeLinhaFromResources("simbolo.linha.branco");

		}
	}

	@Override
	public String getCodigoTela() {
		return this.txtManager.getText("autorizar.votacao.codigo");
	}

	@Override
	public String getDescricaoTela() 
	{
		return this.txtManager.getText("autorizar.votacao");
	}

}
