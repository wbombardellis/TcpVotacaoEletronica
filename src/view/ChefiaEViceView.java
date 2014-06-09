package view;

import view.command.AutorizarVotacaoCommand;
import view.command.CriarVotacaoCommand;
import view.command.ExcluirVotacaoCommand;
import view.command.FecharVotacaoCommand;
import view.command.GerarAtaCommand;
import view.command.LerAtaCommand;
import view.command.ListarVotacaoCommand;
import view.command.MenuHelper;
import view.command.Sessao;
import view.command.VisualizarVotacaoCommand;

public class ChefiaEViceView extends View 
{
	public ChefiaEViceView()
	{
		Sessao sessao = Sessao.getInstance();
		this.commandsPossiveis.add(new CriarVotacaoCommand(sessao));
		this.commandsPossiveis.add(new AutorizarVotacaoCommand(sessao));
		this.commandsPossiveis.add(new ListarVotacaoCommand(sessao));
		this.commandsPossiveis.add(new VisualizarVotacaoCommand(sessao));
		// this.commandsPossiveis.add(); Alterar Voto Command? Como é implementado?
		this.commandsPossiveis.add(new LerAtaCommand(sessao)); // imprimir resultado da votação é isso?
		this.commandsPossiveis.add(new FecharVotacaoCommand(sessao));
		this.commandsPossiveis.add(new ExcluirVotacaoCommand(sessao));
		this.commandsPossiveis.add(new GerarAtaCommand(sessao));
	}

	public void imprimeMenu() 
	{
		MenuHelper.imprimeOpcoes(commandsPossiveis);
	}

}
