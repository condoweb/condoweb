package condo.tarefa.sindico.relatorio;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.entities.sindico.RelatorioContaRecebidaArrecadacaoPeriodo;
import condo.tarefa.Tarefa;

public class EmitirRelatorioContaRecebidaArrecadacaoPeriodo implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<RelatorioContaRecebidaArrecadacaoPeriodo> lista = new SindicoDAO()
				.emitirRelatorioContaRecebidaArrecadacaoPeriodo(request.getParameter("datainicial"),
						request.getParameter("datafinal"));
		request.setAttribute("listaRelatorio", lista);
		return "relatoriocontarecebidaarrecadacaoperiodo";
	}

}
