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
		
		// Imprime o menu da view atual (mesmo que o logout não tenha sido feito com sucesso)
		Sessao.getInstance().getView().imprimeMenu();
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
