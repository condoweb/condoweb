package condo.tarefa.sindico.informativo;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.entities.Informativo;
import condo.tarefa.Tarefa;

public class EditarInformativo implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		Informativo info = new Informativo(request.getParameter("assunto"), request.getParameter("conteudo"),
				new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("datainfo")));
		new SindicoDAO().editarInformativo(info, id);
		request.setAttribute("msg", "Informativo editado com sucesso");
		return "resp";
	}
}
