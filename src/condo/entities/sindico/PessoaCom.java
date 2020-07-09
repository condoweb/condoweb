package condo.entities.sindico;

import java.util.Date;

import condo.entities.Permissao;
import condo.entities.Pessoa;

public class PessoaCom extends Pessoa {
	protected Integer id_pessoa;
	protected Integer id_permissao;
	protected Integer id_perfil;

	public PessoaCom(String nome, String cpf, String rg, Date datanasc, String email, String telefone,
			String telefoneCelular, String nomeUsuario, String senha, Boolean proprietario, Permissao permissao,
			Integer id_pessoa, Integer id_permissao, Integer id_perfil) {
		super(nome, cpf, rg, datanasc, email, telefone, telefoneCelular, nomeUsuario, senha, proprietario, permissao);
		this.id_pessoa = id_pessoa;
		this.id_permissao = id_permissao;
		this.id_perfil = id_perfil;
	}

	public Integer getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(Integer id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	public Integer getId_permissao() {
		return id_permissao;
	}

	public void setId_permissao(Integer id_permissao) {
		this.id_permissao = id_permissao;
	}

	public Integer getId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(Integer id_perfil) {
		this.id_perfil = id_perfil;
	}
}
