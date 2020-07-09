package condo.tarefa.condomino;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.CondominoDAO;
import condo.entities.RelatorioInformativo;
import condo.tarefa.Tarefa;

public class EmitirRelatorioInformativoCondomino implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<RelatorioInformativo> lista = new CondominoDAO().emitirRelatorioInformativo(request.getParameter("id"));
		request.setAttribute("listaRelatorio", lista);
		return "relatorioinformativo";
	}
}
