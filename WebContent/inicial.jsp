<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/grid.css">
<script src="js/script.js"></script>
<link rel="icon" type="image/png" sizes="32x32" href="image/favicon.png">
<title>CondoWeb</title>
</head>

<body style="background-image: url('image/fundo_inicial.jpg')">

	<div class="container">
		<div class="displayLogin displayLogo">
			<img src="image/logo.png" alt="">
		</div>
		<img src="image/colunaLogin.png" alt="">
		<div class="displayLogin">
			<form id="formLogin" name="formLogin" method="post"
				action="frontcontroller/loginpessoa">
				<div class="row"></div>
				<div class="row">
					<div class="col-dg-8 col-dm-8">
						<input type="text" name="usuarioemail" id="txtNome" maxlength="40"
							required="required" autocomplete="off"
							placeholder=" Usuário/E-mail">
					</div>
				</div>
				<div class="row">
					<div class="col-dg-8 col-dm-8" efectSenha>
						<input type="password" name="senha" id="txtSenha" maxlength="20"
							required="required" autocomplete="off" placeholder=" Senha">
					</div>
				</div>
				<div class="row">
					<div class="col-dg-6 col-dm-6">
						<input type="submit" value="Login">
					</div>
				</div>
				<div class="row">
					<div class="col-dg-12 col-dm-12 login">
						<p>
							Ainda não tem conta? <a href="">Solicite o seu cadastro</a>
						</p>
					</div>
				</div>

			</form>
		</div>

	</div>
	</div>

</body>

</html>

<html>