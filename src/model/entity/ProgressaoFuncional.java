package model.entity;

import java.util.HashMap;
import java.util.Map;

public class ProgressaoFuncional extends Documentacao {

	private final String memorialDescritivo;

	private final String planilhaPontuacao;

	private final String comprovantes;

	public static Map<Integer,String> getDescricaoDocumentosObrigatorios() {
		Map<Integer, String> docs = new HashMap<>();
		
		docs.put(0, "Memórial Descritivo");
		docs.put(1, "Planilha de Pontuação");
		docs.put(2, "Comprovantes");
		
		return docs;
	}

	public static Map<Integer,String> getDescricaoDocumentosNaoObrigatorios() {
		return new HashMap<Integer, String>();
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

}
