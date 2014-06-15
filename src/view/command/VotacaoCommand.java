package view.command;

import model.dao.VotacaoDao;
import model.entity.Estado;
import model.entity.Votacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class VotacaoCommand extends Command {

	protected List<Estado> listaEstados;
	
	public VotacaoCommand(Sessao sessao) {
		super(sessao);
		this.listaEstados = new ArrayList<>();
	}

	protected Votacao leOpcaoListaVotacao(List<Estado> estados) throws IOException {
		List<Votacao> votacoes = VotacaoDao.getInstance().getVotacoesByEstado(estados);
		if (votacoes.isEmpty())
			return null;
		else
			return MenuHelper.leOpcaoMenu(votacoes);
	}

}
