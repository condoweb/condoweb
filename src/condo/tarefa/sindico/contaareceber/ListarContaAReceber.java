package condo.tarefa.sindico.contaareceber;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.entities.sindico.ContaAReceberCompleto;
import condo.tarefa.Tarefa;

public class ListarContaAReceber implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<ContaAReceberCompleto> lista = new SindicoDAO().listarContaAReceber();
		request.setAttribute("listaRelatorio", lista);
		return "listarcontaareceber";
	}
}
