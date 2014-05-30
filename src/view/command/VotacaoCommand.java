package view.command;

import model.entity.Estado;
import model.entity.Votacao;

import java.util.List;

public abstract class VotacaoCommand extends Command {

	public VotacaoCommand(Sessao sessao) {
		super(sessao);
	}

	protected Votacao leOpcaoListaVotacao(List<Estado> estados) {
		return null;
	}

}
