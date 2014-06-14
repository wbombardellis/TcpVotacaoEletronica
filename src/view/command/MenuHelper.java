package view.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public abstract class MenuHelper {
	
	private static final String codigoCancelar = "C";

	public static <T extends Imprimivel> T leOpcaoMenu(List<T> opcoes) throws IOException {
		
		imprimeOpcoes(opcoes);
		
		SaidaHelper.imprimeLinhaFromResources("mensagem.menu.opcao.escolher");
		
		return leOpcao(opcoes);
	}
	
	private static <T extends Imprimivel> T getOpcaoByCodigo(List<T> opcoes, String codigo) {
		for (T opcao : opcoes){
			if (opcao.getCodigoTela().equals(codigo))
				return opcao;
		}
		return null;
	}

	public static <T extends Imprimivel> List<T> leOpcoesMenu(List<T> opcoes) throws IOException {
		
		ArrayList<T> opcoesMostrar = new ArrayList<>(opcoes);
		ArrayList<T> opcoesEscolhidas = new ArrayList<>(opcoes);
		T opcao;
		Boolean fimLeitura;
		do{
			imprimeOpcoes(opcoesMostrar);
			SaidaHelper.imprimeLinhaFromResources("mensagem.menu.opcao.escolher");
		
			opcao = leOpcao(opcoesMostrar);
			//Se é nulo, então usuário não escolheu nenhuma opção, portanto fim da letura (cancelamento)
			if (opcao == null){
				fimLeitura = true;
				opcoesEscolhidas = null;
			}else{
				//usuário escolheu uma opção. Adiciona-la à lista de escolhidas
				opcoesEscolhidas.add(opcao);
				//Remove-la da lista que vai para a tela, pois fora escolhida
				opcoesMostrar.remove(opcao);
				
				//Ler mais opções?
				SaidaHelper.imprimeLinhaFromResources("mesagem.menu.opcao.escolherMais");
				fimLeitura = !MenuHelper.leConfirmacao();
			}
		}while(!fimLeitura);
		
		return opcoesEscolhidas;
	}

	public static <T extends Imprimivel> void imprimeOpcoes(List<T> opcoes)
	{
		TextManager txtManager = new TextManager(SaidaHelper.nomeRecursos);
		//Imprime opções
		for (T opcao : opcoes)
		{
			SaidaHelper.imprimeLinha(opcao.getCodigoTela() + txtManager.getText("simbolo.menu.separadorCodigoDescricao") + opcao.getDescricaoTela());
		}
		SaidaHelper.imprimeLinha(codigoCancelar + " - " + txtManager.getText("simbolo.menu.opcao.cancelar"));
	}
	
	public static <T extends Imprimivel> T leOpcao(List<T> opcoes) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Boolean entradaInvalida;
		String escolha;
		do{
			escolha = reader.readLine();
			//Valida leitura
			if(getOpcaoByCodigo(opcoes, escolha) == null){
				SaidaHelper.imprimeLinhaFromResources("mensagem.menu.erro.escolhaInvalida");
				entradaInvalida = true;
			}else
				entradaInvalida = false;
		}while(entradaInvalida);
		
		return getOpcaoByCodigo(opcoes, escolha);
	}
	
	public static String leString() throws IOException
	{
		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
		Boolean entradaInvalida = true;
		String stringLida;
		
		do
		{
			stringLida = reader.readLine();
			if (!stringLida.isEmpty())
			{
				entradaInvalida = true;
			}
			else
			{
				entradaInvalida = false;
			}
		}
		while (entradaInvalida);
		
		return stringLida;
	}
	
	public static String leStringOpcional() throws IOException
	{
		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
		return reader.readLine();
	}
	
	/*
	 * Lê escolha do usuário quando é necessária uma confirmação do tipo (S/N). Retorna o booleano correspondente (S = true, N = false).
	 */
	public static Boolean leConfirmacao()
	{
		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
		Boolean entradaInvalida = true; 
		String stringLida = null;
		
		do
		{
			try
			{
				stringLida = reader.readLine();
			}
			catch (IOException e)
			{
				entradaInvalida = true;
			}
			
			if (!stringLida.isEmpty())
			{
				switch(stringLida)
				{
				case "S":
				case "s":
					return true;
				case "N":
				case "n":
					return false;
				}
			}
		}
		while (entradaInvalida);
		return false;
	}
}
