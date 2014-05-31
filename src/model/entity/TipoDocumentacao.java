package model.entity;

import java.util.ArrayList;
import java.util.List;

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
	
	public static List<TipoDocumentacao> getListaTodosPossiveis() {
		List<TipoDocumentacao> lst = new ArrayList<>();
		
		lst.add(TipoDocumentacao.AfastamentoPais);
		lst.add(TipoDocumentacao.ProgressaoFuncional);
		lst.add(TipoDocumentacao.EstagioProbatorio);
		
		return lst;
	}
	
	public String toString() {
		return this.descricaoTela;
	}

	@Override
	public void imprimeOpcaoTela() {
		// TODO Auto-generated method stub
		
	}

}
