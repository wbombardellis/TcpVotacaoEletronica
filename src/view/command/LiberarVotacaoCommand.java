package view.command;

import java.util.List;

import controller.LiberarVotacaoController;
import model.entity.Estado;
import model.entity.Votacao;

public class LiberarVotacaoCommand extends VotacaoCommand {

	public LiberarVotacaoCommand(Sessao sessao) {
		super(sessao);
		
		this.listaEstados.add(Estado.Autorizada);
	}

	@Override
	public void execute() {
		Votacao votacao = this.leOpcaoListaVotacao(this.listaEstados);
		
		List<String> warnings = LiberarVotacaoController.liberaVotacao(votacao);
		
		// Mensagens ao usuário
		if (! warnings.isEmpty()) {
			// Mostra os warnings
			for (String warning : warnings)
				SaidaHelper.imprimeLinha(warning);
		}
		
		SaidaHelper.imprimeLinhaFromResources("liberar.votacao.sucesso");
	}

	@Override
	public String getCodigoTela() {
		return "L";
	}

	@Override
	public String getDescricaoTela() {
		return "Liberar Votação";
	}

}
