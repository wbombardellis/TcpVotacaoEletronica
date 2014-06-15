package model.entity;

import java.util.Date;

public class Chefe extends Membro {

	private static Chefe chefe;

	public Chefe(String nome, String username, String password) {
		super(nome, username, password);
	}
	
	public Chefe (String nome, String username, String password, Date dataInicio, Date dataFinal)
	{
		super(nome, username, password, dataInicio, dataFinal);
	}

	public Chefe getInstance()
	{
		return chefe;
	}
	
	public static Chefe substituirChefe(String nome, String username, String password)
	{
		if (chefe == null)
		{
			chefe = new Chefe(nome, username, password);
		}
		else
		{
			chefe.nome = nome;
			chefe.username = username;
			chefe.password = password;
			chefe.dataInicioMandato = null;
			chefe.dataFinalMandato = null;
			chefe.voto = null;
		}
		
		return chefe;
	}
	
	public static Chefe substituirChefe (String nome, String username, String password, Date dataInicio, Date dataFinal)
	{
		if (chefe == null)
		{
			chefe = new Chefe(nome, username, password, dataInicio, dataFinal);
		}
		else
		{
			chefe.nome = nome;
			chefe.username = username;
			chefe.password = password;
			chefe.dataInicioMandato = (Date) dataInicio.clone();
			chefe.dataFinalMandato = (Date) dataFinal.clone();
			chefe.voto = null;
		}
		
		return chefe;
	}
}
