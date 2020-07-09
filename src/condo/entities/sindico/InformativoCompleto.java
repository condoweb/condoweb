package condo.entities.sindico;

import java.util.Date;

import condo.entities.Informativo;

public class InformativoCompleto extends Informativo {
	public Integer id;

	public InformativoCompleto(String assuntoInfo, String conteudoInfo, Date dataInfo, Integer id) {
		super(assuntoInfo, conteudoInfo, dataInfo);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
