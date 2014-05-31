package model.entity;

import java.util.Map;

public abstract class Documentacao {
	
	protected final TipoDocumentacao tipoDocumentacao;

	public Documentacao(TipoDocumentacao tipoDocumentacao) {
		this.tipoDocumentacao = tipoDocumentacao;
	}
	
	public abstract Map<Integer,String> getDocumentosObrigatorios();

	public abstract Map<Integer,String> getDocumentosNaoObrigatorios();

	public String getDescricao() {
		return this.tipoDocumentacao.toString();
	}

}
