package view.command;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.dao.AtaDao;
import model.entity.Ata;
import model.entity.AtaVotacao;

public class LerAtaCommand extends Command {

	public LerAtaCommand(Sessao sessao) {
		super(sessao);
	}

	@Override
	public void execute() {
		Collection<Ata> atas = AtaDao.getInstance().getAll();
		
		if (atas.isEmpty()){
			SaidaHelper.imprimeLinhaFromResources("mensagem.ata.semAtas");
			SaidaHelper.imprimeLinha("");
		}else{
			
			try{
				SaidaHelper.imprimeLinhaFromResources("ler.ata.disponiveis");
				
				Ata ata = MenuHelper.leOpcaoMenu(new ArrayList<Ata>(atas));
				
				TextManager txtManager = new TextManager(SaidaHelper.nomeRecursos);
				SimpleDateFormat formatter = new SimpleDateFormat(txtManager.getText("locale.date_format"));
				
				ArrayList<String> relatorioTexto = new ArrayList<>();
				
				relatorioTexto.add(txtManager.getText("titulo.ata"));
				relatorioTexto.add(txtManager.getText("texto.ata.id") + ata.getId());
				
				for (AtaVotacao ataVotacao : ata.getAtasVotacoes()){
					relatorioTexto.add(txtManager.getText("titulo.ataVotacao"));
					relatorioTexto.add(txtManager.getText("texto.ataVotacao.id") + ataVotacao.getId());
					relatorioTexto.add(txtManager.getText("texto.ataVotacao.dataInicio") + formatter.format(ataVotacao.getDataInicio()));
					relatorioTexto.add(txtManager.getText("texto.ataVotacao.dataFim") + formatter.format(ataVotacao.getDataFim()));
					
					relatorioTexto.add(txtManager.getText("texto.ataVotacao.qtdVotantes") + ataVotacao.getVotantes().size());
					relatorioTexto.add(txtManager.getText("texto.ataVotacao.qtdNaoVotantes") + ataVotacao.getNaoVotantes().size());
					relatorioTexto.add(txtManager.getText("texto.ataVotacao.qtdVotosFavoraveis") + ataVotacao.getQtdVotosFavoriaveis());
					relatorioTexto.add(txtManager.getText("texto.ataVotacao.qtdVotosNaoFavoraveis") + ataVotacao.getQtdVotosNaoFavoriaveis());
					relatorioTexto.add(txtManager.getText("texto.ataVotacao.qtdVotosAbstencao") + ataVotacao.getAbstencoes().size());
					
					relatorioTexto.add(txtManager.getText("texto.ataVotacao.resultado") 
					+ (ataVotacao.getResultado() == true ? txtManager.getText("texto.ataVotacao.aprovado") : txtManager.getText("texto.ataVotacao.reprovado") ));
				}
				
				SaidaHelper.imprimeLinhas(relatorioTexto);
				SaidaHelper.imprimeLinhaFromResources("simbolo.linha.branco");				
			}catch(IOException ex){
				Logger.getLogger(LerAtaCommand.class.getName()).log(Level.SEVERE, ex.getMessage());
			}
		}
		
	}

	@Override
	public String getCodigoTela() {
		return this.txtManager.getText("ler.ata.codigo");
	}

	@Override
	public String getDescricaoTela() {
		return this.txtManager.getText("ler.ata");
	}

}
