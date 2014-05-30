package model.entity;

import java.util.Map;

public abstract class Documentacao {

	private Votacao votacao;

	public abstract Map<Integer,String> getDocumentosObrigatorios();

	public abstract Map<Integer,String> getDocumentosNaoObrigatorios();

	public abstract String getDescricao();

}
