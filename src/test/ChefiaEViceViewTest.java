package test;

import org.junit.Before;
import org.junit.Test;

import view.ChefiaEViceView;
import view.command.AbrirVotacaoCommand;
import view.command.AutorizarVotacaoCommand;
import view.command.CriarVotacaoCommand;
import view.command.ExcluirVotacaoCommand;
import view.command.FecharVotacaoCommand;
import view.command.GerarAtaCommand;
import view.command.LerAtaCommand;
import view.command.LiberarVotacaoCommand;
import view.command.ListarVotacaoCommand;
import view.command.LogoutCommand;
import view.command.SairCommand;
import view.command.VisualizarVotacaoCommand;
import view.command.VotarCommand;
import junit.framework.TestCase;

public class ChefiaEViceViewTest extends TestCase
{
	private ChefiaEViceView viewToTest;
	
	@Before
	public void setUp()
	{
		viewToTest = new ChefiaEViceView();
	}
	
	@Test
	public void testSize()
	{
		assertEquals(13,viewToTest.getCommandsPossiveis().size());
	}
	
	@Test
	public void testContent()
	{
		assertTrue(viewToTest.getCommandsPossiveis().get(0) instanceof CriarVotacaoCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(1) instanceof AutorizarVotacaoCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(2) instanceof LiberarVotacaoCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(3) instanceof AbrirVotacaoCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(4) instanceof ListarVotacaoCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(5) instanceof VisualizarVotacaoCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(6) instanceof VotarCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(7) instanceof LerAtaCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(8) instanceof FecharVotacaoCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(9) instanceof ExcluirVotacaoCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(10) instanceof GerarAtaCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(11) instanceof LogoutCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(12) instanceof SairCommand);
	}
}
