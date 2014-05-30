package model.entity;

import view.command.Imprimivel;
import java.util.List;
import java.util.Date;

public class Votacao implements Imprimivel {

	private int id;

	private String titulo;

	private AtaVotacao ataVotacao;

	private List list;

	private List documentosOpicionais;

	private List list;

	private Date dataInicio;

	private Date dataFim;

	private Date date;

	private Documentacao documentacao;

	private Estado estadoExplicito;

	private List votos;

	public int getId() {
		return 0;
	}

	public String getTitulo() {
		return null;
	}

	public List<Voto> getVotos() {
		return null;
	}

	public Documentacao getDocumentacao() {
		return null;
	}

	public Date getDataInicio() {
		return null;
	}

	public Date getDataFim() {
		return null;
	}

	public Estado getEstado() {
		return null;
	}

	public boolean testaEstado(Estado estado) {
		return false;
	}

	public void Votacao(int id, String titulo, Date dataInicio, Date dataFim, Estado estado, Documentacao documentacao, List_Votos_ votos) {

	}

	public void Votacao(Votacao votacaoBase, Estado estado) {

	}

	public void Votacao(Votacao votacaoBase, Date dataInicio, Date dataFim) {

	}


	/**
	 * @see view.command.Imprimivel#getDescricaoTela()
	 */
	public String getDescricaoTela() {
		return null;
	}

}
