<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
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
	<meta charset="UTF-8">
	<title>Cavaliers - Administração</title>
</head>
<body>
	<c:import url="./componentes/adm-top.jsp"></c:import>
	<div class="container-fluid">
		<div id="adm-page" class="row">
			<c:import url="./componentes/adm-menu.jsp"></c:import>
			<div id="admin-center" class="col">
				<div class="row">
					<div class="col">
						<h1>Bem vindo a Pagina de Administrção</h1>
						<h3>Clique nos links laterais e administre sua loja.</h3>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="back-to-top">
		<i class="fas fa-chevron-up"></i>
	</div>
	<script src="./js/backtotop.js"></script>
</body>
</html>