package model.entity;

import java.util.HashMap;
import java.util.Map;

import view.command.SaidaHelper;
import view.command.TextManager;

public class ProgressaoFuncional extends Documentacao {

	private static final Integer MEMORIAL_DESCRITIVO_ID=0;
	private static final Integer PLANILHA_PONTUACAO_ID=1;
	private static final Integer COMPROVANTE_ID=2;
	
	private final String memorialDescritivo;

	private final String planilhaPontuacao;

	private final String comprovantes;

	public static Map<Integer,String> staticgetDescricaoDocumentosObrigatorios() {
		Map<Integer, String> docs = new HashMap<>();
		TextManager txtManager = new TextManager(SaidaHelper.nomeRecursos);
		
		docs.put(MEMORIAL_DESCRITIVO_ID, txtManager.getText("progressao.funcional.memorial.descritivo"));
		docs.put(PLANILHA_PONTUACAO_ID, txtManager.getText("progressao.funcional.planilha.pontuacao"));
		docs.put(COMPROVANTE_ID, txtManager.getText("progressao.funcional.comprovantes"));
		
		return docs;
	}

	public static Map<Integer,String> staticgetDescricaoDocumentosNaoObrigatorios() {
		return new HashMap<Integer, String>();
	}
	
	@Override
	public Map<Integer, String> getDescricaoDocumentosObrigatorios() {
		return ProgressaoFuncional.staticgetDescricaoDocumentosObrigatorios();
	}

	@Override
	public Map<Integer, String> getDescricaoDocumentosNaoObrigatorios() {
		return ProgressaoFuncional.staticgetDescricaoDocumentosNaoObrigatorios();
	}

	public ProgressaoFuncional(Map<Integer,String> documentosObrigatoriosCaminhos, Map<Integer,String> documentosNaoObrigatoriosCaminhos) {
		super(TipoDocumentacao.ProgressaoFuncional);
		
		if (documentosObrigatoriosCaminhos == null || documentosNaoObrigatoriosCaminhos == null) {
			throw new IllegalArgumentException();
		}
		
		String memorialDescritivo = documentosObrigatoriosCaminhos.get(MEMORIAL_DESCRITIVO_ID);
		this.memorialDescritivo = memorialDescritivo == null ? "" : memorialDescritivo;
		
		String planilhaPontuacao = documentosObrigatoriosCaminhos.get(PLANILHA_PONTUACAO_ID);
		this.planilhaPontuacao = planilhaPontuacao == null ? "" : planilhaPontuacao;
		
		String comprovantes = documentosObrigatoriosCaminhos.get(COMPROVANTE_ID);
		this.comprovantes = comprovantes == null ? "" : comprovantes;
	}

	@Override
	public Map<Integer, String> getDocumentosObrigatorios() {
		Map<Integer, String> docs = new HashMap<>();
		
		docs.put(MEMORIAL_DESCRITIVO_ID, this.memorialDescritivo);
		docs.put(PLANILHA_PONTUACAO_ID, this.planilhaPontuacao);
		docs.put(COMPROVANTE_ID, this.comprovantes);
		
		return docs;
	}

	@Override
	public Map<Integer, String> getDocumentosNaoObrigatorios() {
		return new HashMap<Integer, String>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((comprovantes == null) ? 0 : comprovantes.hashCode());
		result = prime
				* result
				+ ((memorialDescritivo == null) ? 0 : memorialDescritivo
						.hashCode());
		result = prime
				* result
				+ ((planilhaPontuacao == null) ? 0 : planilhaPontuacao
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProgressaoFuncional other = (ProgressaoFuncional) obj;
		if (comprovantes == null) {
			if (other.comprovantes != null)
				return false;
		} else if (!comprovantes.equals(other.comprovantes))
			return false;
		if (memorialDescritivo == null) {
			if (other.memorialDescritivo != null)
				return false;
		} else if (!memorialDescritivo.equals(other.memorialDescritivo))
			return false;
		if (planilhaPontuacao == null) {
			if (other.planilhaPontuacao != null)
				return false;
		} else if (!planilhaPontuacao.equals(other.planilhaPontuacao))
			return false;
		return true;
	}

}
