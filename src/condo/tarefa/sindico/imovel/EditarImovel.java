package condo.tarefa.sindico.imovel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.entities.Imovel;
import condo.tarefa.Tarefa;

public class EditarImovel implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id_bloco = Integer.parseInt(request.getParameter("id_bloco"));
		int id_apto = Integer.parseInt(request.getParameter("id_apto"));
		Imovel imovel = new Imovel(id_bloco, id_apto);
		int id_imovel = Integer.parseInt(request.getParameter("id_imovel"));
		new SindicoDAO().editarImovel(imovel, id_imovel);
		request.setAttribute("msg", "Imovel editado com sucesso");
		return "resp";
	}
}
