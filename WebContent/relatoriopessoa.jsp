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
			<th>CPF</th>
			<th>RG</th>
			<th>Data Nascimento</th>
			<th>Email</th>
			<th>Telefone</th>
			<th>Perfil</th>
		</tr>
		<c:forEach var="lr" items="${listaRelatorio}">
			<tr>
				<td>${lr.nome}</td>
				<td>${lr.cpf}</td>
				<td>${lr.rg}</td>
				<td>${lr.dataNasc}</td>
				<td>${lr.email}</td>
				<td>${lr.telefone}</td>
				<td>${lr.perfil}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>