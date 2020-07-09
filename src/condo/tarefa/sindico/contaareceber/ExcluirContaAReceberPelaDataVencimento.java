package condo.tarefa.sindico.contaareceber;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.tarefa.Tarefa;

public class ExcluirContaAReceberPelaDataVencimento implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String dataVencimento = request.getParameter("dataVencimento");
		new SindicoDAO().excluirContaAReceberPelaDataVencimento(dataVencimento);
		request.setAttribute("msg", "Conta a Receber exclu�da com sucesso pela Data Vencimento");
		return "resp";
	}
}