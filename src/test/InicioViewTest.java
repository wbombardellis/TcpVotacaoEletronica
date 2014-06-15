package test;

import org.junit.Before;
import org.junit.Test;

import view.InicioView;
import view.command.LoginCommand;
import view.command.SairCommand;
import junit.framework.TestCase;

public class InicioViewTest extends TestCase
{
	private InicioView viewToTest;
	
	@Before
	public void setUp()
	{
		viewToTest = new InicioView();
	}
	
	@Test
	public void testSize()
	{
		assertEquals(2,viewToTest.getCommandsPossiveis().size());
	}
	
	@Test
	public void testContent()
	{
		assertTrue(viewToTest.getCommandsPossiveis().get(0) instanceof LoginCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(1) instanceof SairCommand);
	}
}
