package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import view.command.SaidaHelper;
import view.command.TextManager;

public class TextManagerTest {

	private TextManager txtMng;
	
	@Before
	public void setUp() throws Exception {
		txtMng = new TextManager(SaidaHelper.nomeRecursos);
	}
	
	@Test(expected = Exception.class)
	public void testGetTextFail() {
		txtMng.getText("test.mensagem0");
	}

	@Test
	public void testGetText() {
		assertEquals("Teste 1 com espaços e cê-cedilha", txtMng.getText("test.mensagem1"));
		assertEquals("Teste 1 áéàóõã[]'~\"\\\\ \\n com acentos e símbolos", txtMng.getText("test.mensagem2"));
		assertEquals(" ", txtMng.getText("test.mensagem3"));
	}

}
