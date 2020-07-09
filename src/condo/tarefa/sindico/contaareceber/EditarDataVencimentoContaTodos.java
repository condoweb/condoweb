package condo.tarefa.sindico.contaareceber;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.tarefa.Tarefa;

public class EditarDataVencimentoContaTodos implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String dataVencimentoAntiga = request.getParameter("dataVencimentoAntiga");
		String dataVencimentoNova = request.getParameter("dataVencimentoNova");
		new SindicoDAO().editarDataVencimentoContaTodos(dataVencimentoAntiga, dataVencimentoNova);
		request.setAttribute("msg", "Data vencimento da conta a receber editada para TODOS com sucesso");
		return "resp";
	}
}
