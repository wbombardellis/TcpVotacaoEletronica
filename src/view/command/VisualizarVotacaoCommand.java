package view.command;

import java.util.Arrays;
import java.util.List;

import model.entity.Chefe;
import model.entity.Docente;
import model.entity.Estado;
import model.entity.Membro;
import model.entity.Secretario;
import model.entity.ViceChefe;
import model.entity.Votacao;

public class VisualizarVotacaoCommand extends VotacaoCommand {
	
	protected List<Estado> listaEstadosChefia;

	public VisualizarVotacaoCommand(Sessao sessao) {
		super(sessao);
		
		this.listaEstadosChefia = Estado.getListaTodosPossiveis();
		this.listaEstados.add(Estado.Aberta);
		this.listaEstados.add(Estado.Finalizada);
	}

	@Override
	public void execute() {
		Votacao votacao;
		
		Membro membroLogado = sessao.getMembro();
		if (membroLogado instanceof Chefe
		|| membroLogado instanceof ViceChefe
		|| membroLogado instanceof Secretario) {
			votacao = this.leOpcaoListaVotacao(this.listaEstadosChefia);
		} else {
			votacao = this.leOpcaoListaVotacao(this.listaEstados);
		}
		
		// Mostar dados da votação
		
		// Perguntar se deve-se Listar os votos
	}

	@Override
	public String getCodigoTela() {
		return "M";
	}

	@Override
	public String getDescricaoTela() {
		return "Visualizar (Mostrar) Votação";
	}

}
