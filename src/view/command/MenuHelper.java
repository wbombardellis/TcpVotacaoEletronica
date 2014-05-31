package view.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public abstract class MenuHelper {

	public static <T extends Imprimivel> T leOpcaoMenu(List<T> opcoes) throws IOException {
		//Imprime opções
		for (T opcao : opcoes){
			System.out.println(opcao.getCodigoTela() + " - " + opcao.getDescricaoTela());
		}
		System.out.println("C" + " - " + "Cancelar");
		
		//Le opção
		System.out.println("Escolha uma opção: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Boolean entradaInvalida;
		String escolha;
		do{
			escolha = reader.readLine();
			//Valida leitura
			if(!escolha.equals("C") && getOpcaoByCodigo(opcoes, escolha) == null){
				System.out.println("Opção inválida. Escolha uma opção válida: ");
				entradaInvalida = true;
			}else
				entradaInvalida = false;
		}while(entradaInvalida);
		
		if (escolha.equals("C"))
			return null;
		else
			return getOpcaoByCodigo(opcoes, escolha);
	}
	
	private static <T extends Imprimivel> T getOpcaoByCodigo(List<T> opcoes, String codigo) {
		for (T opcao : opcoes){
			if (opcao.getCodigoTela().equals(codigo))
				return opcao;
		}
		return null;
	}

	public static <T extends Imprimivel> List<T> leOpcoesMenu(List<T> opcoes) {
		return null;
	}

	public static <T extends Imprimivel> void imprimeOpcoes(List<T> opcoes)
	{
		
	}
}
