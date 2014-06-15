package controller;

import view.command.Sessao;
import model.Inicializador;

public class Main {

	public static void main(String[] args) {
		Sessao sessao = Sessao.getInstance();
		sessao.setMembro(null);
		
		Inicializador.incializaDao();
		
		sessao.getView().imprimeMenu();
	}
}
