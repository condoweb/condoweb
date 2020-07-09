package condo.tarefa.sindico.informativo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.tarefa.Tarefa;

public class EnviarInformativoParaUm implements Tarefa{
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id_bloco = Integer.parseInt(request.getParameter("id_bloco"));
		int id_apto = Integer.parseInt(request.getParameter("id_apto"));
		int id_info = Integer.parseInt(request.getParameter("id_info"));
		new SindicoDAO().enviarInformativoParaUm(id_bloco, id_apto, id_info);
		request.setAttribute("msg", "Informativo enviado com sucesso");
		return "resp";
	}
}
