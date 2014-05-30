package model.entity;

public class Chefe extends Membro {

	private static Chefe chefe;

	private Chefe(String nome, String username, String password) {
		super(nome, username, password);
	}

	public Chefe getInstance() {
		return null;
	}

}
