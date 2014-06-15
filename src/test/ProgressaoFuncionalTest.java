package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import model.entity.ProgressaoFuncional;

import org.junit.Test;

public class ProgressaoFuncionalTest {

	@Test
	public void testProgressaoFuncional() {
		
		Map<Integer, String> docsObrig = new HashMap<>();
		docsObrig.put(0, "Doc 1");
		docsObrig.put(1, "Doc 2");
		
		Map<Integer, String> docsNaoObrig = new HashMap<>();
		docsNaoObrig.put(0,"Doc nao obrig");
		
		ProgressaoFuncional obj = new ProgressaoFuncional(docsObrig, docsNaoObrig);
		
		assertNotEquals(docsObrig, obj.getDocumentosObrigatorios());
		docsObrig.put(2, "");
		assertEquals(docsObrig, obj.getDocumentosObrigatorios());
		
		assertNotEquals(docsNaoObrig, obj.getDocumentosNaoObrigatorios());
		assertEquals(new HashMap<>(), obj.getDocumentosNaoObrigatorios());
		
		docsObrig.put(2, "Another document");
		obj = new ProgressaoFuncional(docsObrig, docsNaoObrig = new HashMap<>());
		
		assertEquals(docsObrig, obj.getDocumentosObrigatorios());
		assertEquals(docsNaoObrig, obj.getDocumentosNaoObrigatorios());
		docsNaoObrig.put(0, "");
		assertNotEquals(docsNaoObrig, obj.getDocumentosNaoObrigatorios());
	}

}
