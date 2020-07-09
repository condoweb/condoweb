package condo.entities.sindico;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RelatorioContaAReceber {
	public String nomeResponsavel;
	public Integer numApto;
	public Date dataReferencia;
	public Date dataVencimento;
	public Double valor;

	public RelatorioContaAReceber(String nomeResponsavel, Integer numApto, Date dataReferencia, Date dataVencimento,
			Double valor) {
		super();
		this.nomeResponsavel = nomeResponsavel;
		this.numApto = numApto;
		this.dataReferencia = dataReferencia;
		this.dataVencimento = dataVencimento;
		this.valor = valor;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public Integer getNumApto() {
		return numApto;
	}

	public String getDataReferencia() throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataReferencia);
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

	public Double getValor() {
		return valor;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
}
