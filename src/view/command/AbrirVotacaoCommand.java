package view.command;

import java.util.Date;

import model.dao.VotacaoDao;
import model.entity.Estado;
import model.entity.Votacao;

public class AbrirVotacaoCommand extends VotacaoCommand {
	
	public AbrirVotacaoCommand(Sessao sessao) {
		super(sessao);
		
		this.listaEstados.add(Estado.Autorizada);
	}

	@Override
	public void execute() {
		Votacao votacao = this.leOpcaoListaVotacao(this.listaEstados);
		
		// Coloca a data atual na vota√ß√£o escolhida 
		Votacao novaVotacao = new Votacao(votacao, new Date(), votacao.getDataFim());
		
		VotacaoDao.getInstance().update(votacao.getId(), novaVotacao);
		
		// Mensagens ao usu√°rio
	}

	@Override
	public String getCodigoTela() {
		return "O";
	}

	@Override
	public String getDescricaoTela() {
		return "Abrir Votação";
	}

}
