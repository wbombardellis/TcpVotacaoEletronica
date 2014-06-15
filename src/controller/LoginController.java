package controller;

import view.command.Sessao;
import model.dao.MembroDao;
import model.entity.Membro;

public class LoginController
{
	/*
	 * Essa classe tem por objetivo armazenar um nome de usuário e uma senha, de forma a verificar junto aos
	 * dados armazenados pelo sistema se tal conjunto é válido.
	 */
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
	
	/*
	 * Método responsável pela verificação da validade das credenciais armazenadas no objeto da classe e pela substituição
	 * do usuário ativo no sistema.
	 */
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
