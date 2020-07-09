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
			<th>Assunto</th>
			<th>Conteúdo</th>
			<th>Data Informativo</th>
		</tr>
		<c:forEach var="lr" items="${listaRelatorio}">
			<tr>
				<td>${lr.id}</td>
				<td>${lr.assuntoInfo}</td>
				<td>${lr.conteudoInfo}</td>
				<td>${lr.dataInfo}</td>
			</tr>
		</c:forEach>
	</table>
</body>