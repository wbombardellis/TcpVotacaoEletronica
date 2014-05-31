package view.command;

import java.util.List;

import controller.GerarAtaController;
import model.dao.VotacaoDao;
import model.entity.Votacao;

public class GerarAtaCommand extends Command {

	public GerarAtaCommand(Sessao sessao) {
		super(sessao);
	}

	@Override
	public void execute() {
		List<Votacao> votacoes = VotacaoDao.getInstance().getVotacoesSemAta();
		
		if (votacoes.isEmpty())
			//Não há votações
			;
		else
			GerarAtaController.criaAta( MenuHelper.leOpcoesMenu(votacoes) );
		
	}

	@Override
	public String getCodigoTela() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescricaoTela() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void imprimeOpcaoTela() {
		// TODO Auto-generated method stub
		
	}

}
