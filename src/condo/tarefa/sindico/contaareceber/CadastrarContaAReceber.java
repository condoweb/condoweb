package condo.tarefa.sindico.contaareceber;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.entities.ContaAReceber;
import condo.tarefa.Tarefa;

public class CadastrarContaAReceber implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Double valor = Double.parseDouble(request.getParameter("valor"));
		String dataString = request.getParameter("dataVencimento");
		Date dataVencimento = new SimpleDateFormat("yyyy-MM-dd").parse(dataString);
		ContaAReceber cr = new ContaAReceber(dataVencimento, valor);
		new SindicoDAO().cadastrarContaAReceber(cr);
		request.setAttribute("msg", "Conta a Receber cadastrada com sucesso");
		return "resp";
	}
}