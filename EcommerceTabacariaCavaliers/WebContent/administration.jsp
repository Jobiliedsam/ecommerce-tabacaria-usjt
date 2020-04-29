<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

	<meta charset="ISO-8859-1">
	<title>Administração</title>
</head>
	<body>

		<jsp:include page="./componentes/adm-top.jsp"></jsp:include>
		
		<div class="container-fluid">
			<div id="adm-page" class="row">

				<jsp:include page="./componentes/adm-menu.jsp"></jsp:include>

				<div id="admin-center" class="col">
					<div class="row">
						<div class="col">
							<!-- Adicionar aqui o conteÃºdo de administraÃ§Ã£o -->

							<h1>Bem vindo a Pagina de Administrção</h1>
							<h3>Clique nos links laterais e administre sua loja.</h3>

							<!-- Fim -->
						</div>
					</div>
				</div>
			</div>
		</div>

		<div id="back-to-top"><i class="fas fa-chevron-up"></i></div>
		
		<script src="./js/backtotop.js"></script>
	</body>
</html>