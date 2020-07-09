package condo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import condo.entities.ContaAReceber;
import condo.entities.Imovel;
import condo.entities.Informativo;
import condo.entities.Perfil;
import condo.entities.Permissao;
import condo.entities.Pessoa;
import condo.entities.RelatorioInformativo;
import condo.entities.sindico.ContaAReceberCompleto;
import condo.entities.sindico.ImovelCompleto;
import condo.entities.sindico.InformativoCompleto;
import condo.entities.sindico.PessoaCom;
import condo.entities.sindico.PessoaSimp;
import condo.entities.sindico.RelatorioContaAReceber;
import condo.entities.sindico.RelatorioContaRecebidaArrecadacaoPeriodo;
import condo.entities.sindico.RelatorioImovel;
import condo.entities.sindico.RelatorioPessoa;

public class SindicoDAO {
	// RELATÓRIOS
	public List<RelatorioContaAReceber> emitirRelatorioContaAReceber(String datainicial, String datafinal) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		List<RelatorioContaAReceber> listaRelatorio = new ArrayList<>();
		try {
			stmt = con.createStatement();
			String sql = "Select p.nome, i.numero_apto, c.data_referencia, c.data_vencimento, c.valor "
					+ "from Pessoa p, Imovel i, ContaAReceber c "
					+ "where p.id_pessoa=i.id_condomino and i.id_imovel=c.id_imovel "
					+ "and c.data_referencia between '" + datainicial + "' and '" + datafinal
					+ "' and c.data_pagamento is null";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				listaRelatorio.add(new RelatorioContaAReceber(rs.getString("p.nome"), rs.getInt("i.numero_apto"),
						rs.getDate("c.data_referencia"), rs.getDate("c.data_vencimento"), rs.getDouble("c.valor")));
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

	public List<RelatorioPessoa> emitirRelatorioPessoa() {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		List<RelatorioPessoa> listaRelatorio = new ArrayList<>();
		try {
			stmt = con.createStatement();
			String sql = "SELECT Pessoa.Nome, Pessoa.cpf, Pessoa.rg, Pessoa.data_nasc, Pessoa.email, Pessoa.telefone, Perfil.descricao "
					+ "FROM Pessoa INNER JOIN Permissao ON Permissao.id_pessoa = Pessoa.id_pessoa INNER JOIN Perfil ON Permissao.id_perfil = Perfil.id_perfil order by Pessoa.nome ASC";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				listaRelatorio.add(new RelatorioPessoa(rs.getString("Pessoa.Nome"), rs.getString("Pessoa.cpf"),
						rs.getInt("Pessoa.rg"), rs.getDate("Pessoa.data_nasc"), rs.getString("Pessoa.email"),
						rs.getString("Pessoa.telefone"), rs.getString("Perfil.descricao")));
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

	public List<RelatorioContaRecebidaArrecadacaoPeriodo> emitirRelatorioContaRecebidaArrecadacaoPeriodo(
			String datainicial, String datafinal) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		List<RelatorioContaRecebidaArrecadacaoPeriodo> listaRelatorio = new ArrayList<>();
		try {
			stmt = con.createStatement();
			String sql = "SELECT IM.numero_bloco, IM.numero_apto, PS.nome, " + "CR.data_referencia AS 'Referência', "
					+ "CR.data_vencimento AS 'Vencimento', " + "CR.data_pagamento AS 'Data_Pagamento', "
					+ "CR.valor_pago FROM ContaAReceber CR INNER JOIN Imovel "
					+ "AS IM ON (IM.id_imovel = CR.id_imovel) INNER JOIN Pessoa AS PS ON (PS.id_pessoa = IM.id_condomino) "
					+ "WHERE CR.data_pagamento between '" + datainicial + "' and '" + datafinal + "'"
					+ " and CR.data_pagamento is not null;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				listaRelatorio.add(new RelatorioContaRecebidaArrecadacaoPeriodo(rs.getString("PS.nome"),
						rs.getInt("IM.numero_apto"), rs.getInt("IM.numero_bloco"), rs.getDate("Referência"),
						rs.getDate("Vencimento"), rs.getDate("Data_Pagamento"), rs.getDouble("CR.valor_pago")));
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

	public List<RelatorioImovel> emitirRelatorioImovel() {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		List<RelatorioImovel> listaRelatorio = new ArrayList<>();
		try {
			stmt = con.createStatement();
			String sql = "select ppr.nome, p.nome, i.numero_bloco, i.numero_apto "
					+ "from Pessoa p, Imovel i, Proprietario pr, Pessoa ppr "
					+ "where p.id_pessoa=i.id_condomino and pr.id_proprietario=i.id_proprietario and pr.id_pessoa=ppr.id_pessoa"
					+ " order by  i.numero_bloco asc,  i.numero_apto asc;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				listaRelatorio.add(new RelatorioImovel(rs.getString("ppr.nome"), rs.getString("p.nome"),
						rs.getInt("i.numero_bloco"), rs.getInt("i.numero_apto")));
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

	public List<RelatorioInformativo> emitirRelatorioInformativo(String datainicial, String datafinal) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		List<RelatorioInformativo> listaRelatorio = new ArrayList<>();
		try {
			stmt = con.createStatement();
			String sql = "SELECT i.assunto, i.conteudo, i.data_info " + "FROM Informativo i WHERE "
					+ "i.data_info between '" + datainicial + "' and '" + datafinal + "' order by data_info asc;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				listaRelatorio.add(new RelatorioInformativo(rs.getString("i.assunto"), rs.getString("i.conteudo"),
						rs.getDate("i.data_info")));
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

	// CRUD Informativo
	// - CRIAR
	// - EDITAR
	// - EXCLUIR
	// - CANCELAR/EXCLUIR ENVIO PARA TODOS / PARA UM
	// - ENVIAR PARA TODOS / PARA UM
	// - LISTAR TODOS
	public void cadastrarInformativo(Informativo info) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "insert into Informativo (assunto, conteudo, data_info) values ('" + info.getAssuntoInfo()
					+ "','" + info.getConteudoInfo() + "','" + info.getDataInfo() + "');";
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

	public void editarInformativo(Informativo info, int id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "update Informativo" + " set " + "assunto = '" + info.getAssuntoInfo() + "'," + " conteudo ='"
					+ info.getConteudoInfo() + "'," + " data_info = '" + info.getDataInfo() + "'"
					+ " where id_informativo = " + id;
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

	public void excluirInformativo(int id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "delete from Informativo where id_informativo=" + id;
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

	public void cancelarEnvioInformativoParaTodos(int id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "delete from RecebeInformativo where id_informativo=" + id;
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

	public void cancelarEnvioInformativoParaUm(int id_bloco, int id_apto, int id_info) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "delete from RecebeInformativo where id_imovel in (Select id_imovel from Imovel where numero_apto="
					+ id_apto + " and numero_bloco=" + id_bloco + ") and  id_informativo=" + id_info + ";";
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

	public void enviarInformativoParaTodos(int id_info) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "insert into RecebeInformativo(id_imovel, id_informativo) " + "select id_imovel," + id_info
					+ " from Imovel;";
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

	public void enviarInformativoParaUm(int id_bloco, int id_apto, int id_info) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "insert into RecebeInformativo (id_imovel, id_informativo) " + "Select id_imovel, " + id_info
					+ " from Imovel where numero_apto=" + id_apto + " and numero_bloco=" + id_bloco + ";";
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

	public List<InformativoCompleto> listarInformativo() {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		List<InformativoCompleto> info = new ArrayList<>();
		try {
			stmt = con.createStatement();
			String sql = "select * from Informativo order by data_info asc;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				info.add(new InformativoCompleto(rs.getString("assunto"), rs.getString("conteudo"),
						rs.getDate("data_info"), rs.getInt("id_informativo")));
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
		return info;
	}

	// CRUD Imovel
	// - CRIAR
	// - EDITAR
	// - EXCLUIR
	// - EXCLUIR PROPRIETARIO
	// - EXCLUIR CONDOMINO
	// - EDITAR PROPRIETARIO
	// - EDITAR CONDOMINO
	// - INSERIR PROPRIETARIO
	// - INSERIR CONDOMINO
	// - LISTAR TODOS
	public void cadastrarImovel(Imovel imovel) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "insert into Imovel (numero_apto, numero_bloco) values (" + imovel.getNumeroApto() + ","
					+ imovel.getNumeroBloco() + ");";
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

	public void editarImovel(Imovel imovel, int id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "update Imovel" + " set " + "numero_apto = " + imovel.getNumeroApto() + "," + " numero_bloco ="
					+ imovel.getNumeroBloco() + " where id_imovel = " + id;
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

	public void excluirImovel(int id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql1 = "delete from Imovel where id_imovel=" + id;
			String sql2 = "delete from RecebeInformativo where id_imovel=" + id;
			String sql3 = "delete from ContaAReceber where id_imovel=" + id;
			stmt.executeUpdate(sql3);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql1);
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

	public void excluirProprietarioImovel(int id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "update Imovel set id_proprietario = " + null + " where id_imovel = " + id;
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

	public void excluirCondominoImovel(int id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "update Imovel set id_condomino = " + null + " where id_imovel=" + id + ";";
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

	public void editarOUinserirProprietarioImovel(int id, int id_proprietario) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "update Imovel set id_proprietario = " + id_proprietario + " where id_imovel = " + id;
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

	public void editarOUinserirCondominoImovel(int id, int id_condomino) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "update Imovel set id_condomino = " + id_condomino + " where id_imovel=" + id + ";";
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

	public List<ImovelCompleto> listarImovel() {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		List<ImovelCompleto> imovel = new ArrayList<>();
		try {
			stmt = con.createStatement();
			String sql = "select ppr.nome nomeProprietario, p.nome nomeCondomino, i.numero_bloco, i.numero_apto, i.id_imovel, i.id_proprietario, i.id_condomino\r\n"
					+ "from Pessoa p right join Imovel i on p.id_pessoa=i.id_condomino\r\n"
					+ "left join Proprietario pr on pr.id_proprietario=i.id_proprietario \r\n"
					+ "left join Pessoa ppr on pr.id_pessoa=ppr.id_pessoa\r\n"
					+ "order by  i.numero_bloco asc,  i.numero_apto asc;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				imovel.add(new ImovelCompleto(rs.getInt("i.numero_bloco"), rs.getInt("i.numero_apto"),
						rs.getInt("i.id_imovel"), rs.getInt("i.id_proprietario"), rs.getString("nomeProprietario"),
						rs.getInt("i.id_condomino"), rs.getString("nomeCondomino")));
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
		return imovel;
	}

	// CRUD Conta a receber
	// - CRIAR
	// - EDITAR
	// - EDITAR DATA VENCIMENTO TODOS
	// - EDITAR DATA VENCIMENTO UM
	// - EXCLUIR PELO ID
	// - EXCLUIR PELA DATA VENCIMENTO
	// - ATUALIZAR DATA PAGAMENTO, VALOR PAGO, DATA REFERÊNCIA PARA TODOS
	// - ATUALIZAR DATA PAGAMENTO, VALOR PAGO, DATA REFERÊNCIA PARA UM
	// - LISTAR TODOS
	public void cadastrarContaAReceber(ContaAReceber cr) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "insert into ContaAReceber(data_vencimento, valor, valor_pago, data_pagamento, data_referencia, id_imovel) select "
					+ "'" + cr.getDataVencimento() + "', " + cr.getValor()
					+ ", null, null, current_date(), i.id_imovel from Imovel i, Pessoa p Where i.id_condomino=p.id_pessoa;";
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

	public void editarContaAReceber(ContaAReceber cr, String dataVencimento) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "update ContaAReceber set data_vencimento='" + cr.getDataVencimento() + "', " + "valor="
					+ cr.getValor() + " where data_vencimento='" + dataVencimento + "';";
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

	public void editarDataVencimentoContaTodos(String dataVencimentoAntiga, String dataVencimentoNova) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "update ContaAReceber set data_vencimento='" + dataVencimentoNova + "' where data_vencimento='"
					+ dataVencimentoAntiga + "';";
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

	public void editarDataVencimentoContaUm(String dataVencimentoAntiga, String dataVencimentoNova, int numBloco,
			int numApto) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "update ContaAReceber set data_vencimento='" + dataVencimentoNova + "' where data_vencimento='"
					+ dataVencimentoAntiga + "' and id_imovel in (select id_imovel from Imovel where numero_apto="
					+ numApto + " and numero_bloco=" + numBloco + ");";
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

	public void excluirContaAReceberPeloID(int id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "delete from ContaAReceber where id_contaareceber=" + id;
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

	public void excluirContaAReceberPelaDataVencimento(String dataVencimento) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "delete from ContaAReceber where data_vencimento='" + dataVencimento
					+ "' and id_imovel in (select id_imovel from Imovel);";
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

	public void atualizarDataPagamentoValorPagoDataReferenciaContaAReceberParaTodos(String dataPagamento,
			Double valorPago, String dataVencimento) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "update ContaAReceber set data_pagamento='" + dataPagamento + "', valor_pago=" + valorPago
					+ ", data_referencia=current_date() where data_vencimento='" + dataVencimento + "';";
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

	public void atualizarDataPagamentoValorPagoDataReferenciaContaAReceberParaUM(String dataPagamento, Double valorPago,
			String dataVencimento, int numBloco, int numApto) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "update ContaAReceber set data_pagamento='" + dataPagamento + "', valor_pago=" + valorPago
					+ ", data_referencia=current_date() where data_vencimento='" + dataVencimento + "' and "
					+ "id_imovel in (select id_imovel from Imovel where numero_apto=" + numApto + " and numero_bloco="
					+ numBloco + ");;";
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

	public List<ContaAReceberCompleto> listarContaAReceber() {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		List<ContaAReceberCompleto> cr = new ArrayList<>();
		try {
			stmt = con.createStatement();
			String sql = "Select cr.data_vencimento, cr.valor, cr.id_contaareceber, cr.valor_pago, cr.data_pagamento, cr.data_referencia, cr.id_imovel, i.id_condomino, p.nome "
					+ "from ContaAReceber cr, Imovel i, Pessoa p "
					+ "where cr.id_imovel=i.id_imovel and i.id_condomino=p.id_pessoa " + "order by cr.data_vencimento;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				cr.add(new ContaAReceberCompleto(rs.getDate("cr.data_vencimento"), rs.getDouble("cr.valor"),
						rs.getInt("cr.id_contaareceber"), rs.getInt("cr.id_imovel"), rs.getInt("i.id_condomino"),
						rs.getString("p.nome"), rs.getDouble("cr.valor_pago"), rs.getDate("cr.data_pagamento"),
						rs.getDate("cr.data_referencia")));
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
		return cr;
	}

	// CRUD PESSOA(CONDOMINO/SINDICO)
	// - CRIAR
	// - EDITAR
	// - EXCLUIR
	// - ALTERAR SENHA
	// - BUSCAR - (nomeUsuario, senha)
	// - LISTAR TODOS
	public void criarPessoa(Pessoa pessoa, int id_perfil) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql1 = "insert into Pessoa(nome, cpf, rg, data_nasc, email, telefone, telefone_celular, nome_usuario, senha, proprietario) values "
					+ "('" + pessoa.getNome() + "', '" + pessoa.getCpf() + "', '" + pessoa.getRg() + "', '"
					+ pessoa.getDatanascCriarEditar() + "', '" + pessoa.getEmail() + "', '" + pessoa.getTelefone()
					+ "', '" + pessoa.getTelefoneCelular() + "', '" + pessoa.getNomeUsuario() + "', '"
					+ pessoa.getSenha() + "', " + pessoa.getProprietario() + ");";
			String sql2 = "insert into Permissao(pstatus, pdata, id_pessoa, id_perfil) " + "select "
					+ pessoa.getPermissao().getStatus() + ", current_date(), id_pessoa, " + id_perfil
					+ " from Pessoa where id_pessoa in (select id_pessoa from pessoa where cpf='" + pessoa.getCpf()
					+ "');";
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
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

	public void editarPessoa(Pessoa pessoa, int id, int id_perfil) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql1 = "update Pessoa set " + "nome='" + pessoa.getNome() + "', " + "cpf='" + pessoa.getCpf() + "', "
					+ "rg='" + pessoa.getRg() + "', " + "data_nasc='" + pessoa.getDatanascCriarEditar() + "', "
					+ "email='" + pessoa.getEmail() + "', " + "telefone='" + pessoa.getTelefone() + "', "
					+ "telefone_celular='" + pessoa.getTelefoneCelular() + "', " + "nome_usuario='"
					+ pessoa.getNomeUsuario() + "', " + "senha='" + pessoa.getSenha() + "', " + "proprietario="
					+ pessoa.getProprietario() + " where id_pessoa=" + id + ";";
			String sql2 = "update Permissao set " + "pstatus=" + pessoa.getPermissao().getStatus() + ", "
					+ "pdata=current_date(), " + "id_perfil=" + id_perfil + " where id_pessoa=" + id + ";";
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
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

	public void excluirPessoa(int id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "delete from Permissao where id_pessoa=" + id + ";";
			String sql1 = "update Imovel set id_condomino=null where id_condomino=" + id + ";";
			String sql2 = "update Imovel set id_proprietario=null where id_proprietario in (Select pr.id_proprietario from Pessoa p, Proprietario pr where pr.id_pessoa="
					+ id + ");";
			String sql3 = "delete from Proprietario where id_pessoa=" + id + ";";
			String sql4 = "delete from Pessoa where id_pessoa=" + id + ";";
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);
			stmt.executeUpdate(sql4);
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

	public PessoaSimp buscarPessoa(String nomeUsuarioEmail, String senha) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		PessoaSimp ps = null;
		try {
			stmt = con.createStatement();
			String sql = "Select p.id_pessoa, p.nome, perf.descricao, perm.pstatus from Pessoa p, Permissao perm, Perfil perf "
					+ "Where p.id_pessoa=perm.id_pessoa and perm.id_perfil=perf.id_perfil " + "and (p.email='"
					+ nomeUsuarioEmail + "' || p.nome_usuario='" + nomeUsuarioEmail + "') and p.senha='" + senha + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ps = new PessoaSimp(rs.getInt("p.id_pessoa"), rs.getString("p.nome"), rs.getString("perf.descricao"),
						rs.getBoolean("perm.pstatus"));
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
		return ps;
	}

	public void alterarSenhaPessoa(String senhaNova, int id) {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "update Pessoa set senha='" + senhaNova + "' where id_pessoa=" + id;
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

	public List<PessoaCom> listarPessoa() {
		Connection con = FabricaDeConexoes.getConnection();
		Statement stmt = null;
		List<PessoaCom> pessoas = new ArrayList<>();
		try {
			stmt = con.createStatement();
			String sql = "Select p.id_pessoa, p.nome, p.cpf, p.rg, p.data_nasc, p.email, p.telefone, p.telefone_celular, "
					+ "p.nome_usuario, p.senha, p.proprietario, perm.id_permissao, perm.pstatus, perm.pdata, perf.id_perfil, "
					+ "perf.descricao From Pessoa p, Permissao perm, Perfil perf "
					+ "Where p.id_pessoa=perm.id_pessoa and perm.id_perfil=perf.id_perfil order by p.nome;";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				pessoas.add(new PessoaCom(rs.getString("p.nome"), rs.getString("p.cpf"), rs.getString("p.rg"),
						rs.getDate("p.data_nasc"), rs.getString("p.email"), rs.getString("p.telefone"),
						rs.getString("p.telefone_celular"), rs.getString("p.nome_usuario"), rs.getString("p.senha"),
						rs.getBoolean("p.proprietario"),
						new Permissao(new Perfil(rs.getString("perf.descricao")), rs.getDate("perm.pdata"),
								rs.getBoolean("perm.pstatus")),
						rs.getInt("p.id_pessoa"), rs.getInt("perm.id_permissao"), rs.getInt("perf.id_perfil")));
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
		return pessoas;
	}
}
