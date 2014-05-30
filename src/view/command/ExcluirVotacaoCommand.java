package view.command;

import model.dao.VotacaoDao;
import model.entity.Estado;
import model.entity.Votacao;

public class ExcluirVotacaoCommand extends VotacaoCommand {

	public ExcluirVotacaoCommand(Sessao sessao) {
		super(sessao);
		
		this.listaEstados = Estado.getListaTodosPossiveis();
		this.listaEstados.remove(Estado.Finalizada);
	}

	@Override
	public void execute() {
		Votacao votacao = this.leOpcaoListaVotacao(this.listaEstados);
		
		boolean confirmadaExclusao = true;
		if (! votacao.getVotos().isEmpty()) {
			// Infroma usuário e pede confirmação
		}
		
		if (confirmadaExclusao) {
			VotacaoDao.getInstance().delete(votacao.getId());
		}
		
		// Mensagens ao usuário
	}

	@Override
	public String getCodigoTela() {
		return "E";
	}

	@Override
	public String getDescricaoTela() {
		return "Excluir Votação";
	}

}
