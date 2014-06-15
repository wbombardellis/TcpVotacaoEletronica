package model.entity;

import java.util.ArrayList;
import java.util.List;

import view.command.Imprimivel;

public enum TipoVoto implements Imprimivel{

	Favoravel("F","Favorável"),
	NaoFavoravel("N","Não-favorável"),
	Abstencao("A", "Abstenção");
	
	private String codigoTela;
	private String descricaoTela;
	TipoVoto(String codigoTela, String descricaoTela) {
		this.codigoTela = codigoTela;
		this.descricaoTela = descricaoTela;
	}
	
	@Override
	public String getCodigoTela() {
		return this.codigoTela;
	}

	@Override
	public String getDescricaoTela() {
		return this.descricaoTela;
	}
	
	public static List<TipoVoto> getListaTodosPossiveis() {
		List<TipoVoto> lst = new ArrayList<>();
		
		lst.add(TipoVoto.Favoravel);
		lst.add(TipoVoto.NaoFavoravel);
		lst.add(TipoVoto.Abstencao);
		
		return lst;
	}

}
