package test;

import org.junit.Before;
import org.junit.Test;

import view.DocenteEDiscenteView;
import view.command.ListarVotacaoCommand;
import view.command.LogoutCommand;
import view.command.SairCommand;
import view.command.VisualizarVotacaoCommand;
import view.command.VotarCommand;
import junit.framework.TestCase;

public class DocenteEDiscenteViewTest extends TestCase
{
	private DocenteEDiscenteView viewToTest;
	
	@Before
	public void setUp()
	{
		viewToTest = new DocenteEDiscenteView();
	}
	
	@Test
	public void testSize()
	{
		assertEquals(5,viewToTest.getCommandsPossiveis().size());
	}
	
	@Test
	public void testContent()
	{
		assertTrue(viewToTest.getCommandsPossiveis().get(0) instanceof ListarVotacaoCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(1) instanceof VisualizarVotacaoCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(2) instanceof VotarCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(3) instanceof LogoutCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(4) instanceof SairCommand);
	}
}
