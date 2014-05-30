package model.entity;

import java.util.Map;

public class EstagioProbatorio extends Documentacao {

	private String relatorioProfessor;

	private String relatorioProfessorTutor;

	public static Map<Integer,String> getDescricaoDocumentosObrigatorios() {
		return null;
	}

	public static Map<Integer,String> getDescricaoDocumentosNaoObrigatorios() {
		return null;
	}

	public EstagioProbatorio(Map<Integer,String> documentosObrigatoriosCaminhos, Map<Integer,String> documentosNaoObrigatoriosCaminhos) {

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
