package model.entity;

import view.command.Imprimivel;

public enum TipoDocumentacao implements Imprimivel {

	AfastamentoPais("A", "Afastamento do País"),
	ProgressaoFuncional("P", "Progressão Funcional"),
	EstagioProbatorio("E", "Estágio Probatório");

	private String codigoTela;
	private String descricaoTela;
	TipoDocumentacao(String codigoTela, String descricaoTela) {
		this.codigoTela = codigoTela;
		this.descricaoTela = descricaoTela;
	}
	
	@Override
	public String getCodigoTela() {
		return this.codigoTela;
	}

	@Override
	public String getDescricaoTela() {
		return this.descricaoTela;
	}
	
	

}
