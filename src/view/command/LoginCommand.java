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

	@Override
	public void execute() throws IOException
	{		
		SaidaHelper.imprimeLinhaFromResources("login.pedir.username");
		String username = MenuHelper.leString();
			
		SaidaHelper.imprimeLinhaFromResources("loign.pedir.senha");
		String password = MenuHelper.leString();
		
		LoginController loginController = new LoginController(username, password);
		
		loginController.autenticar();
		
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
