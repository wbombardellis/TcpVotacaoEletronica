package model.entity;

import view.command.Imprimivel;

import java.util.Collections;
import java.util.List;
import java.util.Date;

public class Votacao implements Imprimivel, Identificavel {

	private final int id;

	private final String titulo;

	private final Date dataInicio;

	private final Date dataFim;

	private final Documentacao documentacao;

	private final Estado estadoExplicito;

	private final List<Voto> votos;

	public int getId() {
		return this.id;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public List<Voto> getVotos() {
		return Collections.unmodifiableList(this.votos);
	}

	public Documentacao getDocumentacao() {
		return this.documentacao;
	}

	public Date getDataInicio() {
		return (Date)this.dataInicio.clone();
	}

	public Date getDataFim() {
		return (Date)this.dataFim.clone();
	}

	public Estado getEstado() {
		return this.getEstado();
	}

	public boolean testaEstado(Estado estado) {
		return false;
	}

	public Votacao(int id, String titulo, Date dataInicio, Date dataFim, Estado estado, Documentacao documentacao, List<Voto> votos) {
		this.id = id;
		this.titulo = titulo;
		this.dataInicio = (Date)dataInicio.clone();
		this.dataFim = (Date)dataFim.clone();
		this.estadoExplicito = estado;
		this.documentacao = documentacao;
		this.votos = votos;
	}

	public Votacao(Votacao votacaoBase, Estado estado) {
		this.id = votacaoBase.getId();
		this.titulo = votacaoBase.getTitulo();
		this.dataInicio = votacaoBase.getDataInicio();
		this.dataFim = votacaoBase.getDataFim();
		this.estadoExplicito = estado;
		this.documentacao = votacaoBase.getDocumentacao();
		this.votos = votacaoBase.getVotos();
	}

	public Votacao(Votacao votacaoBase, Date dataInicio, Date dataFim) {
		this.id = votacaoBase.getId();
		this.titulo = votacaoBase.getTitulo();
		this.dataInicio = (Date)dataInicio.clone();
		this.dataFim = (Date)dataFim.clone();
		this.estadoExplicito = votacaoBase.getEstado();
		this.documentacao = votacaoBase.getDocumentacao();
		this.votos = votacaoBase.getVotos();
	}
	
	public Votacao(Votacao votacaoBase, List<Voto> votos) {
		this.id = votacaoBase.getId();
		this.titulo = votacaoBase.getTitulo();
		this.dataInicio = votacaoBase.getDataInicio();
		this.dataFim = votacaoBase.getDataFim();
		this.estadoExplicito = votacaoBase.getEstado();
		this.documentacao = votacaoBase.getDocumentacao();
		this.votos = votos;
	}

	@Override
	public String getDescricaoTela() {
		return this.getTitulo();
	}

	@Override
	public String getCodigoTela() {
		return String.valueOf(this.id);
	}

	@Override
	public void imprimeOpcaoTela() {
		// TODO Auto-generated method stub
		
	}

}
