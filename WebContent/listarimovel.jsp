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
			<th>ID Imovel</th>
			<th>Num Bloco</th>
			<th>Num Apto</th>
			<th>ID Proprietario</th>
			<th>Nome Proprietario</th>
			<th>ID Condomino</th>
			<th>Nome Condomino</th>
		</tr>
		<c:forEach var="lr" items="${listaRelatorio}">
			<tr>
				<td>${lr.id_imovel}</td>
				<td>${lr.numeroBloco}</td>
				<td>${lr.numeroApto}</td>
				<td>${lr.id_proprietario}</td>
				<td>${lr.proprietario}</td>
				<td>${lr.id_condomino}</td>
				<td>${lr.condomino}</td>
			</tr>
		</c:forEach>
	</table>
</body>