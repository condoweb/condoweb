package condo.tarefa.condomino;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.CondominoDAO;
import condo.entities.condomino.RelatorioConta;
import condo.tarefa.Tarefa;

public class EmitirRelatorioContaPagaEAVencer implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<RelatorioConta> lista1 = new CondominoDAO().emitirRelatorioContaVencer(request.getParameter("id"));
		List<RelatorioConta> lista2 = new CondominoDAO().emitirRelatorioContaPaga(request.getParameter("id"));
		request.setAttribute("listaRelatorio1", lista1);
		request.setAttribute("listaRelatorio2", lista2);
		return "relatoriocontapagaeavencer";
	}
}
