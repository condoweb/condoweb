package condo.tarefa.sindico.contaareceber;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.entities.ContaAReceber;
import condo.tarefa.Tarefa;

public class EditarContaAReceber implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Double valorNovo = Double.parseDouble(request.getParameter("valorNovo"));
		String dataString = request.getParameter("dataVencimentoNova");
		Date dataVencimentoNova = new SimpleDateFormat("yyyy-MM-dd").parse(dataString);
		ContaAReceber cr = new ContaAReceber(dataVencimentoNova, valorNovo);
		String dataVencimentoAntiga = request.getParameter("dataVencimentoAntiga");
		new SindicoDAO().editarContaAReceber(cr, dataVencimentoAntiga);
		request.setAttribute("msg", "Conta a Receber Editada com sucesso");
		return "resp";
	}
}