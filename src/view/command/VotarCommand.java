package view.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	
	private void imprimeVoto(Voto voto){
		
	}
	
	private Voto leVoto(){
		return null;
	}

	@Override
	public void execute() {
		List<Estado> estadosVotacao = new ArrayList<Estado>();
		Boolean addEstado = estadosVotacao.add(Estado.Aberta);
		
		assert addEstado;
		
		List<Votacao> votacoesDisponiveis = VotacaoDao.getInstance().getVotacoesByEstado(estadosVotacao);
		//Existem votações para serem votadas
		if (votacoesDisponiveis != null){
			try{
				Votacao votacao = MenuHelper.leOpcaoMenu(votacoesDisponiveis);

				//Escolheu uma votação para votar
				if (votacao != null){
					assert this.sessao != null;
					
					Voto voto = VotarController.getVotoByAutor(votacao, this.sessao.getMembro());
					
					//Usuário ainda não votou nesta votação
					if (voto == null){
						voto = leVoto();
						
						//Votou de fato
						if (voto != null){
							VotarController.insereVoto(votacao, voto);
							imprimeComprovanteVotacao();
						}
						
					}else{
						//Nesta votação escolhida o usuário já votou
						imprimeVoto(voto);
						
						Voto novoVoto = leVoto();
						
						if (novoVoto != null){
							VotarController.removeVoto(votacao, voto);
							VotarController.insereVoto(votacao, novoVoto);
							imprimeComprovanteVotacao();
						}
					}
				}
			}catch(IOException ex){
				Logger.getLogger(VotarCommand.class.getName()).log(Level.SEVERE, ex.getMessage());
			}
		}else{
			//Não existe votações para escolher
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
