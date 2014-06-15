package view.command;

import java.io.IOException;
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
	public void execute() throws IOException {
		Votacao votacao = this.leOpcaoListaVotacao(this.listaEstados);
		
		if (votacao != null) {
			List<String> warnings = LiberarVotacaoController.liberaVotacao(votacao);
			
			// Mensagens ao usuário
			if (! warnings.isEmpty()) {
				// Mostra os warnings
				for (String warning : warnings)
					SaidaHelper.imprimeLinha(warning);
			}
			
			SaidaHelper.imprimeLinhaFromResources("liberar.votacao.sucesso");
		} else {
			SaidaHelper.imprimeLinhaFromResources("mensagem.votacao.semVotacoes");
		}
	}

	@Override
	public String getCodigoTela() {
		return this.txtManager.getText("liberar.votacao.codigo");
	}

	@Override
	public String getDescricaoTela() {
		return this.txtManager.getText("liberar.votacao");
	}

}
