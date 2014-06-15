package view;

import java.util.ArrayList;
import java.util.List;

import view.command.AbrirVotacaoCommand;
import view.command.Command;
import view.command.CriarVotacaoCommand;
import view.command.ExcluirVotacaoCommand;
import view.command.FecharVotacaoCommand;
import view.command.GerarAtaCommand;
import view.command.LerAtaCommand;
import view.command.LiberarVotacaoCommand;
import view.command.ListarVotacaoCommand;
import view.command.LogoutCommand;
import view.command.SairCommand;
import view.command.Sessao;
import view.command.VisualizarVotacaoCommand;

public class SecretariaView extends View
{
	/*
	 * Para informações sobre o funcionamento dessa classe, consultar a classe view.View.
	 */
	public SecretariaView()
	{
		this.commandsPossiveis = new ArrayList<Command>();

		Sessao sessao = Sessao.getInstance();
		this.commandsPossiveis.add(new CriarVotacaoCommand(sessao));
		this.commandsPossiveis.add(new LiberarVotacaoCommand(sessao));
		this.commandsPossiveis.add(new AbrirVotacaoCommand(sessao));
		this.commandsPossiveis.add(new ListarVotacaoCommand(sessao));
		this.commandsPossiveis.add(new VisualizarVotacaoCommand(sessao));
		this.commandsPossiveis.add(new LerAtaCommand(sessao));
		this.commandsPossiveis.add(new FecharVotacaoCommand(sessao));
		this.commandsPossiveis.add(new ExcluirVotacaoCommand(sessao));
		this.commandsPossiveis.add(new GerarAtaCommand(sessao));
		this.commandsPossiveis.add(new LogoutCommand(sessao));
		this.commandsPossiveis.add(new SairCommand(sessao));
	}
	
	@Override
	public List<Command> getCommandsPossiveis()
	{
		return this.commandsPossiveis;
	}
}
