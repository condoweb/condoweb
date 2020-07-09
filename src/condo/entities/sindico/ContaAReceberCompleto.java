package condo.entities.sindico;

import java.text.SimpleDateFormat;
import java.util.Date;

import condo.entities.ContaAReceber;

public class ContaAReceberCompleto extends ContaAReceber {
	public Integer id_contaareceber;
	public Integer id_imovel;
	public Integer id_condomino;
	public String nomeResponsavel;
	public Double valorPago;
	public Date dataPagamento;
	public Date dataReferencia;

	public ContaAReceberCompleto(Date dataVencimento, Double valor, Integer id_contaareceber, Integer id_imovel,
			Integer id_condomino, String nomeResponsavel, Double valorPago, Date dataPagamento, Date dataReferencia) {
		super(dataVencimento, valor);
		this.id_contaareceber = id_contaareceber;
		this.id_imovel = id_imovel;
		this.id_condomino = id_condomino;
		this.nomeResponsavel = nomeResponsavel;
		this.valorPago = valorPago;
		this.dataPagamento = dataPagamento;
		this.dataReferencia = dataReferencia;
	}

	public Integer getId_contaareceber() {
		return id_contaareceber;
	}

	public Integer getId_imovel() {
		return id_imovel;
	}

	public Integer getId_condomino() {
		return id_condomino;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public String getDataPagamento() {
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataPagamento);
		return data;
	}

	public String getDataReferencia() {
		String data = new SimpleDateFormat("MM/yyyy").format(dataReferencia);
		return data;
	}
}
