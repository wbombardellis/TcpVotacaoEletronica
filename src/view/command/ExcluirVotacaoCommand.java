package view.command;

import java.io.IOException;

import model.dao.VotacaoDao;
import model.entity.Estado;
import model.entity.Votacao;

public class ExcluirVotacaoCommand extends VotacaoCommand {

	public ExcluirVotacaoCommand(Sessao sessao) {
		super(sessao);
		
		this.listaEstados = Estado.getListaTodosPossiveis();
		this.listaEstados.remove(Estado.Finalizada);
	}

	@Override
	public void execute() throws IOException {
		Votacao votacao = this.leOpcaoListaVotacao(this.listaEstados);
		
		if (votacao != null) {
			boolean confirmadaExclusao = true;
			if (! votacao.getVotos().isEmpty()) {
				// Informa usuário e pede confirmação
				SaidaHelper.imprimeLinhaFromResources("excluir.informar.votos");
				SaidaHelper.imprimeLinhaFromResources("excluir.pedir.confirmacao");
				confirmadaExclusao = MenuHelper.leConfirmacao();
			}
			
			if (confirmadaExclusao) {
				VotacaoDao.getInstance().delete(votacao.getId());
				// Mensagens ao usuário
				SaidaHelper.imprimeLinhaFromResources("excluir.sucesso");
				SaidaHelper.imprimeLinhaFromResources("simbolo.linha.branco");

			} else {
				// Mensagens ao usuário
				SaidaHelper.imprimeLinhaFromResources("excluir.falha");
				SaidaHelper.imprimeLinhaFromResources("simbolo.linha.branco");

			}
		} else {
			SaidaHelper.imprimeLinhaFromResources("mensagem.votacao.semVotacoes");
			SaidaHelper.imprimeLinhaFromResources("simbolo.linha.branco");

		}
		
	}

	@Override
	public String getCodigoTela() {
		return this.txtManager.getText("excluir.votacao.codigo");
	}

	@Override
	public String getDescricaoTela() {
		return this.txtManager.getText("excluir.votacao");
	}

}
