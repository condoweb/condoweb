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
			<th>ID Pessoa</th>
			<th>Nome</th>
			<th>CPF</th>
			<th>RG</th>
			<th>Data Nascimento</th>
			<th>E-mail</th>
			<th>Telefone</th>
			<th>Telefone Celular</th>
			<th>Nome Usuário</th>
			<th>Senha</th>
			<th>Proprietário</th>
			<th>ID Permissão</th>
			<th>Data Permissão</th>
			<th>Status Permissão</th>
			<th>ID Perfil</th>
			<th>Perfil Descrição</th>
		</tr>
		<c:forEach var="lr" items="${listaRelatorio}">
			<tr>
				<td>${lr.id_pessoa}</td>
				<td>${lr.nome}</td>
				<td>${lr.cpf}</td>
				<td>${lr.rg}</td>
				<td>${lr.datanasc}</td>
				<td>${lr.email}</td>
				<td>${lr.telefone}</td>
				<td>${lr.telefoneCelular}</td>
				<td>${lr.nomeUsuario}</td>
				<td>${lr.senha}</td>
				<td>${lr.proprietario}</td>
				<td>${lr.id_permissao}</td>
				<td>${lr.permissao.dataperm}</td>
				<td>${lr.permissao.status}</td>
				<td>${lr.id_perfil}</td>
				<td>${lr.permissao.perfil.descricao}</td>
			</tr>
		</c:forEach>
	</table>
</body>