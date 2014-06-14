package test;

import model.dao.MembroDao;

public class MembroDaoStub extends MembroDao
{
	
	public static MembroDaoStub getInstance() 
	{
		return new MembroDaoStub();
	}
}
