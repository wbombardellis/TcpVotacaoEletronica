package view;

import view.command.MenuHelper;;

public class ChefiaEViceView extends View 
{

	public void imprimeMenu() 
	{
		MenuHelper.imprimeOpcoes(commandsPossiveis);
	}

}
