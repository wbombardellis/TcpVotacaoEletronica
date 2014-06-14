package view.command;

import java.io.IOException;

public abstract class Command implements Imprimivel {

	protected Sessao sessao;
	
	protected TextManager txtManager;

	public Command(Sessao sessao) {
		this.sessao = sessao;
		this.txtManager = new TextManager(SaidaHelper.nomeRecursos);
	}

	public abstract void execute() throws IOException;


	/**
	 * @see view.command.Imprimivel#getCodigoTela()
	 */
	public abstract String getCodigoTela();


	/**
	 * @see view.command.Imprimivel#getDescricaoTela()
	 */
	public abstract String getDescricaoTela();

}
