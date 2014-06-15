package test;

import model.entity.Chefe;

import org.junit.Before;
import org.junit.Test;

import view.command.Sessao;
import junit.framework.TestCase;

public class SessaoTest extends TestCase
{
	Sessao sessao;
	Chefe chefe;
	
	@Before
	public void setUp()
	{
		sessao = Sessao.getInstance();
		chefe = Chefe.substituirChefe("Chefe Teste", "1", "testechefe");
	}
	
	@Test
	public void testSessao()
	{
		sessao.setMembro(chefe);
		assertEquals(chefe,sessao.getMembro());
	}
}
