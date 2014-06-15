package view.command;

public class LogoutCommand extends Command {

	public LogoutCommand(Sessao sessao) {
		super(sessao);
	}

	public void logout(Sessao sessao) {
		

	}

	/*
	 * Caso a opção de logout seja confirmada pelo usuário, é feita uma alteração na classe view.command.Sessao, de forma
	 * que o atributo "membroLogado" seja definido como null e o atributo "viewAtual" receba um objeto do tipo "InicioView"
	 */
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
