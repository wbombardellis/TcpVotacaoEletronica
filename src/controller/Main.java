package controller;

import view.InicioView;
import model.Inicializador;

public class Main {

	public static void main(String[] args) {
		Inicializador.incializaDao();
		
		new InicioView().imprimeMenu();
	}
}
