<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="./css/bootstrap-grid.css">
	<link rel="stylesheet" href="./css/bootstrap-grid.min.css">
	<link rel="stylesheet" href="./css/bootstrap-reboot.css">
	<link rel="stylesheet" href="./css/bootstrap.css">
	<link rel="stylesheet" href="./css/bootstrap.min.css">
	<link rel="stylesheet" href="./css/fontawesome.min.css">
	<link rel="stylesheet" href="./css/style.css">
	<link rel="stylesheet" href="./css/admin.css.css">

	<link href="https://fonts.googleapis.com/css?family=Lobster&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Fira+Sans&display=swap" rel="stylesheet">

	<title>Cadastro de Produto</title>
</head>
<body>
	<jsp:include page="./componentes/header.html"></jsp:include>
	
	<jsp:include page="./componentes/cadastro_produtos.html"></jsp:include>

	<jsp:include page="./componentes/footer.html"></jsp:include>

	<jsp:include page="./componentes/administration.html"></jsp:include>

	<div id="back-to-top"><i class="fas fa-chevron-up"></i></div>

	<script src="./js/backtotop.js"></script>
</body>
</html>