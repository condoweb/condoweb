package condo.entities.sindico;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RelatorioContaRecebidaArrecadacaoPeriodo {
	public String nome;
	public Integer numApto;
	public Integer numBloco;
	public Date mesVigente;
	public Date dataVencimento;
	public Date dataPagamento;
	public Double valorPago;

	public RelatorioContaRecebidaArrecadacaoPeriodo(String nome, Integer numApto, Integer numBloco, Date mesVigente,
			Date dataVencimento, Date dataPagamento, Double valorPago) {
		super();
		this.nome = nome;
		this.numApto = numApto;
		this.numBloco = numBloco;
		this.mesVigente = mesVigente;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.valorPago = valorPago;
	}

	public String getNome() {
		return nome;
	}

	public Integer getNumApto() {
		return numApto;
	}

	public Integer getNumBloco() {
		return numBloco;
	}

	public String getMesVigente() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(mesVigente);
		String ano = "/" + cal.get(Calendar.YEAR);
		String mes = ((cal.get(Calendar.MONTH) + 1) < 10) ? "0" + (cal.get(Calendar.MONTH) + 1)
				: "" + (cal.get(Calendar.MONTH) + 1);
		String data = mes + ano;
		return data;
	}

	public String getDataVencimento() {
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataVencimento);
		return data;
	}

	public String getDataPagamento() {
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataPagamento);
		return data;
	}

	public Double getValorPago() {
		return valorPago;
	}
}
