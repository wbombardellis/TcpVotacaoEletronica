package view.command;

import java.io.*;
import controller.LoginController;

public class LoginCommand extends Command {

	public LoginCommand(Sessao sessao) {
		super(sessao);
	}

	public boolean login(String username, String password) 
	{
		return false;
	}

	/*
	 * O processo de login é feito da seguinte forma: após a validação das credenciais, o atributo "viewAtual", presente na
	 * classe view.command.Sessao é atualizado para a view correspondente ao usuário que acabou de se logar no sistema.
	 * Assim, da próxima vez que o menu for impresso, será possível visualizar as opções disponíveis para esse usuário.
	 * Ainda, a classe view.command.Sessao também guarda a informação do membro que está logado (há um atributo para isso).
	 */
	@Override
	public void execute() throws IOException
	{		
		SaidaHelper.imprimeLinhaFromResources("login.pedir.username");
		String username = MenuHelper.leString();
			
		SaidaHelper.imprimeLinhaFromResources("login.pedir.senha");
		String password = MenuHelper.leString();
		
		LoginController loginController = new LoginController(username, password);
		
		if (loginController.autenticar() == true)
		{
			SaidaHelper.imprimeLinhaFromResources("login.sucesso");
		}
		else
		{
			SaidaHelper.imprimeLinhaFromResources("login.erro");
		}
		
		// Imprime o menu da view atual (mesmo que o login não tenha sido feito com sucesso)
		Sessao.getInstance().getView().imprimeMenu();
	}

	@Override
	public String getCodigoTela() 
	{
		return "L";
	}

	@Override
	public String getDescricaoTela() 
	{
		return "Fazer login";
	}
}
