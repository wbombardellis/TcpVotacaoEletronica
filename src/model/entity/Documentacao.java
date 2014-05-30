package model.entity;

import java.util.Map;

public abstract class Documentacao {

	private Votacao votacao;

	public abstract Map<int,String> getDocumentosObrigatorios();

	public abstract Map<int,String> getDocumentosNaoObrigatorios();

	public abstract String getDescricao();

}
