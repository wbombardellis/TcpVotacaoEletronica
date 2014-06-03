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
		
		ArrayList<T> opcoesCopia = new ArrayList<>(opcoes);
		ArrayList<T> opcoesEscolhidas = new ArrayList<>(opcoes);
		T opcao;
		Boolean fimLeitura;
		do{
			imprimeOpcoes(opcoesCopia);
			SaidaHelper.imprimeLinhaFromResources("mensagem.menu.opcao.escolher");
		
			opcao = leOpcao(opcoesCopia);
			if (opcao == null){
				fimLeitura = true;
				opcoesEscolhidas = null;
			}else{
				opcoesEscolhidas.add(opcao);
				opcoesCopia.remove(opcao);
				//Ler mais opções? @ TODO
				fimLeitura = false;
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
			if(!escolha.equals(codigoCancelar) && getOpcaoByCodigo(opcoes, escolha) == null){
				SaidaHelper.imprimeLinhaFromResources("mensagem.menu.erro.escolhaInvalida");
				entradaInvalida = true;
			}else
				entradaInvalida = false;
		}while(entradaInvalida);
		
		if (escolha.equals(codigoCancelar))
			return null;
		else
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
}
