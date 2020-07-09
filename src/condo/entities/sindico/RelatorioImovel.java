package condo.entities.sindico;

public class RelatorioImovel {
	public String proprietario;
	public String condomino;
	public Integer bloco;
	public Integer apartamento;

	public RelatorioImovel(String proprietario, String condomino, Integer bloco, Integer apartamento) {
		super();
		this.proprietario = proprietario;
		this.condomino = condomino;
		this.bloco = bloco;
		this.apartamento = apartamento;
	}

	public String getProprietario() {
		return proprietario;
	}

	public String getCondomino() {
		return condomino;
	}

	public Integer getBloco() {
		return bloco;
	}

	public Integer getApartamento() {
		return apartamento;
	}
}
