package model.entity;

import java.util.ArrayList;
import java.util.List;

public enum Estado {

	Bloqueada, Autorizada, Liberada, Aberta, Finalizada;

	public static List<Estado> getListaTodosPossiveis() {
		List<Estado> lst = new ArrayList<>();
		
		lst.add(Estado.Bloqueada);
		lst.add(Estado.Autorizada);
		lst.add(Estado.Liberada);
		lst.add(Estado.Aberta);
		lst.add(Estado.Finalizada);
		
		return lst;
	}
}
