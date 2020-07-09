<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr>
			<th>ID</th>
			<th>Data Vencimento</th>
			<th>Valor</th>
			<th>Valor Pago</th>
			<th>Data Pagamento</th>
			<th>Data Referência</th>
			<th>ID Imovel</th>
			<th>ID Condomino</th>
			<th>Nome Responsável</th>
		</tr>
		<c:forEach var="lr" items="${listaRelatorio}">
			<tr>
				<td>${lr.id_contaareceber}</td>
				<td>${lr.dataVencimento}</td>
				<td>${lr.valor}</td>
				<td>${lr.valorPago}</td>
				<td>${lr.dataPagamento}</td>
				<td>${lr.dataReferencia}</td>
				<td>${lr.id_imovel}</td>
				<td>${lr.id_condomino}</td>
				<td>${lr.nomeResponsavel}</td>
			</tr>
		</c:forEach>
	</table>
</body>