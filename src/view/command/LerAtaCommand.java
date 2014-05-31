package view.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.dao.AtaDao;
import model.entity.Ata;

public class LerAtaCommand extends Command {

	public LerAtaCommand(Sessao sessao) {
		super(sessao);
	}

	@Override
	public void execute() {
		List<Ata> atas = AtaDao.getInstance().getAll();
		
		if (atas.isEmpty())
			SaidaHelper.imprimirLinhaFromResources("mensagem.ata.semAtas");
		
		else{
			try{
				Ata ata = MenuHelper.leOpcaoMenu(atas);
				
				ArrayList<String> relatorioTexto = new ArrayList<>();
				//Adiciona outras informações @TODO
				relatorioTexto.addAll(ata.getDescricao());
				
				SaidaHelper.imprimirLinhas(relatorioTexto);
				
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
