package model.entity;

import java.util.HashMap;
import java.util.Map;

public class AfastamentoPais extends Documentacao {

	private final String cartaConvite;

	private final String cartaLinguaEstrangeira;

	private final String passagemAerea;

	public static Map<Integer,String> getDescricaoDocumentosObrigatorios() {
		Map<Integer, String> docs = new HashMap<>();
		
		docs.put(0, "Carta Convite");
		docs.put(1, "Carta em Língua Estrangeira");
		
		return docs;
	}

	public static Map<Integer,String> getDescricaoDocumentosNaoObrigatorios() {
		Map<Integer, String> docs = new HashMap<>();
		
		docs.put(0, "Passagem Aérea");
		
		return docs;
	}

	public AfastamentoPais(Map<Integer,String> documentosObrigatoriosCaminhos, Map<Integer,String> documentosNaoObrigatoriosCaminhos) {
		super(TipoDocumentacao.AfastamentoPais);
		
		if (documentosObrigatoriosCaminhos == null || documentosNaoObrigatoriosCaminhos == null) {
			throw new IllegalArgumentException();
		}
		
		this.cartaConvite = documentosObrigatoriosCaminhos.get(0);
		this.cartaLinguaEstrangeira = documentosObrigatoriosCaminhos.get(1);
		
		this.passagemAerea = documentosNaoObrigatoriosCaminhos.get(0);
	}

	@Override
	public Map<Integer, String> getDocumentosObrigatorios() {
		Map<Integer, String> docs = new HashMap<>();
		
		docs.put(0, this.cartaConvite);
		docs.put(1, this.cartaLinguaEstrangeira);
		
		return docs;
	}

	@Override
	public Map<Integer, String> getDocumentosNaoObrigatorios() {
		Map<Integer, String> docs = new HashMap<>();
		
		docs.put(0, this.passagemAerea);
		
		return docs;
	}

}
