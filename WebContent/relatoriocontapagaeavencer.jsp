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
	<h1>Boletos a Vencer</h1>
	<table border=1>
		<tr>
			<th>Valor</th>
			<th>Valor Pago</th>
			<th>Data Referência</th>
			<th>Data Vencimento</th>
		</tr>
		<c:forEach var="lr" items="${listaRelatorio1}">
			<tr>
				<td>${lr.valor}</td>
				<td>${lr.valorPago}</td>
				<td>${lr.dataReferencia}</td>
				<td>${lr.dataVencimento}</td>
			</tr>
		</c:forEach>
	</table>
	<h1>Boletos Pagos</h1>
	<table border=1>
		<tr>
			<th>Valor</th>
			<th>Valor Pago</th>
			<th>Data Referência</th>
			<th>Data Vencimento</th>
		</tr>
		<c:forEach var="lr" items="${listaRelatorio2}">
			<tr>
				<td>${lr.valor}</td>
				<td>${lr.valorPago}</td>
				<td>${lr.dataReferencia}</td>
				<td>${lr.dataVencimento}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>