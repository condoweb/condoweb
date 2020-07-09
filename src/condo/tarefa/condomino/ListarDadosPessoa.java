package condo.tarefa.condomino;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.CondominoDAO;
import condo.entities.Pessoa;
import condo.tarefa.Tarefa;

public class ListarDadosPessoa implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id_pessoa = Integer.parseInt(request.getParameter("id_pessoa"));
		Pessoa pessoa = new CondominoDAO().listarDadosPessoa(id_pessoa);
		request.setAttribute("pessoa", pessoa);
		return "dadospessoa";
	}
}
