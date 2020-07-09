package condo.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {
	protected String nome;
	protected String cpf;
	protected String rg;
	protected Date datanasc;
	protected String email;
	protected String telefone;
	protected String telefoneCelular;
	protected String nomeUsuario;
	protected String senha;
	protected Boolean proprietario;
	protected Permissao permissao;

	public Pessoa(String nome, String cpf, String rg, Date datanasc, String email, String telefone,
			String telefoneCelular, String nomeUsuario, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.datanasc = datanasc;
		this.email = email;
		this.telefone = telefone;
		this.telefoneCelular = telefoneCelular;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
	}

	public Pessoa(String nome, String cpf, String rg, Date datanasc, String email, String telefone,
			String telefoneCelular, String nomeUsuario, String senha, Boolean proprietario, Permissao permissao) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.datanasc = datanasc;
		this.email = email;
		this.telefone = telefone;
		this.telefoneCelular = telefoneCelular;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.proprietario = proprietario;
		this.permissao = permissao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDatanasc() {
		String data = new SimpleDateFormat("dd/MM/yyyy").format(datanasc);
		return data;
	}

	public String getDatanascCriarEditar() {
		String data = new SimpleDateFormat("yyyy-MM-dd").format(datanasc);
		return data;
	}

	public void setDatanasc(Date datanasc) {
		this.datanasc = datanasc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getProprietario() {
		return proprietario;
	}

	public void setProprietario(Boolean proprietario) {
		this.proprietario = proprietario;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}
}
