package model.entity;

import java.util.HashMap;
import java.util.Map;

public class ProgressaoFuncional extends Documentacao {

	private final String memorialDescritivo;

	private final String planilhaPontuacao;

	private final String comprovantes;

	public static Map<Integer,String> staticgetDescricaoDocumentosObrigatorios() {
		Map<Integer, String> docs = new HashMap<>();
		
		docs.put(0, "Memórial Descritivo");
		docs.put(1, "Planilha de Pontuação");
		docs.put(2, "Comprovantes");
		
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
		
		this.memorialDescritivo = documentosObrigatoriosCaminhos.get(0);
		this.planilhaPontuacao = documentosObrigatoriosCaminhos.get(1);
		this.comprovantes = documentosObrigatoriosCaminhos.get(2);
	}

	@Override
	public Map<Integer, String> getDocumentosObrigatorios() {
		Map<Integer, String> docs = new HashMap<>();
		
		docs.put(0, this.memorialDescritivo);
		docs.put(1, this.planilhaPontuacao);
		docs.put(2, this.comprovantes);
		
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
