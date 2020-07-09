package condo.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RelatorioInformativo {
	public String assunto;
	public String conteudo;
	public Date dataInformativo;

	public RelatorioInformativo(String assunto, String conteudo, Date dataInformativo) {
		super();
		this.assunto = assunto;
		this.conteudo = conteudo;
		this.dataInformativo = dataInformativo;
	}

	public String getAssunto() {
		return assunto;
	}

	public String getConteudo() {
		return conteudo;
	}

	public String getDataInformativo() {
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataInformativo);
		return data;
	}
}
