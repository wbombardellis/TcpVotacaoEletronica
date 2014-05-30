package model.entity;

import java.util.Map;

public class AfastamentoPais extends Documentacao {

	private String cartaConvite;

	private String cartaLinguaEstrangeira;

	private String PassagemAerea;

	public static Map<Integer,String> getDescricaoDocumentosObrigatorios() {
		return null;
	}

	public static Map<Integer,String> getDescricaoDocumentosNaoObrigatorios() {
		return null;
	}

	public AfastamentoPais(Map<Integer,String> documentosObrigatoriosCaminhos, Map<Integer,String> documentosNaoObrigatoriosCaminhos) {

	}

	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, String> getDocumentosObrigatorios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, String> getDocumentosNaoObrigatorios() {
		// TODO Auto-generated method stub
		return null;
	}

}
