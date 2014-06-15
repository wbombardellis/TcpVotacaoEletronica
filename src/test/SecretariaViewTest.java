package test;

import org.junit.Before;
import org.junit.Test;

import view.SecretariaView;
import view.command.AbrirVotacaoCommand;
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
import junit.framework.TestCase;

public class SecretariaViewTest extends TestCase
{
	private SecretariaView viewToTest;
	
	@Before
	public void setUp()
	{
		viewToTest = new SecretariaView();
	}
	
	@Test
	public void testSize()
	{
		assertEquals(11,viewToTest.getCommandsPossiveis().size());
	}
	
	@Test
	public void testContent()
	{
		assertTrue(viewToTest.getCommandsPossiveis().get(0) instanceof CriarVotacaoCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(1) instanceof LiberarVotacaoCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(2) instanceof AbrirVotacaoCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(3) instanceof ListarVotacaoCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(4) instanceof VisualizarVotacaoCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(5) instanceof LerAtaCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(6) instanceof FecharVotacaoCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(7) instanceof ExcluirVotacaoCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(8) instanceof GerarAtaCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(9) instanceof LogoutCommand);
		assertTrue(viewToTest.getCommandsPossiveis().get(10) instanceof SairCommand);
	}
}
