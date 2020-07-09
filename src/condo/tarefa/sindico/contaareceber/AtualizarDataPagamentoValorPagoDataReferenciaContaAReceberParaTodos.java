package condo.tarefa.sindico.contaareceber;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import condo.dao.SindicoDAO;
import condo.tarefa.Tarefa;

public class AtualizarDataPagamentoValorPagoDataReferenciaContaAReceberParaTodos implements Tarefa {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String dataPagamento = request.getParameter("dataPagamento");
		Double valorPago = Double.parseDouble(request.getParameter("valorPago"));
		String dataVencimento = request.getParameter("dataVencimento");
		new SindicoDAO().atualizarDataPagamentoValorPagoDataReferenciaContaAReceberParaTodos(dataPagamento, valorPago,
				dataVencimento);
		request.setAttribute("msg", "Dados atualizados com sucesso");
		return "resp";
	}
}
