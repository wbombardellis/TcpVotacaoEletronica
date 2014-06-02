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
		SaidaHelper.imprimeLinhaFromResources("votar.titulo.comprovante");
		SaidaHelper.imprimeLinhaFromResources("votar.sucesso");
	}
	
	private void imprimeVoto(Voto voto){
		ArrayList<String> output = new ArrayList<>();
		TextManager txtMngr = new TextManager(SaidaHelper.nomeRecursos);
		
		output.add(txtMngr.getText("titulo.voto"));
		output.add(txtMngr.getText("voto.id") + voto.getId());
		output.add(txtMngr.getText("voto.autor") + voto.getAutor().getNome());
		output.add(txtMngr.getText("voto.tipo") + voto.getTipo());
		output.add(txtMngr.getText("voto.data") + voto.getData());
		output.add(txtMngr.getText("voto.justificativa") + voto.getJustificativa());
		
		SaidaHelper.imprimeLinhas(output);
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
			TextManager txtManager = new TextManager(SaidaHelper.nomeRecursos);
			SaidaHelper.imprimeLinhaFromResources(txtManager.getText("mensagem.votacao.semVotacoes"));
		}
	}

	@Override
	public String getCodigoTela() {
		return "V";
	}

	@Override
	public String getDescricaoTela() {
		return "Votar";
	}

}
