package model.entity;

import java.util.Map;

public class ProgressaoFuncional extends Documentacao {

	private String memorialDescritivo;

	private String planilhaPontuacao;

	private String comprovantes;

	public static Map<Integer,String> getDescricaoDocumentosObrigatorios() {
		return null;
	}

	public static Map<Integer,String> getDescricaoDocumentosNaoObrigatorios() {
		return null;
	}

	public ProgressaoFuncional(Map<Integer,String> documentosObrigatoriosCaminhos, Map<Integer,String> documentosNaoObrigatoriosCaminhos) {

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

	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return null;
	}

}
