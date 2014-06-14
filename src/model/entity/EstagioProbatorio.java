package model.entity;

import java.util.HashMap;
import java.util.Map;

import view.command.SaidaHelper;
import view.command.TextManager;
import model.entity.TipoDocumentacao;

public class EstagioProbatorio extends Documentacao {

	private static final Integer RELATORIO_PROFESSOR_ID=0;
	private static final Integer RELATORIO_PROFESSOR_TUTOR_ID=1;
	
	private final String relatorioProfessor;

	private final String relatorioProfessorTutor;

	public static Map<Integer,String> staticgetDescricaoDocumentosObrigatorios() {
		Map<Integer, String> docs = new HashMap<>();
		TextManager txtManager = new TextManager(SaidaHelper.nomeRecursos);
		
		docs.put(RELATORIO_PROFESSOR_ID, txtManager.getText("estagio.probatorio.relatorio.professor"));
		docs.put(RELATORIO_PROFESSOR_TUTOR_ID, txtManager.getText("estagio.probatorio.relatorio.professor.tutor"));
		
		return docs;
	}

	public static Map<Integer,String> staticgetDescricaoDocumentosNaoObrigatorios() {
		return new HashMap<Integer, String>();
	}

	public EstagioProbatorio(Map<Integer,String> documentosObrigatoriosCaminhos, Map<Integer,String> documentosNaoObrigatoriosCaminhos) {
		super(TipoDocumentacao.EstagioProbatorio);
		
		if (documentosObrigatoriosCaminhos == null || documentosNaoObrigatoriosCaminhos == null) {
			throw new IllegalArgumentException();
		}
		
		this.relatorioProfessor = documentosObrigatoriosCaminhos.get(RELATORIO_PROFESSOR_ID);
		this.relatorioProfessorTutor = documentosObrigatoriosCaminhos.get(RELATORIO_PROFESSOR_TUTOR_ID);
	}

	@Override
	public Map<Integer, String> getDocumentosObrigatorios() {
		Map<Integer, String> docs = new HashMap<>();
		
		docs.put(RELATORIO_PROFESSOR_ID, this.relatorioProfessor);
		docs.put(RELATORIO_PROFESSOR_TUTOR_ID, this.relatorioProfessorTutor);
		
		return docs;
	}

	@Override
	public Map<Integer, String> getDocumentosNaoObrigatorios() {
		return new HashMap<Integer, String>();
	}
	
	@Override
	public Map<Integer, String> getDescricaoDocumentosObrigatorios() {
		return EstagioProbatorio.staticgetDescricaoDocumentosObrigatorios();
	}

	@Override
	public Map<Integer, String> getDescricaoDocumentosNaoObrigatorios() {
		return EstagioProbatorio.staticgetDescricaoDocumentosNaoObrigatorios();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((relatorioProfessor == null) ? 0 : relatorioProfessor
						.hashCode());
		result = prime
				* result
				+ ((relatorioProfessorTutor == null) ? 0
						: relatorioProfessorTutor.hashCode());
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
		EstagioProbatorio other = (EstagioProbatorio) obj;
		if (relatorioProfessor == null) {
			if (other.relatorioProfessor != null)
				return false;
		} else if (!relatorioProfessor.equals(other.relatorioProfessor))
			return false;
		if (relatorioProfessorTutor == null) {
			if (other.relatorioProfessorTutor != null)
				return false;
		} else if (!relatorioProfessorTutor
				.equals(other.relatorioProfessorTutor))
			return false;
		return true;
	}

}
