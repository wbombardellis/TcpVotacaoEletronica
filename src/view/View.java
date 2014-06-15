package view;

import java.io.IOException;
import java.util.List;

import view.command.Command;
import view.command.MenuHelper;

public abstract class View
{
	protected List<Command> commandsPossiveis;
	
	public abstract List<Command> getCommandsPossiveis();
	private static final Boolean applicationRunning = true;

	public void imprimeMenu()
	{
		do
		{
			Command opcao = null;
			try
			{
				// Imprime o menu e, caso a opção escolhida pelo usuário seja válida, executa a mesma.
				opcao = MenuHelper.leOpcaoMenu(commandsPossiveis);
				if (opcao != null)
				{
					opcao.execute();
				}
			}
			catch (IOException e)
			{
				System.out.println(e.getMessage());
			}
		}
		while (applicationRunning);
	}
}
