package model.entity;

import java.util.Date;

public class Voto implements Identificavel{

	private int id;

	private String justificativa;

	private Date data;

	private TipoVoto tipoVoto;

	private Membro autor;

	public Voto(int id, TipoVoto tipo, Membro autor, Date data, String justificativa) {
		assert id >=0;
		assert tipo != null;
		assert autor != null;
		assert data != null;
		
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
