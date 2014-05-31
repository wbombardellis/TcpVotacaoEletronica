package view.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.dao.AtaDao;
import model.entity.Ata;
import model.entity.AtaVotacao;
import model.entity.Membro;
import model.entity.Votacao;
import model.entity.Voto;

public class LerAtaCommand extends Command {

	public LerAtaCommand(Sessao sessao) {
		super(sessao);
	}

	@Override
	public void execute() {
		Collection<Ata> atas = AtaDao.getInstance().getAll();
		
		if (atas.isEmpty())
			SaidaHelper.imprimeLinhaFromResources("mensagem.ata.semAtas");
		else{
			try{
				Ata ata = MenuHelper.leOpcaoMenu(new ArrayList<Ata>(atas));
				
				TextManager txtManager = new TextManager(SaidaHelper.nomeRecursos);
				
				ArrayList<String> relatorioTexto = new ArrayList<>();
				
				relatorioTexto.add(txtManager.getText("titulo.ata"));
				relatorioTexto.add(txtManager.getText("texto.ata.id") + ata.getId());
				
				for (AtaVotacao ataVotacao : ata.getAtasVotacoes()){
					relatorioTexto.add(txtManager.getText("titulo.ataVotacao"));
					relatorioTexto.add(txtManager.getText("texto.ataVotacao.id") + ataVotacao.getId());
					relatorioTexto.add(txtManager.getText("texto.ataVotacao.dataInicio") + ataVotacao.getDataInicio());
					relatorioTexto.add(txtManager.getText("texto.ataVotacao.dataFim") + ataVotacao.getDataFim());
					relatorioTexto.add(txtManager.getText("texto.ataVotacao.resultado") 
					+ (ataVotacao.getResultado() == true ? txtManager.getText("texto.aprovado") : txtManager.getText("texto.reprovado") ));
					
					/*
					public List<Membro> getVotantes()
					public List<Membro> getNaoVotantes() 
					public List<Membro> getAbstencoes() 
					public List<Voto> getVotos() 
					public boolean getResultado()*/
					
					relatorioTexto.add(txtManager.getText("texto.ataVotacao.idAta") + ataVotacao.getId());
				}
				relatorioTexto.addAll();
				
				SaidaHelper.imprimeLinhas(relatorioTexto);
				
			}catch(IOException ex){
				Logger.getLogger(LerAtaCommand.class.getName()).log(Level.SEVERE, ex.getMessage());
			}
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
