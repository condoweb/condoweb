package condo.tarefa.sindico.contaareceber;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.tarefa.Tarefa;

public class EditarDataVencimentoContaUm implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String dataVencimentoAntiga = request.getParameter("dataVencimentoAntiga");
		String dataVencimentoNova = request.getParameter("dataVencimentoNova");
		int numBloco = Integer.parseInt(request.getParameter("id_bloco"));
		int numApto = Integer.parseInt(request.getParameter("id_apto"));
		new SindicoDAO().editarDataVencimentoContaUm(dataVencimentoAntiga, dataVencimentoNova, numBloco, numApto);
		request.setAttribute("msg", "Data vencimento da conta a receber editada para UM(Usuario-especifico) com sucesso");
		return "resp";
	}
}
