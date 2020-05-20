<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> <%@page import="br.com.cavaliers.tabacaria.model.Usuario"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<link rel="stylesheet" href="./css/bootstrap-grid.css">
		<link rel="stylesheet" href="./css/bootstrap-grid.min.css">
		<link rel="stylesheet" href="./css/bootstrap-reboot.css">
		<link rel="stylesheet" href="./css/bootstrap.css">
		<link rel="stylesheet" href="./css/bootstrap.min.css">
		<link rel="stylesheet" href="./css/fontawesome.min.css">
		<link rel="stylesheet" href="./css/style.css">
		<link rel="stylesheet" href="./css/admin.css">
		<link href="https://fonts.googleapis.com/css?family=Lobster&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Fira+Sans&display=swap" rel="stylesheet">
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Visualizar Usuario</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
	</head>
	<body> <%
		Usuario usuario = (Usuario) request.getAttribute("usuario");
	%>
		<!-- Barra superior com os menus de navegação -->
		<!-- Container Principal -->
		<div id="main" class="container">
			<h3 class="page-header"> USUARIO CADASTRADO COM SUCESSO --<%=usuario.getId()%></h3>
			<div class="row">
				<div class="col-md-8">
					<p>
						<strong>Email</strong>
					</p>
					<p> <%=usuario.getEmail()%> </p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-8">
					<p>
						<strong>Senha</strong>
					</p>
					<p> <%=usuario.getPassword()%> </p>
				</div>
			</div>
			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<a href="UsuarioIndex.jsp" class="btn btn-primary">Voltar</a>
				</div>
			</div>
		</div>
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>