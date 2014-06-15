package view;

import java.util.ArrayList;
import java.util.List;

import view.command.Command;
import view.command.LoginCommand;
import view.command.SairCommand;
import view.command.Sessao;

public class InicioView extends View
{
	public InicioView()
	{
		this.commandsPossiveis = new ArrayList<Command>();
		
		Sessao sessao = Sessao.getInstance();
		this.commandsPossiveis.add(new LoginCommand(sessao));
		this.commandsPossiveis.add(new SairCommand(sessao));
	}

	@Override
	public List<Command> getCommandsPossiveis()
	{
		return this.commandsPossiveis;
	}
}
