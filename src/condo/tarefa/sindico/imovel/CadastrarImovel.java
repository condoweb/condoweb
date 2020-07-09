package condo.tarefa.sindico.imovel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.entities.Imovel;
import condo.tarefa.Tarefa;

public class CadastrarImovel implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id_bloco = Integer.parseInt(request.getParameter("id_bloco"));
		int id_apto = Integer.parseInt(request.getParameter("id_apto"));
		Imovel imovel = new Imovel(id_bloco, id_apto);
		new SindicoDAO().cadastrarImovel(imovel);
		request.setAttribute("msg", "Imovel cadastrado com sucesso");
		return "resp";
	}
}
