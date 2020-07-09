package condo.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ContaAReceber {
	protected Date dataVencimento;
	protected Double valor;

	public ContaAReceber(Date dataVencimento, Double valor) {
		super();
		this.dataVencimento = dataVencimento;
		this.valor = valor;
	}

	public String getDataVencimento() {
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataVencimento);
		return data;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
