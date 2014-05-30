package controller;

import view.View;
import model.Inicializador;

public class Main {

	public static void main(String[] args) {
		Inicializador.incializaDao();
		
		new View().imprimeMenu();
	}

}
