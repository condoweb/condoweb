package condo.entities.sindico;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RelatorioPessoa {
	public String nome;
	public String cpf;
	public Integer rg;
	public Date dataNasc;
	public String email;
	public String telefone;
	public String perfil;

	public RelatorioPessoa(String nome, String cpf, Integer rg, Date dataNasc, String email, String telefone,
			String perfil) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNasc = dataNasc;
		this.email = email;
		this.telefone = telefone;
		this.perfil = perfil;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public Integer getRg() {
		return rg;
	}

	public String getDataNasc() {
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataNasc);
		return data;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getPerfil() {
		return perfil;
	}
}
