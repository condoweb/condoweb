package condo.tarefa.sindico.relatorio;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.entities.RelatorioInformativo;
import condo.tarefa.Tarefa;

public class EmitirRelatorioInformativo implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<RelatorioInformativo> lista = new SindicoDAO()
				.emitirRelatorioInformativo(request.getParameter("datainicial"), request.getParameter("datafinal"));
		request.setAttribute("listaRelatorio", lista);
		return "relatorioinformativo";
	}
}
