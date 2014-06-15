package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import model.entity.AfastamentoPais;

import org.junit.Test;

public class AfastamentoPaisTest {


	@Test
	public void testAfastamentoPais() {
		
		Map<Integer, String> docsObrig = new HashMap<>();
		docsObrig.put(0, "Doc 1");
		docsObrig.put(1, "Doc 2");
		
		Map<Integer, String> docsNaoObrig = new HashMap<>();
		docsNaoObrig.put(0,"Doc nao obrig");
		
		AfastamentoPais obj = new AfastamentoPais(docsObrig, docsNaoObrig);
		
		assertEquals(docsObrig, obj.getDocumentosObrigatorios());
		assertEquals(docsNaoObrig, obj.getDocumentosNaoObrigatorios());
		
		obj = new AfastamentoPais(docsObrig, docsNaoObrig = new HashMap<>());
		
		assertEquals(docsObrig, obj.getDocumentosObrigatorios());
		assertNotEquals(docsNaoObrig, obj.getDocumentosNaoObrigatorios());
		docsNaoObrig.put(0, "");
		assertEquals(docsNaoObrig, obj.getDocumentosNaoObrigatorios());
	}

}
