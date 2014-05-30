package model.entity;

import java.util.Map;

public class ProgressaoFuncional extends Documentacao {

	private String memorialDescritivo;

	private String planilhaPontuacao;

	private String comprovantes;

	public static Map<int,String> getDescricaoDocumentosObrigatorios() {
		return null;
	}

	public static Map<int,String> getDescricaoDocumentosNaoObrigatorios() {
		return null;
	}

	public void ProgressaoFuncional(Map<int,String> documentosObrigatoriosCaminhos, Map<int,String> documentosNaoObrigatoriosCaminhos) {

	}

}
