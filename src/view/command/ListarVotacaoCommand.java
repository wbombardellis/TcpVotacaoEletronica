package view.command;

import java.util.Arrays;
import java.util.List;

import model.dao.VotacaoDao;
import model.entity.Chefe;
import model.entity.Membro;
import model.entity.Secretario;
import model.entity.ViceChefe;
import model.entity.Estado;
import model.entity.Votacao;

public class ListarVotacaoCommand extends VotacaoCommand {

	protected List<Estado> listaEstadosChefia;
	
	public ListarVotacaoCommand(Sessao sessao) {
		super(sessao);
		
		this.listaEstadosChefia = Arrays.asList(Estado.Finalizada);
		this.listaEstados.add(Estado.Aberta);
	}

	@Override
	public void execute() {
		List<Votacao> votacoes;
		
		Membro membroLogado = sessao.getMembro();
		if (membroLogado instanceof Chefe
		|| membroLogado instanceof ViceChefe
		|| membroLogado instanceof Secretario) {
			votacoes = VotacaoDao.getInstance().getVotacoesByEstadoNot(this.listaEstadosChefia);
		} else {
			votacoes = VotacaoDao.getInstance().getVotacoesByEstado(this.listaEstados);
		}
		
		if (! votacoes.isEmpty()) {
			MenuHelper.imprimeOpcoes(votacoes);
			SaidaHelper.imprimeLinhaFromResources("simbolo.linha.branco");
		} else {
			SaidaHelper.imprimeLinhaFromResources("mensagem.votacao.semVotacoes");
			SaidaHelper.imprimeLinhaFromResources("simbolo.linha.branco");
		}		
		
	}

	@Override
	public String getCodigoTela() {
		return this.txtManager.getText("listar.votacao.codigo");
	}

	@Override
	public String getDescricaoTela() {
		return this.txtManager.getText("listar.votacao");
	}

}
