package view.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public abstract class MenuHelper {
	
	private static final String codigoCancelar = "C";

	public static <T extends Imprimivel> T leOpcaoMenu(List<T> opcoes) throws IOException {
		
		TextManager txtManager = new TextManager(SaidaHelper.nomeRecursos);
		
		//Imprime op��es
		for (T opcao : opcoes)
		{
			SaidaHelper.imprimeLinha(opcao.getCodigoTela() + txtManager.getText("simbolo.menu.separadorCodigoDescricao") + opcao.getDescricaoTela());
		}
		SaidaHelper.imprimeLinha(codigoCancelar + " - " + txtManager.getText("simbolo.menu.opcao.cancelar"));
		
		SaidaHelper.imprimeLinhaFromResources("mensagem.menu.opcao.escolher");
		
		//Lê opção
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
