package model.entity;

import java.util.Date;

import model.dao.MembroDao;

public class Membro implements Identificavel
{
	protected int id;

	protected String nome;
	
	protected String username;
	
	protected String password;
	
	protected Date dataInicioMandato;
	
	protected Date dataFinalMandato;
	
	protected Voto voto;

	public Membro(String nome, String username, String password)
	{
		MembroDao membroDao = MembroDao.getInstance();
		this.id = membroDao.getLastInsertedId() + 1;
		this.nome = nome;
		this.username = username;
		this.password = password;
		this.dataInicioMandato = null;
		this.dataFinalMandato = null;
	}
	
	public Membro(String nome, String username, String password, Date inicioMandato, Date finalMandato)
	{
		MembroDao membroDao = MembroDao.getInstance();
		this.id = membroDao.getLastInsertedId() + 1;
		this.nome = nome;
		this.username = username;
		this.password = password;
		this.dataInicioMandato = (Date) inicioMandato.clone();
		this.dataFinalMandato = (Date) finalMandato.clone();
	}
	
	public int getId()
	{
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public Date getDataInicioMandato() {
		return this.dataInicioMandato;
	}

	public Date getDataFinalMandato() {
		return this.dataFinalMandato;
	}
	
	public Membro clone()
	{
		Membro clonado = new Membro (this.nome, this.username, this.password);
		if (this.dataInicioMandato != null) {
			clonado.dataInicioMandato = (Date) this.dataInicioMandato.clone();
		}
		else {
			clonado.dataInicioMandato = null;
		}
		if (this.dataFinalMandato != null) {
			clonado.dataFinalMandato = (Date) this.dataFinalMandato.clone();
		} 
		else {
			clonado.dataFinalMandato = null;
		}
		if (this.voto != null) {
			clonado.voto = this.voto;
		}
		else {
			clonado.voto = null;
		}
		return clonado;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Membro other = (Membro) obj;
		if (this.id != other.id)
			return false;
		return true;
	}

}
