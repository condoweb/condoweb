package condo.tarefa.sindico.pessoa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.entities.sindico.PessoaCom;
import condo.tarefa.Tarefa;

public class ListarPessoa implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<PessoaCom> lista = new SindicoDAO().listarPessoa();		
		request.setAttribute("listaRelatorio", lista);
		return "listarpessoa";
	}
}
