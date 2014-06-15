package view.command;

import java.io.IOException;
import java.util.Date;

import model.dao.VotacaoDao;
import model.entity.Estado;
import model.entity.Votacao;

public class AbrirVotacaoCommand extends VotacaoCommand {
	
	public AbrirVotacaoCommand(Sessao sessao) {
		super(sessao);
		
		this.listaEstados.add(Estado.Liberada);
	}

	@Override
	public void execute() throws IOException {
		Votacao votacao = this.leOpcaoListaVotacao(this.listaEstados);
		
		if (votacao != null) {
			// Coloca a data atual na votação escolhida 
			Votacao novaVotacao = new Votacao(votacao, new Date(), votacao.getDataFim());
			
			VotacaoDao.getInstance().update(votacao.getId(), novaVotacao);
			
			// Mensagens ao usuário
			SaidaHelper.imprimeLinhaFromResources("abrir.votacao.sucesso");
			SaidaHelper.imprimeLinhaFromResources("simbolo.linha.branco");
		} else {
			SaidaHelper.imprimeLinhaFromResources("mensagem.votacao.semVotacoes");
			SaidaHelper.imprimeLinhaFromResources("simbolo.linha.branco");

		}
	}

	@Override
	public String getCodigoTela() {
		return this.txtManager.getText("abrir.votacao.codigo");
	}

	@Override
	public String getDescricaoTela() {
		return this.txtManager.getText("abrir.votacao");
	}

}
