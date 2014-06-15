package controller;

import view.command.Sessao;
import model.dao.MembroDao;
import model.entity.Membro;

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

	private boolean credenciaisValidas(String username, String password)
	{
		if (username.equals(this.username) && password.equals(this.password))
		{
			return true;
		}
		return false;
	}
	
	public boolean autenticar()
	{
		MembroDao dao = MembroDao.getInstance();
		
		Membro membro = dao.getMembroByUsername(this.username);
		
		Sessao sessao = Sessao.getInstance();
		if (credenciaisValidas(membro.getUsername(), membro.getPassword()))
		{
			sessao.setMembro(membro);
			return true;
		}
		else
		{
			sessao.setMembro(null);
			return false;
		}
	}
}
