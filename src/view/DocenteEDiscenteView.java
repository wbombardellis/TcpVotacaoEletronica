package view;

public class DocenteEDiscenteView extends View {

	public void imprimeMenu() 
	{
		MenuHelper menu = new MenuHelper();

		menu.imprimeOpcoes(commandsPossiveis);
	}

}
