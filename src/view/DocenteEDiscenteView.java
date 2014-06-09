package view;

import view.command.ListarVotacaoCommand;
import view.command.MenuHelper;
import view.command.Sessao;
import view.command.VisualizarVotacaoCommand;

public class DocenteEDiscenteView extends View
{
	public DocenteEDiscenteView()
	{
		Sessao sessao = Sessao.getInstance();
		this.commandsPossiveis.add(new ListarVotacaoCommand(sessao));
		this.commandsPossiveis.add(new VisualizarVotacaoCommand(sessao));
		// this.commandsPossiveis.add(new ...(sessao)); Alterar Voto Command? Como é implementado?
	}

	public void imprimeMenu() 
	{
		MenuHelper.imprimeOpcoes(commandsPossiveis);
	}

}
