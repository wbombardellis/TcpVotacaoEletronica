package model;

import model.dao.MembroDao;
import model.dao.VotacaoDao;
import model.entity.Chefe;
import model.entity.Discente;
import model.entity.Docente;
import model.entity.Secretario;
import model.entity.ViceChefe;

public abstract class Inicializador {

	public static void incializaDao() {
		
		MembroDao.getInstance().insert(new Chefe("Alan Turing","1","TheFirst"));
		MembroDao.getInstance().insert(new ViceChefe("Edsger Dijkstra","2","Path"));
		MembroDao.getInstance().insert(new Secretario("C.A.R. Hoare","3","Parallel"));
		MembroDao.getInstance().insert(new Docente("Alonzo Church","4","Lambda"));
		MembroDao.getInstance().insert(new Docente("John Von Neumann","5","fetch"));
		MembroDao.getInstance().insert(new Docente("Ada Lovelace","6","programming"));
		MembroDao.getInstance().insert(new Secretario("Donals Knuth","7","Art7"));
		MembroDao.getInstance().insert(new Docente("Bertrand Meyer","8","Eiffel"));
		MembroDao.getInstance().insert(new Docente("Linus Torvals","9","Linux"));
		MembroDao.getInstance().insert(new Docente("Douglas Engelbart","10","Mouse"));
		MembroDao.getInstance().insert(new Docente("Robert Dennard","11","raM"));
		MembroDao.getInstance().insert(new Docente("Richard W. Hamming","12","theCode!"));
		MembroDao.getInstance().insert(new Docente("Leslie Lamport","13","safety"));
		
	}

}
