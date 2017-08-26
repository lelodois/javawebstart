package br.com.lelo.clientserver.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ClientServiceImpressaoBean {

	private List<FilaImpressaoItem> impressoesRealizadas = new ArrayList<FilaImpressaoItem>();
	private Date lastDateImpressao;
	private String lastTextImpresso;

	public ClientServiceImpressaoBean() {
	}

	public int getProcessedItensCount() {
		return impressoesRealizadas.size();
	}

	public List<FilaImpressaoItem> getImpressoesRealizadas() {
		List<FilaImpressaoItem> returnItens = new ArrayList<FilaImpressaoItem>(impressoesRealizadas);
		Collections.unmodifiableCollection(returnItens);
		return returnItens;
	}

	public void adicionarImpressao(FilaImpressaoItem item) {
		this.lastDateImpressao = new Date();
		this.lastTextImpresso = item.getText();
		this.impressoesRealizadas.add(item);
	}

	public String getLastTextImpresso() {
		return lastTextImpresso;
	}

	public Date getLastDateImpressao() {
		return lastDateImpressao;
	}
}
