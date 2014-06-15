package view.command;

import java.io.IOException;
import java.util.List;

import controller.FecharVotacaoController;
import model.entity.Estado;
import model.entity.Votacao;

public class FecharVotacaoCommand extends VotacaoCommand {

	public FecharVotacaoCommand(Sessao sessao) {
		super(sessao);
		
		this.listaEstados.add(Estado.Aberta);
	}

	@Override
	public void execute() throws IOException {
		Votacao votacao = this.leOpcaoListaVotacao(this.listaEstados);
		
		if (votacao != null) {
			List<String> warnings = FecharVotacaoController.fechaVotacao(votacao);
			
			// Mensagens ao usuário
			if (! warnings.isEmpty()) {
				// Mostra os warnings
				for (String warning : warnings)
					SaidaHelper.imprimeLinha(warning);
			}
			
			SaidaHelper.imprimeLinhaFromResources("fechar.votacao.sucesso");
			SaidaHelper.imprimeLinhaFromResources("simbolo.linha.branco");

		} else {
			SaidaHelper.imprimeLinhaFromResources("mensagem.votacao.semVotacoes");
			SaidaHelper.imprimeLinhaFromResources("simbolo.linha.branco");

		}
	}

	@Override
	public String getCodigoTela() {
		return this.txtManager.getText("fechar.votacao.codigo");
	}

	@Override
	public String getDescricaoTela() {
		return this.txtManager.getText("fechar.votacao");
	}

}
