package view.command;

import model.entity.Estado;
import model.entity.Votacao;

import java.util.ArrayList;
import java.util.List;

public abstract class VotacaoCommand extends Command {

	protected List<Estado> listaEstados;
	
	public VotacaoCommand(Sessao sessao) {
		super(sessao);
		this.listaEstados = new ArrayList<>();
	}

	protected Votacao leOpcaoListaVotacao(List<Estado> estados) {
		return null;
	}

}
