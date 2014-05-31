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
			SaidaHelper.imprimeLinhaFromResources("mensagem.ata.semAtas");
		else
			GerarAtaController.criaAta( MenuHelper.leOpcoesMenu(votacoes) );
		
	}

	@Override
	public String getCodigoTela() {
		return "GA";
	}

	@Override
	public String getDescricaoTela() {
		return "Gerar Ata";
	}

}
