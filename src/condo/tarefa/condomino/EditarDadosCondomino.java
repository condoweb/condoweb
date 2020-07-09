package condo.tarefa.condomino;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.CondominoDAO;
import condo.entities.Pessoa;
import condo.tarefa.Tarefa;

public class EditarDadosCondomino implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id_pessoa = Integer.parseInt(request.getParameter("id_pessoa"));
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

		Pessoa pessoa = new Pessoa(nome, cpf, rg, datanasc, email, telefone, telefonecelular, nomeusuario, senha);

		new CondominoDAO().EditarDadosCondomino(pessoa, id_pessoa);
		request.setAttribute("msg", "Dados editados com sucesso");
		return "resp";
	}
}
