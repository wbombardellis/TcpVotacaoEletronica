package model.dao;

import model.entity.Membro;

import java.util.ArrayList;
import java.util.List;

public class MembroDao extends AbstractDao<Membro>
{
	private static MembroDao instance;

	private MembroDao()
	{
		
	}
	
	public static MembroDao getInstance() 
	{
		if (instance == null)
		{
			instance = new MembroDao();
		}
		return instance;
	}

	public Membro getMembroByUsername(String username)
	{	
		for(Membro membro : this.getAll())
		{
			if (membro.getUsername().equals(username))
			{
				return membro;
			}
		}
		return null;
	}

	public List<Membro> getMembrosQueVotam() {
		return null;
	}

}
