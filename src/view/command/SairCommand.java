package view.command;

import java.io.IOException;

public class SairCommand extends Command
{
	public SairCommand(Sessao sessao)
	{
		super(sessao);
	}

	@Override
	public void execute() throws IOException
	{
		SaidaHelper.imprimeLinhaFromResources("sair.pedir.confirmacao");
		Boolean saidaConfirmada = MenuHelper.leConfirmacao();
		
		Sessao sessao = Sessao.getInstance();
		// Faz logout da sessão atual e encerra o programa
		if (saidaConfirmada)
		{
			sessao.setMembro(null);
			
			System.exit(0);
		}
		else
		{
			sessao.getView().imprimeMenu();
		}
	}

	@Override
	public String getCodigoTela()
	{
		return "S";
	}

	@Override
	public String getDescricaoTela()
	{
		return "Sair";
	}

}
