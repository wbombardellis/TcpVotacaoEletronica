package model.dao;

import model.entity.Voto;

public class VotoDao extends AbstractDao<Voto>{
	private static VotoDao instance = null;
	
	protected VotoDao(){
		
	}

	public static VotoDao getInstance() {
		if (instance == null) {
			instance = new VotoDao();
		}
		return instance;
	}
}
