package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import model.dao.VotacaoDao;
import model.entity.Estado;
import model.entity.Votacao;

public abstract class LiberarVotacaoController {

	public static List<String> liberaVotacao(Votacao votacao) {
		List<String> warnings = new ArrayList<>();
		
		// Verifica se há documentos não informados
		boolean faltamDocumentos = false;
		Map<Integer, String> docsObrigatorios = votacao.getDocumentacao().getDocumentosObrigatorios();
		for (Entry<Integer, String> parNumCaminhoDoc : docsObrigatorios.entrySet()) {
			if (parNumCaminhoDoc.getValue().isEmpty()) {
				faltamDocumentos = true;
				break;
			}
		}
		
		if (faltamDocumentos) {
			warnings.add("Há documentos origatórios faltantes");
		}
		
		// Atualiza o status da votação para liberada 
		Votacao novaVotacao = new Votacao(votacao, Estado.Liberada);
		
		VotacaoDao.getInstance().update(votacao.getId(), novaVotacao);
		
		return warnings;
	}

}
