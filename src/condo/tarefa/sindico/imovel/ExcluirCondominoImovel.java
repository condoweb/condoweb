package condo.tarefa.sindico.imovel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.tarefa.Tarefa;

public class ExcluirCondominoImovel implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id_imovel = Integer.parseInt(request.getParameter("id_imovel"));
		new SindicoDAO().excluirCondominoImovel(id_imovel);
		request.setAttribute("msg", "Condômino do Imóvel excluído com sucesso");
		return "resp";
	}
}
