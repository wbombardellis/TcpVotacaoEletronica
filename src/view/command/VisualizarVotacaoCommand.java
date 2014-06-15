package view.command;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import model.entity.Chefe;
import model.entity.Documentacao;
import model.entity.Estado;
import model.entity.Membro;
import model.entity.Secretario;
import model.entity.ViceChefe;
import model.entity.Votacao;
import model.entity.Voto;

public class VisualizarVotacaoCommand extends VotacaoCommand {
	
	protected List<Estado> listaEstadosChefia;

	public VisualizarVotacaoCommand(Sessao sessao) {
		super(sessao);
		
		this.listaEstadosChefia = Estado.getListaTodosPossiveis();
		this.listaEstados.add(Estado.Aberta);
		this.listaEstados.add(Estado.Finalizada);
	}

	@Override
	public void execute() throws IOException {
		Votacao votacao;
		
		Membro membroLogado = sessao.getMembro();
		if (membroLogado instanceof Chefe
		|| membroLogado instanceof ViceChefe
		|| membroLogado instanceof Secretario) {
			votacao = this.leOpcaoListaVotacao(this.listaEstadosChefia);
		} else {
			votacao = this.leOpcaoListaVotacao(this.listaEstados);
		}
		
		if (votacao != null) {
			// Mostar dados da votação
			List<String> output = new ArrayList<>();
			TextManager txtMngr = new TextManager(SaidaHelper.nomeRecursos);
			SimpleDateFormat formatter = new SimpleDateFormat(txtManager.getText("locale.date_format"));
			
			output.add(txtMngr.getText("votacao.id") + votacao.getId());
			output.add(txtMngr.getText("votacao.titulo") + votacao.getTitulo());
			output.add(txtMngr.getText("votacao.dataInicio") + formatter.format(votacao.getDataInicio()));
			output.add(txtMngr.getText("votacao.dataFim") + formatter.format(votacao.getDataFim()));
			output.add(txtMngr.getText("votacao.estado") + votacao.getEstado());
			//// DOCUMENTAÇÃO DA VOTAÇÃO ////
			Documentacao docs = votacao.getDocumentacao();
			
			Map<Integer, String> nomeDocumentos = docs.getDescricaoDocumentosObrigatorios();
			for (Entry<Integer, String> documentoEntry : docs.getDocumentosObrigatorios().entrySet()) {
				output.add(nomeDocumentos.get(documentoEntry.getKey()) +": "+ documentoEntry.getValue());
			}
			Map<Integer, String> nomeDocumentosNaoObrigatorios = docs.getDescricaoDocumentosNaoObrigatorios();
			for (Entry<Integer, String> documentoEntry : docs.getDocumentosNaoObrigatorios().entrySet()) {
				output.add(nomeDocumentosNaoObrigatorios.get(documentoEntry.getKey()) +": "+ documentoEntry.getValue());
			}
			
			SaidaHelper.imprimeLinhas(output);
			output.clear();
			// Perguntar se deve-se Listar os votos
			SaidaHelper.imprimeLinhaFromResources("visualizar.votacao.mostrar.votos");
			if (MenuHelper.leConfirmacao()) {
				for (Voto voto : votacao.getVotos()) {
					output.add(txtMngr.getText("titulo.voto"));
					output.add(txtMngr.getText("voto.id") + voto.getId());
					output.add(txtMngr.getText("voto.autor") + voto.getAutor().getNome());
					output.add(txtMngr.getText("voto.tipo") + voto.getTipo());
					output.add(txtMngr.getText("voto.justificativa") + voto.getJustificativa());
				}
				SaidaHelper.imprimeLinhas(output);
			}
		} else {
			SaidaHelper.imprimeLinhaFromResources("mensagem.votacao.semVotacoes");
		}
	}

	@Override
	public String getCodigoTela() {
		return this.txtManager.getText("visualizar.votacao.codigo");
	}

	@Override
	public String getDescricaoTela() {
		return this.txtManager.getText("visualizar.votacao");
	}

}
