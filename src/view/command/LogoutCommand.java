package view.command;

public class LogoutCommand extends Command {

	public LogoutCommand(Sessao sessao) {
		super(sessao);
	}

	public void logout(Sessao sessao) {
		

	}

	@Override
	public void execute()
	{
		SaidaHelper.imprimeLinhaFromResources("logout.pedir.confirmacao");
		Boolean logoutConfirmado = MenuHelper.leConfirmacao();
		
		if (logoutConfirmado)
		{
			Sessao sessao = Sessao.getInstance();
			sessao.setMembro(null); // Termina a sessão atual.
		}
		
		// Falta imprimir o menu da view (mesmo que o logout não tenha ocorrido).
	}

	@Override
	public String getCodigoTela() 
	{
		return "E";
	}

	@Override
	public String getDescricaoTela() 
	{
		return "Fazer logout";
	}

}
