package model.entity;

import view.command.Imprimivel;
import view.command.SaidaHelper;
import view.command.TextManager;

import java.util.ArrayList;
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
		if (testaEstado(Estado.Finalizada))
			return Estado.Finalizada;
		else if (testaEstado(Estado.Aberta))
			return Estado.Aberta;
		else if (testaEstado(Estado.Liberada))
			return Estado.Liberada;
		else if (testaEstado(Estado.Autorizada))
			return Estado.Autorizada;
		else
			return Estado.Bloqueada;
	}
	
	private boolean temTodosDocumentosObrigatorios() {
		for (String documento : this.documentacao.getDocumentosObrigatorios().values()) {
			if (documento.isEmpty()) {
				return false;
			}
		}
		return true;
	}
	
	private boolean estaLiberada() {
		return this.estadoExplicito.equals(Estado.Liberada)
			|| this.temTodosDocumentosObrigatorios();
	}

	public boolean testaEstado(Estado estado) {
		switch (estado) {
		case Bloqueada:
			return ! this.estaLiberada();
		case Autorizada:
			return this.estadoExplicito.equals(Estado.Autorizada);
		case Liberada:
			return this.estaLiberada();
		case Aberta:
			return (this.estaLiberada() || this.estadoExplicito.equals(Estado.Aberta))
				&& (new Date()).after(this.dataInicio)
				&& (new Date()).before(this.dataFim);
		case Finalizada:
			return (new Date()).after(this.dataFim);
		default:
			assert(false);
			return false;
		}
	}

	public Votacao(int id, String titulo, Date dataInicio, Date dataFim, Estado estado, Documentacao documentacao, List<Voto> votos) {
		if (documentacao == null) {
			TextManager txtManager = new TextManager(SaidaHelper.nomeRecursos);
			throw new NullPointerException(txtManager.getText("mensagem.votacao.documentacao.nulo"));
		}
		this.id = id;
		this.titulo = titulo;
		this.dataInicio = (Date)dataInicio.clone();
		this.dataFim = (Date)dataFim.clone();
		this.estadoExplicito = estado;
		this.documentacao = documentacao;
		this.votos = new ArrayList<>(votos);
	}

	public Votacao(Votacao votacaoBase, Estado estado) {
		this.id = votacaoBase.getId();
		this.titulo = votacaoBase.getTitulo();
		this.dataInicio = votacaoBase.getDataInicio();
		this.dataFim = votacaoBase.getDataFim();
		this.estadoExplicito = estado;
		this.documentacao = votacaoBase.getDocumentacao();
		this.votos = new ArrayList<>(votacaoBase.getVotos());
	}

	public Votacao(Votacao votacaoBase, Date dataInicio, Date dataFim) {
		this.id = votacaoBase.getId();
		this.titulo = votacaoBase.getTitulo();
		this.dataInicio = (Date)dataInicio.clone();
		this.dataFim = (Date)dataFim.clone();
		this.estadoExplicito = votacaoBase.getEstado();
		this.documentacao = votacaoBase.getDocumentacao();
		this.votos = new ArrayList<>(votacaoBase.getVotos());
	}
	
	public Votacao(Votacao votacaoBase, List<Voto> votos) {
		this.id = votacaoBase.getId();
		this.titulo = votacaoBase.getTitulo();
		this.dataInicio = votacaoBase.getDataInicio();
		this.dataFim = votacaoBase.getDataFim();
		this.estadoExplicito = votacaoBase.getEstado();
		this.documentacao = votacaoBase.getDocumentacao();
		this.votos = new ArrayList<>(votos);
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result
				+ ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result
				+ ((documentacao == null) ? 0 : documentacao.hashCode());
		result = prime * result
				+ ((estadoExplicito == null) ? 0 : estadoExplicito.hashCode());
		result = prime * result + id;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + ((votos == null) ? 0 : votos.hashCode());
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
		Votacao other = (Votacao) obj;
		if (dataFim == null) {
			if (other.dataFim != null)
				return false;
		} else if (!dataFim.equals(other.dataFim))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (documentacao == null) {
			if (other.documentacao != null)
				return false;
		} else if (!documentacao.equals(other.documentacao))
			return false;
		if (estadoExplicito != other.estadoExplicito)
			return false;
		if (id != other.id)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (votos == null) {
			if (other.votos != null)
				return false;
		} else if (!votos.equals(other.votos))
			return false;
		return true;
	}

}
