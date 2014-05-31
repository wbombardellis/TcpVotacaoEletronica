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
		MembroDao membroDao = MembroDao.getInstance();
		membroDao.insert(new Chefe("Alan Turing","1","TheFirst"));
		membroDao.insert(new ViceChefe("Edsger Dijkstra","2","Path"));
		membroDao.insert(new Secretario("C.A.R. Hoare","3","Parallel"));
		membroDao.insert(new Docente("Alonzo Church","4","Lambda"));
		membroDao.insert(new Docente("John Von Neumann","5","fetch"));
		membroDao.insert(new Docente("Ada Lovelace","6","programming"));
		membroDao.insert(new Secretario("Donals Knuth","7","Art7"));
		membroDao.insert(new Docente("Bertrand Meyer","8","Eiffel"));
		membroDao.insert(new Docente("Linus Torvals","9","Linux"));
		membroDao.insert(new Docente("Douglas Engelbart","10","Mouse"));
		membroDao.insert(new Docente("Robert Dennard","11","raM"));
		membroDao.insert(new Docente("Richard W. Hamming","12","theCode!"));
		membroDao.insert(new Docente("Leslie Lamport","13","safety"));
		
	}

}
