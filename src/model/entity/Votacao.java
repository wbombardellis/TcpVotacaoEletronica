package model.entity;

import view.command.Imprimivel;

import java.util.List;
import java.util.Date;

public class Votacao implements Imprimivel {

	private int id;

	private String titulo;

	private AtaVotacao ataVotacao;

	private Date dataInicio;

	private Date dataFim;

	private Date date;

	private Documentacao documentacao;

	private Estado estadoExplicito;

	private List<Voto> votos;

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

	public Votacao(int id, String titulo, Date dataInicio, Date dataFim, Estado estado, Documentacao documentacao, List<Voto> votos) {

	}

	public Votacao(Votacao votacaoBase, Estado estado) {

	}

	public Votacao(Votacao votacaoBase, Date dataInicio, Date dataFim) {

	}
	
	public Votacao(Votacao votacaoBase, List<Voto> votos) {

	}

	@Override
	public String getDescricaoTela() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCodigoTela() {
		// TODO Auto-generated method stub
		return null;
	}

}
