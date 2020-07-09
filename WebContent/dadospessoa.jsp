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
			<th>E-mail</th>
			<th>Telefone</th>
			<th>Telefone Celular</th>
			<th>Nome Usuário</th>
			<th>Senha</th>
		</tr>
		<tr>
			<td>${pessoa.nome}</td>
			<td>${pessoa.cpf}</td>
			<td>${pessoa.rg}</td>
			<td>${pessoa.datanasc}</td>
			<td>${pessoa.email}</td>
			<td>${pessoa.telefone}</td>
			<td>${pessoa.telefoneCelular}</td>
			<td>${pessoa.nomeUsuario}</td>
			<td>${pessoa.senha}</td>
		</tr>
	</table>
</body>