package view;

public class SecretariaView extends View {

	public void imprimeMenu() 
	{
		MenuHelper menu = new MenuHelper();

		menu.imprimeOpcoes(commandsPossiveis);
	}

}
