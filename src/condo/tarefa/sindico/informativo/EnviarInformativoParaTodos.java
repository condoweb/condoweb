package condo.tarefa.sindico.informativo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.tarefa.Tarefa;

public class EnviarInformativoParaTodos implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id_info = Integer.parseInt(request.getParameter("info"));
		new SindicoDAO().enviarInformativoParaTodos(id_info);
		request.setAttribute("msg", "Informativo enviado com sucesso");
		return "resp";
	}
}
