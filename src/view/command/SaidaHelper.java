package view.command;

import java.util.List;

public abstract class SaidaHelper {
	
	public static final String nomeRecursos = "view.resources.messages";
	
	public static void imprimeLinhaFromResources(String recurso){
		TextManager txtManager = new TextManager(nomeRecursos);
		
		System.out.println(txtManager.getText(recurso));
	}
	
	public static void imprimeLinha(String linha){
		System.out.println(linha);
	}
	
	public static void imprimeLinhas(List<String> linhas){
		for (String linha : linhas){
			System.out.println(linha);
		}
	}
}
