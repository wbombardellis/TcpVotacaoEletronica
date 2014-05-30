package model.entity;

import java.util.Map;

public class AfastamentoPais extends Documentacao {

	private String cartaConvite;

	private String cartaLinguaEstrangeira;

	private String PassagemAerea;

	public static Map<int,String> getDescricaoDocumentosObrigatorios() {
		return null;
	}

	public static Map<int,String> getDescricaoDocumentosNaoObrigatorios() {
		return null;
	}

	public void AfastamentoPais(Map<int,String> documentosObrigatoriosCaminhos, Map<int,String> documentosNaoObrigatoriosCaminhos) {

	}

}
