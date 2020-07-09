package condo.tarefa.sindico.pessoa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.tarefa.Tarefa;

public class AlterarSenhaPessoa implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String novaSenha = request.getParameter("novasenha");
		int id = Integer.parseInt(request.getParameter("id_pessoa"));
		new SindicoDAO().alterarSenhaPessoa(novaSenha, id);
		request.setAttribute("msg", "Senha editada com sucesso");
		return "resp";
	}
}
