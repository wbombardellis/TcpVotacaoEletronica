package view.command;

import java.io.IOException;
import java.util.List;

import controller.FecharVotacaoController;
import model.entity.Votacao;

public class FecharVotacaoCommand extends VotacaoCommand {

	public FecharVotacaoCommand(Sessao sessao) {
		super(sessao);
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
		} else {
			SaidaHelper.imprimeLinhaFromResources("mensagem.votacao.semVotacoes");
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
