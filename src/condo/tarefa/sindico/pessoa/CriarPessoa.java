package condo.tarefa.sindico.pessoa;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.entities.Perfil;
import condo.entities.Permissao;
import condo.entities.Pessoa;
import condo.tarefa.Tarefa;

public class CriarPessoa implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String rg = request.getParameter("rg");

		String data = request.getParameter("data_nasc");
		SimpleDateFormat sdf1 = new SimpleDateFormat("y-MM-dd");
		Date datanasc = sdf1.parse(data);

		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String telefonecelular = request.getParameter("telefone_celular");
		String nomeusuario = request.getParameter("nome_usuario");
		String senha = request.getParameter("senha");

		Boolean proprietario = (request.getParameter("proprietario") != null) ? true : false;
		Boolean statusperfil = (request.getParameter("statusperfil") != null) ? true : false;

		String descPerf = (request.getParameter("sindico") != null) ? "Sindico" : "Condomino";
		int id_perfil = (descPerf.equals("Condomino")) ? 1 : 2;

		Pessoa pessoa = new Pessoa(nome, cpf, rg, datanasc, email, telefone, telefonecelular, nomeusuario, senha,
				proprietario, new Permissao(new Perfil(descPerf), null, statusperfil));

		new SindicoDAO().criarPessoa(pessoa, id_perfil);
		request.setAttribute("msg", "Pessoa criada com sucesso");
		return "resp";
	}
}
