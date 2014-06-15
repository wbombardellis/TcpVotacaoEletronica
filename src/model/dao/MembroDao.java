package model.dao;

import model.entity.Membro;
import model.entity.Secretario;

import java.util.ArrayList;
import java.util.List;

public class MembroDao extends AbstractDao<Membro>
{
	private static MembroDao instance = null;

	protected MembroDao()
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

	public List<Membro> getMembrosQueVotam()
	{
		ArrayList<Membro> resultado = new ArrayList<Membro>();
		
		for (Membro membro : this.getAll())
		{
			if (!(membro instanceof Secretario)) // Se o membro não for um secretário, ele pode votar
			{
				resultado.add(membro);
			}
		}
		return resultado;
		
	}

}
