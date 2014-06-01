package view.command;

import controller.AutorizarVotacaoController;
import model.entity.Estado;
import model.entity.Votacao;

public class AutorizarVotacaoCommand extends VotacaoCommand {

	public AutorizarVotacaoCommand(Sessao sessao) {
		super(sessao);
		
		this.listaEstados.add(Estado.Bloqueada);
	}

	@Override
	public void execute()
	{
		Votacao votacao = leOpcaoListaVotacao(this.listaEstados);
		
		AutorizarVotacaoController.autorizaVotacao(votacao);
		
		// Mensagens ao usuário
		SaidaHelper.imprimeLinhaFromResources("autorizacao.votacao.sucesso");
	}

	@Override
	public String getCodigoTela() {
		return "A";
	}

	@Override
	public String getDescricaoTela() 
	{
		return "Autorizar Votacao";
	}

}
