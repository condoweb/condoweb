package condo.tarefa.sindico.imovel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.entities.Imovel;
import condo.tarefa.Tarefa;

public class InserirEditarProprietarioImovel implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id_imovel = Integer.parseInt(request.getParameter("id_imovel"));
		int id_proprietario = Integer.parseInt(request.getParameter("id_proprietario"));
		new SindicoDAO().editarOUinserirProprietarioImovel(id_imovel, id_proprietario);
		request.setAttribute("msg", "Proprietário inserido/editado com sucesso");
		return "resp";
	}
}
