package condo.tarefa.sindico.informativo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.tarefa.Tarefa;

public class CancelarEnvioInformativoParaTodos implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		new SindicoDAO().cancelarEnvioInformativoParaTodos(id);
		request.setAttribute("msg", "Envio do informativo cancelado com sucesso");
		return "resp";
	}
}
