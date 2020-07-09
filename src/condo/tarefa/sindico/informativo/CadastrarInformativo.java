package condo.tarefa.sindico.informativo;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.entities.Informativo;
import condo.tarefa.Tarefa;

public class CadastrarInformativo implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Informativo info = new Informativo(request.getParameter("assunto"), request.getParameter("conteudo"),
				new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("datainfo")));
		new SindicoDAO().cadastrarInformativo(info);
		request.setAttribute("msg", "Informativo cadastrado com sucesso");
		return "resp";
	}
}
