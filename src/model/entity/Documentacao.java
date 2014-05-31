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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((tipoDocumentacao == null) ? 0 : tipoDocumentacao.hashCode());
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
		Documentacao other = (Documentacao) obj;
		if (tipoDocumentacao != other.tipoDocumentacao)
			return false;
		return true;
	}

}
