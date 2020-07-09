package condo.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Permissao {
	protected Perfil perfil;
	protected Date dataperm;
	protected Boolean status;

	public Permissao(Perfil perfil, Date dataperm, Boolean status) {
		super();
		this.perfil = perfil;
		this.dataperm = dataperm;
		this.status = status;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getDataperm() {
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataperm);
		return data;
	}

	public void setDataperm(Date dataperm) {
		this.dataperm = dataperm;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
