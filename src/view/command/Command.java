package view.command;

public abstract class Command implements Imprimivel {

	protected Sessao sessao;

	public Command(Sessao sessao) {
		this.sessao = sessao; 
	}

	public abstract void execute();


	/**
	 * @see view.command.Imprimivel#getCodigoTela()
	 */
	public abstract String getCodigoTela();


	/**
	 * @see view.command.Imprimivel#getDescricaoTela()
	 */
	public abstract String getDescricaoTela();

}
