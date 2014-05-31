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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((cartaConvite == null) ? 0 : cartaConvite.hashCode());
		result = prime
				* result
				+ ((cartaLinguaEstrangeira == null) ? 0
						: cartaLinguaEstrangeira.hashCode());
		result = prime * result
				+ ((passagemAerea == null) ? 0 : passagemAerea.hashCode());
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
		AfastamentoPais other = (AfastamentoPais) obj;
		if (cartaConvite == null) {
			if (other.cartaConvite != null)
				return false;
		} else if (!cartaConvite.equals(other.cartaConvite))
			return false;
		if (cartaLinguaEstrangeira == null) {
			if (other.cartaLinguaEstrangeira != null)
				return false;
		} else if (!cartaLinguaEstrangeira.equals(other.cartaLinguaEstrangeira))
			return false;
		if (passagemAerea == null) {
			if (other.passagemAerea != null)
				return false;
		} else if (!passagemAerea.equals(other.passagemAerea))
			return false;
		return true;
	}

}
