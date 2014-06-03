package controller;

public class LoginController
{
	private String username;
	private String password;

	public LoginController(String username, String password) 
	{
		this.username = username;
		this.password = password;
	}
	
	public void setAttributes(String username, String password)
	{
		this.username = username;
		this.password = password;
	}

	private boolean credenciaisValidas()
	{
		return false;
	}
	
	public void autenticar()
	{
		// if credenciaisValidas
			// autoriza a sessão
	}
}
