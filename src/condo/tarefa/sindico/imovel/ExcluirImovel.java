package condo.tarefa.sindico.imovel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.tarefa.Tarefa;

public class ExcluirImovel implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id_imovel = Integer.parseInt(request.getParameter("id_imovel"));
		new SindicoDAO().excluirImovel(id_imovel);
		request.setAttribute("msg", "Imovel excluído com sucesso");
		return "resp";
	}
}
