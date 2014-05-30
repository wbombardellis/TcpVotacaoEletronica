package view.command;

public abstract class Command implements Imprimivel {

	protected Sessao sessao;

	public void Command(Sessao sessao) {

	}

	public abstract void execute();


	/**
	 * @see view.command.Imprimivel#getId()
	 */
	public int getId() {
		return 0;
	}


	/**
	 * @see view.command.Imprimivel#getDescricaoTela()
	 */
	public String getDescricaoTela() {
		return null;
	}

}
