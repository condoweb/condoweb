<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv=”content-type” content="text/html;" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="../image/png" sizes="32x32" href="../image/favicon.png">
    <title>CondoWeb</title>

    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="../css/style.css">

    <script src="../js/jquery-3.2.1.min.js"></script>
    <script src="../js/popper.min.js"></script>
    <script src="../js/script.js"></script>
</head>

<body class="pagPrincipal-page">
    <header>
        <div class="row">
            <div class="col-sm-2 col-md-2 col-lg-2 col-xl-2">
            </div>
            <div class="col-sm-2 col-md-2 col-lg-2 col-xl-2">
            </div>
        </div>
    </header>
    <div class="container">
        <div id="mySidenavIco " class="sidenav icoBright" style="width: 66px; margin:-15px 0px 0px 0px; padding: 0px 0px 0px 0px; ">
            <a style="font-size:30px;cursor:pointer; color:#979797; " onclick="openNav() ">&#9776;</a>
            <a href="#" style="border-bottom: 2px solid #7e7e7e31; padding-left: 30px;  background-color: #6b6b6b31;" class="paginaAtual"><img src="../image/home_normal.png " style="width:30px ;height:30px; " alt=" "></a>
            <a href="./cadastroPessoa.html " style="border-bottom: 2px solid #7e7e7e31; padding-left: 30px; "><img src="../image/user_normal.png " style="width:30px ;height:30px; " alt=" "></a>
            <a href="./cadastroImovel.html" style="border-bottom: 2px solid #7e7e7e31; padding-left: 30px; "><img src="../image/imovel_normal.png " style="width:30px ;height:30px; " alt=" "></a>
            <a href="# " style="border-bottom: 2px solid #7e7e7e31; padding-left: 30px; "><img src="../image/debito_normal.png " style="width:30px ;height:30px; " alt=" "></a>
            <a href="# " style="border-bottom: 2px solid #7e7e7e31; padding-left: 30px; "><img src="../image/informativo_normal.png " style="width:30px ;height:30px; " alt=" "></a>
            <a href="../consultarelatorios.jsp" style="border-bottom: 2px solid #7e7e7e31; padding-left: 30px;"><img src="../image/relatorio_normal.png " style="width:30px ;height:30px; " alt=" "></a>
        </div>
        <div id="mySidenav" class="sidenav" style="display:none">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()" class="" style="margin-top:-10px">&times;</a>
            <a href="#" style="border-bottom: 2px solid #7e7e7e31; padding-left: 30px; color:white; background-color: #6b6b6b31;" class="paginaAtual"><img src="../image/home_normal.png " style="width:30px ;height:30px; " alt=" ">Página Principal</a>
            <a href="./cadastroPessoa.html" style="border-bottom: 2px solid #7e7e7e31; padding-left: 30px; "><img src="../image/user_normal.png " style="width:30px ;height:30px; " alt=" ">Cadastro de Condôminos</a>
            <a href="./cadastroImovel.html" style="border-bottom: 2px solid #7e7e7e31; padding-left: 30px; "><img src="../image/imovel_normal.png " style="width:30px ;height:30px; " alt=" ">Cadastro de Imóveis</a>
            <a href="# " style="border-bottom: 2px solid #7e7e7e31; padding-left: 30px; "><img src="../image/debito_normal.png " style="width:30px ;height:30px; " alt=" ">Cadastro de Débitos</a>
            <a href="# " style="border-bottom: 2px solid #7e7e7e31; padding-left: 30px; "><img src="../image/informativo_normal.png " style="width:30px ;height:30px; " alt=" ">Cadastro de Informativo</a>
            <a href="../consultarelatorios.jsp" style="border-bottom: 2px solid #7e7e7e31; padding-left: 30px; "><img src="../image/relatorio_normal.png " style="width:30px ;height:30px; " alt=" ">Relatórios</a>
        </div>


    </div>
    <footer>
        <div class="row ">
            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 ">
                <p>Copyright©<span>2020</span>•LKS Solutions</p>
            </div>
        </div>
    </footer>
</body>

</html>

<html>