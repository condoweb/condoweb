package condo.tarefa.sindico.pessoa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.tarefa.Tarefa;

public class ExcluirPessoa implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id_pessoa"));
		new SindicoDAO().excluirPessoa(id);
		request.setAttribute("msg", "Pessoa excluída com sucesso");
		return "resp";
	}
}
