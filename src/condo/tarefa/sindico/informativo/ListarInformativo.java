package condo.tarefa.sindico.informativo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.entities.sindico.InformativoCompleto;
import condo.tarefa.Tarefa;

public class ListarInformativo implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<InformativoCompleto> lista = new SindicoDAO().listarInformativo();
		request.setAttribute("listaRelatorio", lista);
		return "listarinformativo";
	}
}
