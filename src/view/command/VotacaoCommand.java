package view.command;

import model.entity.Votacao;
import java.util.List;

public abstract class VotacaoCommand extends Command {

	protected Votacao leOpcaoListaVotacao(List<Estado> estados) {
		return null;
	}

}
