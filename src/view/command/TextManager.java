package view.command;

import java.util.Locale;
import java.util.ResourceBundle;

public class TextManager {
	private ResourceBundle recursos;
	
	public TextManager (String nomeRecursos, Locale locale){
		assert nomeRecursos != null;
		assert locale != null;
		setRecursos(ResourceBundle.getBundle(nomeRecursos, locale));
	}
	
	public TextManager(String nomeRecursos) {
		assert nomeRecursos != null;
		setRecursos(ResourceBundle.getBundle(nomeRecursos));
	}
	
	private void setRecursos(ResourceBundle recursos){
		assert recursos != null;
		this.recursos = recursos;
	}
	
	public String getText(String recurso){
		assert recurso != null;
		assert recursos != null;
		return recursos.getString(recurso);
	}
	
	
}
