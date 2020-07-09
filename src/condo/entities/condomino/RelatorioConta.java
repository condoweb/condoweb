package condo.entities.condomino;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RelatorioConta {
	public Double valor;
	public Double valorPago;
	public Date dataReferencia;
	public Date dataVencimento;

	public RelatorioConta(Double valor, Double valorPago, Date dataReferencia, Date dataVencimento) {
		super();
		this.valor = valor;
		this.valorPago = valorPago;
		this.dataReferencia = dataReferencia;
		this.dataVencimento = dataVencimento;
	}

	public Double getValor() {
		return valor;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public String getDataReferencia() {
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataReferencia);
		return data;
	}

	public String getDataVencimento() {
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataVencimento);
		return data;
	}
}
