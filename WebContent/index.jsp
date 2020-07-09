<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv=”content-type” content="text/html;" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/grid.css">
    <link rel="icon" type="image/png" sizes="32x32" href="image/favicon.png">
    <title>CondoWeb</title>

    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="css/style.css">

    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/script.js"></script>
</head>

<body class="login-page">

    <div class="cxformLogin">
        <div class="row">
            <div class="d-none d-md-block col-lg-5 col-xl-5" style="margin:0px -20px 0px 40px ;">
                <div class="displayLogin displayLogo">
                    <img src="image/logo.png " alt=" ">
                </div>
            </div>
            <div class="d-none d-md-block col-lg-2 col-xl-2">
                <div class="barra">
                    <img src="image/colunaLogin.png " alt=" ">
                </div>
            </div>
            <div class="col-sm-5 col-md-5 col-lg-5 col-xl-5" style="margin-left:-50px;">
                <div class="displayLogin">
                    <form id="formLogin" name="formLogin" method="post" action="frontcontroller/loginpessoa" autocomplete="off">
                        <div class="row" style="margin:100px 0px 0px 0px;">
                            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                                <input type="text" name="usuarioemail" id="txtNome" maxlength="40" required="required" autocomplete="off " placeholder=" Usuário/E-mail ">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 efectSenha">
                                <input type="password" name="senha" id="txtSenha" maxlength="20" required="required" autocomplete="off" placeholder=" Senha">
                            </div>
                        </div>
                        <div class="row esqSenha">
                            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                                <p><a href=" ">Esqueci minha senha.</a></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12" style="margin:20px 0px 0px -105px;">
                                <input type="submit" value="Login" onclick="validarLogin()" onfocus="playAudio('sonsButton')" onblur="pauseAudio('sonsButton')">
                            </div>
                        </div>
                        <div class="row login">
                            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                                <p>Ainda não tem conta?</p>
                            </div>
                        </div>
                        <div class="row login">
                            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12n">
                                <a href=" ">Solicite o seu cadastro</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>

</html>