package model.entity;

import java.util.Date;

public class Membro implements Identificavel
{
	private int id;

	private String nome;
	
	private String username;
	
	private String password;
	
	private Date dataInicioMandato;
	
	private Date dataFinalMandato;
	
	private Voto voto;

	public Membro(String nome, String username, String password) {

	}
	
	public int getId()
	{
		return this.id;
	}

	public String getNome() {
		return null;
	}

	public String getUsername() {
		return null;
	}

	public String getPassword() {
		return null;
	}

	public Date getDataInicioMandato() {
		return null;
	}

	public Date getDataFinalMandato() {
		return null;
	}

}
