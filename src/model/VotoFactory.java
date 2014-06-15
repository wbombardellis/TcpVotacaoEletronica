package model;

import java.util.Date;

import model.dao.VotoDao;
import model.entity.Membro;
import model.entity.TipoVoto;
import model.entity.Voto;

public class VotoFactory {

	public static Voto criaVoto(TipoVoto tipoVoto, Membro autor, Date data, String justificativa){
		Integer id = VotoDao.getInstance().getLastInsertedId();
		id++;
		
		return new Voto(id, tipoVoto, autor, data, justificativa);
	}
	
}
