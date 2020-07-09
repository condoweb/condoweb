package condo.tarefa.sindico.imovel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.tarefa.Tarefa;

public class InserirEditarCondominoImovel implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id_imovel = Integer.parseInt(request.getParameter("id_imovel"));
		int id_condomino = Integer.parseInt(request.getParameter("id_condomino"));
		new SindicoDAO().editarOUinserirCondominoImovel(id_imovel, id_condomino);
		request.setAttribute("msg", "Condômino inserido/editado com sucesso");
		return "resp";
	}
}
