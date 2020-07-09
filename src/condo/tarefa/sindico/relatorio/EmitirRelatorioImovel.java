package condo.tarefa.sindico.relatorio;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.entities.sindico.RelatorioImovel;
import condo.tarefa.Tarefa;

public class EmitirRelatorioImovel implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<RelatorioImovel> lista = new SindicoDAO().emitirRelatorioImovel();
		request.setAttribute("listaRelatorio", lista);
		return "relatorioimovel";
	}
}
