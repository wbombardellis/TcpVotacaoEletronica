package model.entity;

import java.util.Date;

public class Voto implements Identificavel{

	private int id;

	private String justificativa;

	private Date data;

	private TipoVoto tipoVoto;

	private Membro autor;

	public Voto(int id, TipoVoto tipo, Membro autor, Date data, String justificativa) {
		this.id = id;
		this.tipoVoto = tipo; //TipoVoto é imutável
		this.autor = autor; //Supõe que autor é imutável
		this.data = (Date)data.clone();
		this.justificativa = justificativa;
	}

	public int getId() {
		return id;
	}

	public TipoVoto getTipo() {
		return tipoVoto;
	}

	public Membro getAutor() {
		return autor;
	}

	public Date getData() {
		return (Date)data.clone();
	}

	public String getJustificativa() {
		return justificativa;
	}

}
