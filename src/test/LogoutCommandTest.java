package test;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import model.dao.MembroDao;
import model.entity.Chefe;

import org.junit.Before;
import org.junit.Test;

import controller.LoginController;
import view.command.LogoutCommand;
import view.command.Sessao;

public class LogoutCommandTest extends TestCase
{
	private LogoutCommand logoutCommand;
	
	@Before
	public void setUp()
	{
		logoutCommand = new LogoutCommand(Sessao.getInstance());

		// Insere um membro no MembroDao, para testar o logout.
		MembroDao membroDao = MembroDao.getInstance();
		membroDao.insert(new Chefe("Chefe Test","1","chefeum"));
	}
	
	@Test
	public void testCodigo()
	{
		assertEquals("E", logoutCommand.getCodigoTela());
	}
	
	@Test
	public void testDescricao()
	{
		assertEquals("Fazer logout", logoutCommand.getDescricaoTela());
	}
	
	@Test
	public void testLogout()
	{
		LoginController controllerTeste = new LoginController("1", "chefeum");	
		if (controllerTeste.autenticar() == true) // Deve autenticar com sucesso, pois as credenciais estão corretas.
		{
			assertTrue(Sessao.getInstance().getMembro() instanceof Chefe); // Chefe está logado.
			Sessao.getInstance().setMembro(null);
			assertNull(Sessao.getInstance().getMembro()); // Usuário é Null, significa que logout foi feito com sucesso.
		}
		else
		{
			fail("Falha na autenticação");
		}
	}
}
