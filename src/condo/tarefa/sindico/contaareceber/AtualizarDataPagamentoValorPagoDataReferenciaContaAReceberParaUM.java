package condo.tarefa.sindico.contaareceber;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.tarefa.Tarefa;

public class AtualizarDataPagamentoValorPagoDataReferenciaContaAReceberParaUM implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String dataPagamento = request.getParameter("dataPagamento");
		Double valorPago = Double.parseDouble(request.getParameter("valorPago"));
		String dataVencimento = request.getParameter("dataVencimento");
		int numBloco = Integer.parseInt(request.getParameter("id_bloco"));
		int numApto = Integer.parseInt(request.getParameter("id_apto"));
		new SindicoDAO().atualizarDataPagamentoValorPagoDataReferenciaContaAReceberParaUM(dataPagamento, valorPago,
				dataVencimento, numBloco, numApto);
		request.setAttribute("msg", "Dados atualizados com sucesso");
		return "resp";
	}
}
