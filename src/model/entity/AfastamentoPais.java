package model.entity;

import java.util.HashMap;
import java.util.Map;

import view.command.SaidaHelper;
import view.command.TextManager;

public class AfastamentoPais extends Documentacao {
	
	private static final Integer CARTA_CONVITE_ID=0;
	private static final Integer CARTA_LINGUA_ESTRANGEIRA_ID=1;
	private static final Integer PASSAGEM_AEREA_ID=0;

	private final String cartaConvite;

	private final String cartaLinguaEstrangeira;

	private final String passagemAerea;

	public static Map<Integer,String> staticgetDescricaoDocumentosObrigatorios() {
		Map<Integer, String> docs = new HashMap<>();
		TextManager txtManager = new TextManager(SaidaHelper.nomeRecursos);
		
		docs.put(CARTA_CONVITE_ID, txtManager.getText("afastamento.pais.cartaConvite"));
		docs.put(CARTA_LINGUA_ESTRANGEIRA_ID, txtManager.getText("afastamento.pais.cartaLinguaEstrangeira"));
		
		return docs;
	}

	public static Map<Integer,String> staticgetDescricaoDocumentosNaoObrigatorios() {
		Map<Integer, String> docs = new HashMap<>();
		TextManager txtManager = new TextManager(SaidaHelper.nomeRecursos);
		
		docs.put(PASSAGEM_AEREA_ID, txtManager.getText("afastamento.pais.passagemAerea"));
		
		return docs;
	}

	@Override
	public Map<Integer, String> getDescricaoDocumentosObrigatorios() {
		return AfastamentoPais.staticgetDescricaoDocumentosObrigatorios();
	}

	@Override
	public Map<Integer, String> getDescricaoDocumentosNaoObrigatorios() {
		return AfastamentoPais.staticgetDescricaoDocumentosNaoObrigatorios();
	}

	public AfastamentoPais(Map<Integer,String> documentosObrigatoriosCaminhos, Map<Integer,String> documentosNaoObrigatoriosCaminhos) {
		super(TipoDocumentacao.AfastamentoPais);
		
		if (documentosObrigatoriosCaminhos == null || documentosNaoObrigatoriosCaminhos == null) {
			throw new IllegalArgumentException();
		}
		
		this.cartaConvite = documentosObrigatoriosCaminhos.get(CARTA_CONVITE_ID);
		this.cartaLinguaEstrangeira = documentosObrigatoriosCaminhos.get(CARTA_LINGUA_ESTRANGEIRA_ID);
		
		this.passagemAerea = documentosNaoObrigatoriosCaminhos.get(PASSAGEM_AEREA_ID);
	}

	@Override
	public Map<Integer, String> getDocumentosObrigatorios() {
		Map<Integer, String> docs = new HashMap<>();
		
		docs.put(CARTA_CONVITE_ID, this.cartaConvite);
		docs.put(CARTA_LINGUA_ESTRANGEIRA_ID, this.cartaLinguaEstrangeira);
		
		return docs;
	}

	@Override
	public Map<Integer, String> getDocumentosNaoObrigatorios() {
		Map<Integer, String> docs = new HashMap<>();
		
		docs.put(PASSAGEM_AEREA_ID, this.passagemAerea);
		
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
