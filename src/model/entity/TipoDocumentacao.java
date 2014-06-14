package model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import view.command.Imprimivel;
import view.command.SaidaHelper;
import view.command.TextManager;

public enum TipoDocumentacao implements Imprimivel {

	AfastamentoPais("afastamento.pais.codigo", "afastamento.pais"),
	ProgressaoFuncional("progressao.funcional.codigo", "progressao.funcional"),
	EstagioProbatorio("estagio.probatorio.codigo", "estagio.probatorio");

	private String codigoTela;
	private String descricaoTela;
	TipoDocumentacao(String codigoTelaRecurso, String descricaoTelaRecurso) {
		TextManager txtManager = new TextManager(SaidaHelper.nomeRecursos);
		
		this.codigoTela = txtManager.getText(codigoTelaRecurso);
		this.descricaoTela = txtManager.getText(descricaoTelaRecurso);
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
	
	public Documentacao createNewInstance(Map<Integer,String> documentosObrigatoriosCaminhos, Map<Integer,String> documentosNaoObrigatoriosCaminhos) {
		switch (this) {
		case AfastamentoPais:
			return new AfastamentoPais(documentosObrigatoriosCaminhos, documentosNaoObrigatoriosCaminhos);
		case ProgressaoFuncional:
			return new ProgressaoFuncional(documentosObrigatoriosCaminhos, documentosNaoObrigatoriosCaminhos);
		case EstagioProbatorio:
			return new EstagioProbatorio(documentosObrigatoriosCaminhos, documentosNaoObrigatoriosCaminhos);
		default:
			assert(false);
			return null;
		}
	}
	
}
