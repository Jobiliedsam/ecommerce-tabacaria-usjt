<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<title>Criar Produto</title>
	</head>
	<body>
		<jsp:useBean id="categorias" class="br.com.cavaliers.tabacaria.service.CategoriaService" />
		<jsp:useBean id="fornecedores" class="br.com.cavaliers.tabacaria.service.FornecedorService" />
		<c:import url="./componentes/adm-top.jsp"></c:import>
		<div class="container-fluid">
			<div id="adm-page" class="row">
				<c:import url="./componentes/adm-menu.jsp"></c:import>
				<div id="admin-center" class="col">
					<div class="row">
						<div class="col">
							<!-- Adicionar aqui o conteÃºdo de administraÃ§Ã£o -->
							<div id="main" class="container">
								<h3 class="page-header">Incluir Produto</h3>
								<form action="controller.do" method="post" enctype="multipart/form-data">
									<!-- area de campos do form -->
									<div class="row">
										<div class="form-group col-md-12">
											<label for="nomeP">Nome do Produto:</label>
											<input type="text" class="form-control" name="nomeP" id="nomeP" required
												maxlength="100" placeholder="Nome do Produto">
										</div>
									</div>
									<div class="row">
										<div class="form-group col-md-4">
											<label for="precoF"> Preço: </label>
											<input type="text" class="form-control" name="precoF" id="precoF" required
												maxlength="100" placeholder="Preço do Produto" />
										</div>
									
										<div class="form-group col-md-4">
											<label for="categoria">Categoria:</label>
											<select class="form-control" name="categoria" id="categoria" required>
												<c:forEach var="categoria" items="${categorias.carregarAll()}">
													<option value="${categoria.categoria}">${categoria.categoria}
														(${categoria.status}) </option>
												</c:forEach>
											</select>
										</div>
									
										<div class="form-group col-md-4">
											<label for="fornecedor">Fornecedor</label>
											<select class="form-control" name="fornecedor" id="fornecedor" required>
												<c:forEach var="fornecedor"
													items="${fornecedores.listarFornecedores()}">
													<option value="${fornecedor.nomeFornecedor}">
														${fornecedor.nomeFornecedor} </option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="row">
										<div class="form-group col-md-6">
											<label for="status">Status</label>
											<select class="form-control" name="status" id="status" required>
												<option value="Ativo"> Ativo </option>
												<option value="Inativo"> Inativo </option>
											</select>
										</div>
									
										<div class="form-group col-md-6">
											<label for="descricao"> Descrição: </label>
											<input type="text" class="form-control" name="descricao" id="descricao"
												required maxlength="100" placeholder="descricao" />
										</div>
									</div>
									<div class="row">
										<div class="form-group col-md-6">
											<label for="quantidade"> Quantidade: </label> <input type="number"
												class="form-control" name="quantidade" id="quantidade" required
												maxlength="100" placeholder="quantidade" />
										</div>
									
										<div class="form-group col-md-6">
											<label for="fotos">Fotos do Produto</label>
											<input type="file" name="fotos" id="fotos" multiple required />
										</div>
									</div>
									<hr />
									<div id="actions" class="row">
										<div class="col-md-12">
											<button type="submit" class="btn btn-primary" name="command"
												value="CriarProduto">Salvar</button>
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