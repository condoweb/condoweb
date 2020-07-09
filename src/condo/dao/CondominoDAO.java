package condo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import condo.entities.Pessoa;
import condo.entities.RelatorioInformativo;
import condo.entities.condomino.RelatorioConta;
import condo.entities.sindico.PessoaCom;
import condo.entities.sindico.PessoaSimp;

public class CondominoDAO {
	public List<RelatorioConta> emitirRelatorioContaVencer(String id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		List<RelatorioConta> listaRelatorio = new ArrayList<>();
		try {
			stmt = con.createStatement();
			String sql = "Select c.valor, c.valor_pago, c.data_referencia, c.data_vencimento "
					+ "from Imovel i, ContaAReceber c " + "where " + id + "=i.id_condomino and "
					+ "i.id_imovel=c.id_imovel and " + "c.data_pagamento is null;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				listaRelatorio.add(new RelatorioConta(rs.getDouble("c.valor"), rs.getDouble("c.valor_pago"),
						rs.getDate("c.data_referencia"), rs.getDate("c.data_vencimento")));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
		return listaRelatorio;
	}

	public List<RelatorioConta> emitirRelatorioContaPaga(String id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		List<RelatorioConta> listaRelatorio = new ArrayList<>();
		try {
			stmt = con.createStatement();
			String sql = "Select c.valor, c.valor_pago, c.data_referencia, c.data_vencimento "
					+ "from Imovel i, ContaAReceber c " + "where " + id + "=i.id_condomino and "
					+ "i.id_imovel=c.id_imovel and " + "c.data_pagamento is not null;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				listaRelatorio.add(new RelatorioConta(rs.getDouble("c.valor"), rs.getDouble("c.valor_pago"),
						rs.getDate("c.data_referencia"), rs.getDate("c.data_vencimento")));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
		return listaRelatorio;
	}

	public List<RelatorioInformativo> emitirRelatorioInformativo(String id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		List<RelatorioInformativo> listaRelatorio = new ArrayList<>();
		try {
			stmt = con.createStatement();
			String sql = "select info.assunto, info.conteudo, info.data_info "
					+ "from Imovel i, Informativo info, RecebeInformativo ref " + "where i.id_condomino=" + id + " and "
					+ "i.id_imovel=ref.id_imovel and " + "ref.id_informativo=info.id_informativo "
					+ "order by info.data_info;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				listaRelatorio.add(new RelatorioInformativo(rs.getString("info.assunto"), rs.getString("info.conteudo"),
						rs.getDate("info.data_info")));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
		return listaRelatorio;
	}

	public void EditarDadosCondomino(Pessoa pessoa, int id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "update Pessoa set " + "nome='" + pessoa.getNome() + "', " + "cpf='" + pessoa.getCpf() + "', "
					+ "rg='" + pessoa.getRg() + "', " + "data_nasc='" + pessoa.getDatanascCriarEditar() + "', "
					+ "email='" + pessoa.getEmail() + "', " + "telefone='" + pessoa.getTelefone() + "', "
					+ "telefone_celular='" + pessoa.getTelefoneCelular() + "', " + "nome_usuario='"
					+ pessoa.getNomeUsuario() + "', " + "senha='" + pessoa.getSenha() + "' where id_pessoa=" + id + ";";
			stmt.executeUpdate(sql);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
	}

	public Pessoa listarDadosPessoa(int id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		Pessoa pessoa = null;
		try {
			stmt = con.createStatement();
			String sql = "Select p.nome, p.cpf, p.rg, p.data_nasc, p.email, p.telefone, p.telefone_celular, p.nome_usuario, p.senha "
					+ "from Pessoa p where p.id_pessoa=" + id + ";";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				pessoa = new Pessoa(rs.getString("p.nome"), rs.getString("p.cpf"), rs.getString("p.rg"),
						rs.getDate("p.data_nasc"), rs.getString("p.email"), rs.getString("p.telefone"),
						rs.getString("p.telefone_celular"), rs.getString("p.nome_usuario"), rs.getString("p.senha"));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
		return pessoa;
	}
}
