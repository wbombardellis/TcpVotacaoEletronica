package view.command;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.GerarAtaController;
import model.dao.VotacaoDao;
import model.entity.Estado;
import model.entity.Votacao;

public class GerarAtaCommand extends Command {

	public GerarAtaCommand(Sessao sessao) {
		super(sessao);
	}

	@Override
	public void execute() {
		List<Votacao> votacoes = VotacaoDao.getInstance().getVotacoesSemAtaByEstado(Estado.Finalizada);
		
		if (votacoes.isEmpty())
			SaidaHelper.imprimeLinhaFromResources("mensagem.ata.semAtas");
		else{
			try{
				GerarAtaController.criaAta( MenuHelper.leOpcoesMenu(votacoes) );
			}catch(IOException ex){
				Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ex.getMessage());
			}
		}
		
	}

	@Override
	public String getCodigoTela() {
		return this.txtManager.getText("gerar.ata.codigo");
	}

	@Override
	public String getDescricaoTela() {
		return this.txtManager.getText("gerar.ata");
	}

}
