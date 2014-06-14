package test;

import static org.junit.Assert.*;

import java.util.Date;

import model.VotoFactory;
import model.entity.Membro;
import model.entity.TipoVoto;
import model.entity.Voto;

import org.junit.Test;

public class VotoFactoryTest {

	@Test(expected = AssertionError.class)
	public void testCriaVotoNull() {
		VotoFactory.criaVoto(null, null, null, null);
	}
	
	@Test
	public void testCriaVoto() {
		//Cria elementos apenas para popular a ata
		Membro membro1 = new Membro("membro1", "teste1", "1234");
		Membro membro2 = new Membro("membro2", "teste2", "1234");
		
		Date data1 = new Date();
		Voto v1 = VotoFactory.criaVoto(TipoVoto.Favoravel, membro1, data1, null);
		Voto v2 = VotoFactory.criaVoto(TipoVoto.NaoFavoravel, membro2, new Date(), "teste");
		
		assertEquals(1, v1.getId());
		assertEquals(TipoVoto.Favoravel, v1.getTipo());
		assertEquals(membro1, v1.getAutor()); 
		assertEquals(data1, v1.getData());
		assertNull(v1.getJustificativa());
		
		assertEquals(2, v2.getId());
		assertEquals(membro2, v1.getAutor());
		assertEquals("teste", v2.getJustificativa());
	}

}
