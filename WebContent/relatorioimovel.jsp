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
			<th>Bloco</th>
			<th>Apartamento</th>
			<th>Proprietário</th>
			<th>Condomino</th>
		</tr>
		<c:forEach var="lr" items="${listaRelatorio}">
			<tr>
				<td>${lr.bloco}</td>
				<td>${lr.apartamento}</td>
				<td>${lr.proprietario}</td>
				<td>${lr.condomino}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>