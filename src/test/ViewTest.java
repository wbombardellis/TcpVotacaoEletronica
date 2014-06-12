package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import view.View;

public class ViewTest
{
	View v1;
	
	@Before
	public void setUp()
	{
		v1 = new View();
	}
	
	@Test
	public void testContent()
	{
		assertEquals(2, v1.getCommandsPossiveis().size());
	}
}
