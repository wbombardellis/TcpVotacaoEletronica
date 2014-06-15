package model.entity;

import java.util.Date;

public class ViceChefe extends Membro {

	private static ViceChefe viceChefe;

	public ViceChefe(String nome, String username, String password)
	{
		super(nome, username, password);
	}
	
	public ViceChefe (String nome, String username, String password, Date dataInicio, Date dataFinal)
	{
		super(nome, username, password, dataInicio, dataFinal);
	}

	public ViceChefe getInstance()
	{
		return viceChefe;
	}
	
	public static ViceChefe substituirViceChefe(String nome, String username, String password)
	{
		if (viceChefe == null)
		{
			viceChefe = new ViceChefe(nome, username, password);
		}
		else
		{
			viceChefe.nome = nome;
			viceChefe.username = username;
			viceChefe.password = password;
			viceChefe.dataInicioMandato = null;
			viceChefe.dataFinalMandato = null;
			viceChefe.voto = null;
		}
		
		return viceChefe;
	}
	
	
	public static ViceChefe substituirViceChefe(String nome, String username, String password, Date dataInicio, java.sql.Date dataFinal)
	{
		if (viceChefe == null)
		{
			viceChefe = new ViceChefe(nome, username, password, dataInicio, dataFinal);
		}
		else
		{
			viceChefe.nome = nome;
			viceChefe.username = username;
			viceChefe.password = password;
			viceChefe.dataInicioMandato = (Date) dataInicio.clone();
			viceChefe.dataFinalMandato = (Date) dataFinal.clone();
			viceChefe.voto = null;
		}
		
		return viceChefe;
	}

}
