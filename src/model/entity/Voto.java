package model.entity;

import java.util.Date;

public class Voto {

	private int id;

	private String justificativa;

	private Date data;

	private TipoVoto tipoVoto;

	private Membro autor;

	public Voto(TipoVoto tipo, Membro autor, Date data, String justificativa) {

	}

	public int getId() {
		return 0;
	}

	public TipoVoto getTipo() {
		return null;
	}

	public Membro getAutor() {
		return null;
	}

	public Date getData() {
		return null;
	}

	public String getJustificativa() {
		return null;
	}

}
