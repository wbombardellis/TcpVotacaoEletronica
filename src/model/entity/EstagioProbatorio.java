package model.entity;

import java.util.HashMap;
import java.util.Map;

import model.entity.TipoDocumentacao;

public class EstagioProbatorio extends Documentacao {

	private final String relatorioProfessor;

	private final String relatorioProfessorTutor;

	public static Map<Integer,String> getDescricaoDocumentosObrigatorios() {
		Map<Integer, String> docs = new HashMap<>();
		
		docs.put(0, "Relatório do Professor");
		docs.put(1, "Relatório do Professor Tutor");
		
		return docs;
	}

	public static Map<Integer,String> getDescricaoDocumentosNaoObrigatorios() {
		return new HashMap<Integer, String>();
	}

	public EstagioProbatorio(Map<Integer,String> documentosObrigatoriosCaminhos, Map<Integer,String> documentosNaoObrigatoriosCaminhos) {
		super(TipoDocumentacao.EstagioProbatorio);
		
		if (documentosObrigatoriosCaminhos == null || documentosNaoObrigatoriosCaminhos == null) {
			throw new IllegalArgumentException();
		}
		
		this.relatorioProfessor = documentosObrigatoriosCaminhos.get(0);
		this.relatorioProfessorTutor = documentosObrigatoriosCaminhos.get(1);
	}

	@Override
	public Map<Integer, String> getDocumentosObrigatorios() {
		Map<Integer, String> docs = new HashMap<>();
		
		docs.put(0, this.relatorioProfessor);
		docs.put(1, this.relatorioProfessorTutor);
		
		return docs;
	}

	@Override
	public Map<Integer, String> getDocumentosNaoObrigatorios() {
		return new HashMap<Integer, String>();
	}

}
