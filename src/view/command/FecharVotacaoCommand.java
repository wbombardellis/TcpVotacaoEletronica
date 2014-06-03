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
		
		List<String> warnings = FecharVotacaoController.fechaVotacao(votacao);
		
		// Mensagens ao usuário
		if (! warnings.isEmpty()) {
			// Mostra os warnings
			for (String warning : warnings)
				SaidaHelper.imprimeLinha(warning);
		}
		
		SaidaHelper.imprimeLinhaFromResources("fechar.votacao.sucesso");
	}

	@Override
	public String getCodigoTela() {
		return "F";
	}

	@Override
	public String getDescricaoTela() {
		return "Fechar Votação";
	}

}
