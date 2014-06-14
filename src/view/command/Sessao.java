package view.command;

import view.ChefiaEViceView;
import view.DocenteEDiscenteView;
import view.InicioView;
import view.SecretariaView;
import view.View;
import model.entity.Chefe;
import model.entity.Discente;
import model.entity.Docente;
import model.entity.Membro;
import model.entity.Secretario;
import model.entity.ViceChefe;

public class Sessao {

	private static Sessao instance;
	private static Membro membroLogado;
	private static View viewAtual;
	
	private Sessao()
	{
		membroLogado = null;
		viewAtual = null;
	}

	public static Sessao getInstance()
	{
		if (instance == null)
		{
			instance = new Sessao();
		}
		return instance;
	}

	public Membro getMembro()
	{
		return membroLogado;
	}

	public void setMembro(Membro membro) 
	{
		membroLogado = membro;
		// Descobre o tipo de membro para atribuir a view correspondente.
		if (membroLogado == null) // Se for null, descarta os dados atuais (operação de logout)
		{
			viewAtual = new InicioView(); // View do menu inicial
			membroLogado = null;
		}
		else if (membroLogado instanceof Chefe || membroLogado instanceof ViceChefe)
		{
			viewAtual = new ChefiaEViceView();
		}
		else if (membroLogado instanceof Secretario)
		{
			viewAtual = new SecretariaView();
		}
		else if (membroLogado instanceof Docente || membroLogado instanceof Discente)
		{
			viewAtual = new DocenteEDiscenteView();
		}
	}
	
	public View getView()
	{
		return viewAtual;
	}

}
