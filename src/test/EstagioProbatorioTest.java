package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import model.entity.EstagioProbatorio;

import org.junit.Test;

public class EstagioProbatorioTest {

	@Test
	public void testEstagioProbatorio() {

		Map<Integer, String> docsObrig = new HashMap<>();
		docsObrig.put(0, "Doc 1");
		docsObrig.put(1, "Doc 2");
		
		Map<Integer, String> docsNaoObrig = new HashMap<>();
		docsNaoObrig.put(0,"Doc nao obrig");
		
		EstagioProbatorio obj = new EstagioProbatorio(docsObrig, docsNaoObrig);
		
		assertEquals(docsObrig, obj.getDocumentosObrigatorios());
		assertNotEquals(docsNaoObrig, obj.getDocumentosNaoObrigatorios());
		assertEquals(new HashMap<>(), obj.getDocumentosNaoObrigatorios());
		
		obj = new EstagioProbatorio(docsObrig, docsNaoObrig = new HashMap<>());
		
		assertEquals(docsObrig, obj.getDocumentosObrigatorios());
		assertEquals(docsNaoObrig, obj.getDocumentosNaoObrigatorios());
		docsNaoObrig.put(0, "");
		assertNotEquals(docsNaoObrig, obj.getDocumentosNaoObrigatorios());
	}

}
