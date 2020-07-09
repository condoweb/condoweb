package condo.entities.sindico;

public class PessoaSimp {
	public Integer id;
	public String nome;
	public String perfil;
	public Boolean status;

	public PessoaSimp(Integer id, String nome, String perfil, Boolean status) {
		super();
		this.id = id;
		this.nome = nome;
		this.perfil = perfil;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getPerfil() {
		return perfil;
	}

	public Boolean getStatus() {
		return status;
	}
}
