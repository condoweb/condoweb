package condo.entities;

public class Imovel {
	protected Integer numeroBloco;
	protected Integer numeroApto;

	public Imovel(Integer numeroBloco, Integer numeroApto) {
		super();
		this.numeroBloco = numeroBloco;
		this.numeroApto = numeroApto;
	}

	public Integer getNumeroBloco() {
		return numeroBloco;
	}

	public void setNumeroBloco(Integer numeroBloco) {
		this.numeroBloco = numeroBloco;
	}

	public Integer getNumeroApto() {
		return numeroApto;
	}

	public void setNumeroApto(Integer numeroApto) {
		this.numeroApto = numeroApto;
	}
}
