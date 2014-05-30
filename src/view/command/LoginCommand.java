package view.command;

public class LoginCommand extends Command {

	public LoginCommand(Sessao sessao) {
		super(sessao);
	}

	public boolean login(String username, String password) {
		return false;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCodigoTela() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescricaoTela() {
		// TODO Auto-generated method stub
		return null;
	}

}
