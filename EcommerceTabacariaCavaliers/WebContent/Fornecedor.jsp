<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="br.com.cavaliers.tabacaria.model.Fornecedor" %>
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
		<link href="https://fonts.googleapis.com/css?family=Lobster&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Fira+Sans&display=swap" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cadastro_Fornecedor</title>
	</head>
	<body>
		<c:import url="./componentes/adm-top.jsp"></c:import>
		<div class="container-fluid">
			<div id="adm-page" class="row">
				<c:import url="./componentes/adm-menu.jsp"></c:import>
				<div id="admin-center" class="col">
					<div class="row">
						<div class="col">
							<%
							Fornecedor fornecedor = (Fornecedor) request.getAttribute("fornecedor");
							%>

							<div id="main" class="container">
								<h3 class="page-header"> Fornecedor Cadastrado --<%=fornecedor.getIdFornecedor()%></h3>
								<div class="row">
									<div class="col-md-12">
										<p>
											<strong>Nome</strong>
										</p>
										<p> <%=fornecedor.getNomeFornecedor()%> </p>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<p>
											<strong>Cnpj</strong>
										</p>
										<p> <%=fornecedor.getCnpj()%> </p>
									</div>
									<div class="col-md-12">
										<p>
											<strong>Telefone</strong>
										</p>
										<p> <%=fornecedor.getContatoTelefone()%> </p>
									</div>
									<div class="col-md-12">
										<p>
											<strong>Email</strong>
										</p>
										<p> <%=fornecedor.getContatoEmail()%> </p>
									</div>
									<div class="col-md-12">
										<p>
											<strong>Descricao</strong>
										</p>
										<p> <%=fornecedor.getDescricao()%> </p>
									</div>
								</div>
								<hr />
								<div id="actions" class="row">
									<div class="col-md-12">
										<a href="Index.jsp" class="btn btn-primary">Voltar</a>
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
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>