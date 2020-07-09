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
			<th>Nome do Responsável</th>
			<th>Número do Apartamento</th>
			<th>Data Referência</th>
			<th>Data Vencimento</th>
			<th>Valor</th>
		</tr>
		<c:forEach var="lr" items="${listaRelatorio}">
			<tr>
				<td>${lr.nomeResponsavel}</td>
				<td>${lr.numApto}</td>
				<td>${lr.dataReferencia}</td>
				<td>${lr.dataVencimento}</td>
				<td>${lr.valor}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>