package view;

import java.io.IOException;
import java.util.List;

import view.command.Command;
import view.command.MenuHelper;

public abstract class View
{
	/*
	 * Classe resposável por fornecer os menus e opções de navegação. As permissões de comandos também são implementadas
	 * através da View. Cada tipo de usuário (Chefe/Vice Chefe, Docente/Discente ou Secretário) possui uma View específica
	 * (subclasse da classe View) que apresenta apenas os comandos permitidos para esse usuário. Esse controle é feito
	 * através do atributo "commandsPossiveis"/
	 */
	protected List<Command> commandsPossiveis;
	
	public abstract List<Command> getCommandsPossiveis();
	private static final Boolean applicationRunning = true;

	/*
	 * O método abaixo imprime no console as opções disponíveis para a view que o chamou, e espera uma entrada do teclado como
	 * um seletor de opção. Assim que uma opção válida é selecionada, o comando é executado.
	 * Após a execução do comando, o loop se repete.
	 */
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
