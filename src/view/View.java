package view;

import java.util.List;

import view.command.Command;
import view.command.LoginCommand;
import view.command.LogoutCommand;
import view.command.MenuHelper;
import view.command.Sessao;

public class View
{
	protected List<Command> commandsPossiveis;
	
	public View()
	{
		Sessao sessao = Sessao.getInstance();
		this.commandsPossiveis.add(new LoginCommand(sessao));
		this.commandsPossiveis.add(new LogoutCommand(sessao));
	}

	public void imprimeMenu()
	{
		MenuHelper.imprimeOpcoes(commandsPossiveis);
	}
}
