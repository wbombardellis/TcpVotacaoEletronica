package test;

import junit.framework.TestCase;
import model.dao.MembroDao;
import model.entity.Chefe;
import model.entity.Discente;
import model.entity.Docente;
import model.entity.Secretario;
import model.entity.ViceChefe;

import org.junit.Before;
import org.junit.Test;

import controller.LoginController;
import view.command.LoginCommand;
import view.command.Sessao;

public class LoginCommandTest extends TestCase
{
private LoginCommand loginCommand;
	
	@Before
	public void setUp()
	{
		loginCommand = new LoginCommand(Sessao.getInstance());
		
		// Insere 5 membros (um de cada tipo) no MembroDao
		MembroDao membroDao = MembroDao.getInstance();
		membroDao.insert(new Chefe("Chefe Test","1","chefeum"));
		membroDao.insert(new ViceChefe("ViceChefe Test","2","vicedois"));
		membroDao.insert(new Secretario("Secretario Test","3","secretariotres"));
		membroDao.insert(new Docente("Docente Test","4","docentequatro"));
		membroDao.insert(new Discente("Discente Test","5","discentecinco"));
	}
	
	@Test
	public void testCodigo()
	{
		assertEquals("L", loginCommand.getCodigoTela());
	}
	
	@Test
	public void testDescricao()
	{
		assertEquals("Fazer login", loginCommand.getDescricaoTela());
	}
	
	@Test
	public void testLoginChefe()
	{
		LoginController controllerTeste = new LoginController("1", "chefeum");
		
		assertTrue(controllerTeste.autenticar()); // Teste deve passar, pois as credenciais estão corretas.
		assertTrue(Sessao.getInstance().getMembro() instanceof Chefe); // Confirma que o membro logado é o Chefe.
	}
	
	
	@Test
	public void testLoginViceChefe()
	{
		LoginController controllerTeste = new LoginController("2", "vicedois");
		
		assertTrue(controllerTeste.autenticar()); // Teste deve passar, pois as credenciais estão corretas.
		assertTrue(Sessao.getInstance().getMembro() instanceof ViceChefe); // Confirma que o membro logado é o ViceChefe.
	}

	@Test
	public void testLoginSecretario()
	{
		LoginController controllerTeste = new LoginController("3", "secretariotres");
		
		assertTrue(controllerTeste.autenticar()); // Teste deve passar, pois as credenciais estão corretas.
		assertTrue(Sessao.getInstance().getMembro() instanceof Secretario); // Confirma que o membro logado é o Secretario.
	}

	@Test
	public void testLoginDocente()
	{
		LoginController controllerTeste = new LoginController("4", "docentequatro");
		
		assertTrue(controllerTeste.autenticar()); // Teste deve passar, pois as credenciais estão corretas.
		assertTrue(Sessao.getInstance().getMembro() instanceof Docente); // Confirma que o membro logado é o Docente.
	}

	@Test
	public void testLoginDiscente()
	{
		LoginController controllerTeste = new LoginController("5", "discentecinco");
		
		assertTrue(controllerTeste.autenticar()); // Teste deve passar, pois as credenciais estão corretas.
		assertTrue(Sessao.getInstance().getMembro() instanceof Discente); // Confirma que o membro logado é o Discente.
	}
	
	@Test
	public void testLoginInvalido()
	{
		LoginController controllerTeste = new LoginController("1", "credencialErrada");
		
		assertFalse(controllerTeste.autenticar()); // Autenticar deve retornar false, pois as credenciais estão incorretas.
		assertNull(Sessao.getInstance().getMembro()); // O membro logado deve ser null, pois a autenticação falhou.
	}
}
