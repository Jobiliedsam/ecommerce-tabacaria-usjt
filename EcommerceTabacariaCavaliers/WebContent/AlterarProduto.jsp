<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<link rel="stylesheet" href="./css/admin.css">
		<link href="https://fonts.googleapis.com/css?family=Lobster&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Fira+Sans&display=swap" rel="stylesheet">
		<title>Alterar Produto</title>
	</head>
	<body>
		<c:import url="./componentes/adm-top.jsp"></c:import>
		<div class="container-fluid">
			<div id="adm-page" class="row">
				<c:import url="./componentes/adm-menu.jsp"></c:import>
				<div id="admin-center" class="col">
					<div class="row">
						<div class="col">
							<div id="main" class="container">
								<h3 class="page-header">Alterar Produto ${produto.idProduto }</h3>
								<form action="controller.do" method="post">
									<!-- area de campos do form -->
									<input type="hidden" name="idProduto" value="${produto.idProduto }" />
									<hr />
									<div class="row">
										<div class="col-md-12">
											<label for="nomeP">Nome do Produto</label> <input type="text" name="nomeP"
												class="form-control" id="nomeP" required maxlength="100"
												placeholder="Nome do Produto" value="${produto.nomeP }">
										</div>
									</div>
									<hr />
									<div class="row">
										<div class="col-md-4">
											<label for="precoF">Preço Produto</label>
											<input type="text" name="precoF" class="form-control" id="precoF" required
												maxlength="10" placeholder="Preço do Produto" value="${produto.precoF}">
										</div>
										<div class="col-md-4">
											<label for="categoria">Categoria</label> <input type="text" name="categoria"
												class="form-control" id="categoria" required maxlength="20"
												placeholder="Categoria do Produto" value="${produto.categoria }">
										</div>
									
										<div class="col-md-4">
											<label for="fornecedor">Fornecedor</label> <input type="text"
												name="fornecedor" class="form-control" id="fornecedor" required
												maxlength="100" placeholder="Fornecedor" value="${produto.fornecedor }">
										</div>
									</div>
									<hr />
									<div class="row">
										<div class="col-md-4">
											<label for="nomeP">Status</label> <input type="text" name="nomeP"
												class="form-control" id="nomeP" required maxlength="100"
												placeholder="Status" value="${produto.status }">
										</div>
									
										<div class="col-md-4">
											<label for="descricao">Descrição</label> <input type="text" name="descricao"
												class="form-control" id="descricao" required maxlength="100"
												placeholder="Descriçao" value="${produto.descricao }">
										</div>
									
										<div class="col-md-4">
											<label for="quantidade">Quantidade</label> <input type="number"
												name="quantidade" class="form-control" id="quantidade" required
												maxlength="100" placeholder="Quantidade" value="${produto.quantidade }">
										</div>
									</div>
									<hr />
									<div id="actions" class="row">
										<div class="col-md-12">
											<button type="submit" class="btn btn-primary" name="command"
												value="AlterarProduto">Salvar</button>
											<a href="ListarProduto.jsp" class="btn btn-default">Cancelar</a>
										</div>
									</div>
								</form>
							</div>
							<!-- Fim -->
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="back-to-top">
			<i class="fas fa-chevron-up"></i>
		</div>
		<script src="./js/backtotop.js"></script>
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>