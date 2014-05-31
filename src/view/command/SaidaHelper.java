package view.command;

import java.util.List;

public abstract class SaidaHelper {
	
	private static final String nomeRecursos = "view.resources.messages.properties";
	
	public static void imprimeLinhaFromResources(String recurso){
		TextManager txtManager = new TextManager(SaidaHelper.nomeRecursos);
	}
	
	public static void imprimirLinhas(List<String> linhas){
		for (String linha : linhas){
			System.out.println(linha);
		}
	}
}
