package condo.tarefa.sindico.imovel;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.entities.sindico.ImovelCompleto;
import condo.tarefa.Tarefa;

public class ListarImovel implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<ImovelCompleto> lista = new SindicoDAO().listarImovel();
		request.setAttribute("listaRelatorio", lista);
		return "listarimovel";
	}
}
