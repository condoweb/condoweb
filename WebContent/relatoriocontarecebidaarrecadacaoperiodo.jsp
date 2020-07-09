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
			<th>Nome</th>
			<th>Número do Apartamento</th>
			<th>Número do Bloco</th>
			<th>Referência</th>
			<th>Data Vencimento</th>
			<th>Data Pagamento</th>
			<th>Valor Pago</th>
		</tr>
		<c:forEach var="lr" items="${listaRelatorio}">
			<tr>
				<td>${lr.nome}</td>
				<td>${lr.numApto}</td>
				<td>${lr.numBloco}</td>
				<td>${lr.mesVigente}</td>
				<td>${lr.dataVencimento}</td>
				<td>${lr.dataPagamento}</td>
				<td>${lr.valorPago}</td>
			</tr>
		</c:forEach>
	</table>
	<h4 onclick="window.print();">Print</h4>
</body>
</html>