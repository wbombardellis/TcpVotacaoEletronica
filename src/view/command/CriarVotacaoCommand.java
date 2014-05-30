package view.command;

import java.util.ArrayList;
import java.util.List;

import model.entity.TipoDocumentacao;

public class CriarVotacaoCommand extends VotacaoCommand {
	
	protected List<TipoDocumentacao> tiposVotacao;

	public CriarVotacaoCommand(Sessao sessao) {
		super(sessao);
		
		this.tiposVotacao = new ArrayList<>();
		//this.tiposVotacao.add(TipoDocumentacao)
	}

	@Override
	public void execute() {
		
	}

	@Override
	public String getCodigoTela() {
		return "C";
	}

	@Override
	public String getDescricaoTela() {
		return "Criar Votação";
	}

}
