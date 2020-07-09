package condo.tarefa.sindico.relatorio;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.entities.sindico.RelatorioPessoa;
import condo.tarefa.Tarefa;

public class EmitirRelatorioPessoa implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<RelatorioPessoa> lista = new SindicoDAO().emitirRelatorioPessoa();
		request.setAttribute("listaRelatorio", lista);
		return "relatoriopessoa";
	}
}
