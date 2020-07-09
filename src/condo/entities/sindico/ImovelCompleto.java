package condo.entities.sindico;

import condo.entities.Imovel;

public class ImovelCompleto extends Imovel {
	public Integer id_imovel;
	public Integer id_proprietario;
	public String proprietario;
	public Integer id_condomino;
	public String condomino;

	public ImovelCompleto(Integer numeroBloco, Integer numeroApto, Integer id_imovel, Integer id_proprietario,
			String proprietario, Integer id_condomino, String condomino) {
		super(numeroBloco, numeroApto);
		this.id_imovel = id_imovel;
		this.id_proprietario = id_proprietario;
		this.proprietario = proprietario;
		this.id_condomino = id_condomino;
		this.condomino = condomino;
	}

	public Integer getId_imovel() {
		return id_imovel;
	}

	public Integer getId_proprietario() {
		return id_proprietario;
	}

	public String getProprietario() {
		return proprietario;
	}

	public Integer getId_condomino() {
		return id_condomino;
	}

	public String getCondomino() {
		return condomino;
	}
}
