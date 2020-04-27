<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="br.com.cavaliers.tabacaria.model.Categoria"%>
<!DOCTYPE htmls>
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

		<link
			href="https://fonts.googleapis.com/css?family=Lobster&display=swap"
			rel="stylesheet">
		<link
			href="https://fonts.googleapis.com/css?family=Fira+Sans&display=swap"
			rel="stylesheet">


		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cadastro_Categoria</title>
	</head>
	<body>

		<jsp:include page="./componentes/adm-top.html"></jsp:include>
		
		<div class="container-fluid">
			<div id="adm-page" class="row">

				<jsp:include page="./componentes/adm-menu.html"></jsp:include>

				<div id="admin-center" class="col">
					<div class="row">
						<div class="col">
							<!-- Adicionar aqui o conteúdo de administração -->

							<%
								Categoria categoria = (Categoria) request.getAttribute("categoria");
							%>
							<!-- Barra superior com os menus de navegação -->
							<!-- Container Principal -->
							<div id="main" class="container">
								<h3 class="page-header">
									Categoria Cadastrada --<%=categoria.getIdCategoria()%></h3>
								<div class="row">
									<div class="col-md-12">
										<p>
											<strong>Nome</strong>
										</p>
										<p>
											<%=categoria.getCategoria()%>
										</p>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<p>
											<strong>Status</strong>
										</p>
										<p>
											<%=categoria.getStatus()%>
										</p>
									</div>
									<div class="col-md-12">
										<p>
											<strong>Descricao</strong>
										</p>
										<p>
											<%=categoria.getDescricao()%>
										</p>
									</div>
								</div>
								<hr />
								<div id="actions" class="row">
									<div class="col-md-12">
										<a href="CategoriaIndex.jsp" class="btn btn-primary">Voltar</a>
									</div>
								</div>
							</div>

							<!-- Fim -->
						</div>
					</div>
				</div>
			</div>
		</div>

		<div id="back-to-top"><i class="fas fa-chevron-up"></i></div>
		
		<script src="./js/backtotop.js"></script>
		<script src= "js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>