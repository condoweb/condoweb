package condo.tarefa.sindico.contaareceber;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.tarefa.Tarefa;

public class ExcluirContaAReceberPeloID implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		new SindicoDAO().excluirContaAReceberPeloID(id);
		request.setAttribute("msg", "Conta a Receber excluída com sucesso");
		return "resp";
	}
}