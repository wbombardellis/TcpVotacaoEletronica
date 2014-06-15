package view;

import java.util.ArrayList;
import java.util.List;

import view.command.Command;
import view.command.ListarVotacaoCommand;
import view.command.Sessao;
import view.command.VisualizarVotacaoCommand;

public class DocenteEDiscenteView extends View
{
	public DocenteEDiscenteView()
	{
		this.commandsPossiveis = new ArrayList<Command>();

		Sessao sessao = Sessao.getInstance();
		this.commandsPossiveis.add(new ListarVotacaoCommand(sessao));
		this.commandsPossiveis.add(new VisualizarVotacaoCommand(sessao));
		// this.commandsPossiveis.add(new ...(sessao)); Alterar Voto Command? Como é implementado?
	}
	
	@Override
	public List<Command> getCommandsPossiveis()
	{
		return this.commandsPossiveis;
	}
}
