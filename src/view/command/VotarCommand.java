package view.command;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.List;

import controller.VotarController;
import model.dao.VotacaoDao;
import model.entity.Estado;
import model.entity.Votacao;
import model.entity.Voto;

public class VotarCommand extends Command {

	public VotarCommand(Sessao sessao) {
		super(sessao);
	}

	private void imprimeComprovanteVotacao() {

	}

	@Override
	public void execute() {
		List<Estado> estadosVotacao = new ArrayList<Estado>();
		estadosVotacao.add(Estado.Aberta);
		
		List<Votacao> votacoesDisponiveis = VotacaoDao.getInstance().getVotacoesByEstado(estadosVotacao);
		//Existem votações para serem votadas
		if (votacoesDisponiveis != null){
			Votacao votacao = MenuHelper.leOpcaoMenu(votacoesDisponiveis);
			
			//Escolheu uma votação para votar
			if (votacao != null){
				Voto voto = VotarController.getVotoByAutor(votacao, this.sessao.getMembro());
				
				//Porém na votação escolhida o usuário já votou
				if (voto == null){
					// Le voto
					
					//
					if (voto != null)
				}
			}
		}else{
			
		}
	}

	@Override
	public String getCodigoTela() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescricaoTela() {
		// TODO Auto-generated method stub
		return null;
	}

}
