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
	private Membro membroLogado;
	private View viewAtual;
	
	private Sessao()
	{
		this.membroLogado = null;
		this.viewAtual = null;
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
		return this.membroLogado;
	}

	public void setMembro(Membro membro) 
	{
		this.membroLogado = membro;
		// Descobre o tipo de membro para atribuir a view correspondente.
		if (this.membroLogado == null) // Se for null, descarta os dados atuais (operação de logout)
		{
			this.viewAtual = new InicioView(); // View do menu inicial
			this.membroLogado = null;
		}
		else if (this.membroLogado instanceof Chefe || this.membroLogado instanceof ViceChefe)
		{
			this.viewAtual = new ChefiaEViceView();
		}
		else if (this.membroLogado instanceof Secretario)
		{
			this.viewAtual = new SecretariaView();
		}
		else if (this.membroLogado instanceof Docente || this.membroLogado instanceof Discente)
		{
			this.viewAtual = new DocenteEDiscenteView();
		}
	}
	
	public View getView()
	{
		return this.viewAtual;
	}

}
