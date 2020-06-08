<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<title>Visualizar Produto</title>
</head>
<body>
	<!-- Modal -->
	<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog"
		aria-labelledby="modalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Fechar">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalLabel">Excluir Produto</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir este produto?
				</div>
				<div class="modal-footer">
					<form action="controller.do" method="post">
						<input type="hidden" name="id" value="${produto.idProduto }" />
						<button type="submit" class="btn btn-primary" name="command"
							value="ExcluirProduto">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal -->
	<div id="main" class="container">
		<h3 class="page-header">Visualizar Produto ${produto.idProduto }</h3>
		<hr />
		<div class="row">
			<div class="col-md-12">

				<h5>Nome do Produto</h5>

				<p>${produto.nomeP }</p>
			</div>
		</div>
		<hr />
		<div class="row">
			<div class="col-md-4">

				<h5>Preço</h5>

				<p>${produto.precoF }</p>
			</div>

			<div class="col-md-4">

				<h5>Categoria</h5>

				<p>${produto.categoria }</p>
			</div>

			<div class="col-md-4">

				<h5>Fornecedor</h5>

				<p>${produto.fornecedor }</p>
			</div>
		</div>
		<hr />
		<div class="row">
			<div class="col-md-4">

				<h5>Status</h5>

				<p>${produto.status }</p>
			</div>

			<div class="col-md-4">

				<h5>Descrição</h5>

				<p>${produto.descricao }</p>
			</div>

			<div class="col-md-4">

				<h5>Quantidade</h5>

				<p>${produto.quantidade }</p>
			</div>
		</div>
		<div>
			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<a
						href="controller.do?command=EditarProduto&id=${produto.idProduto }"
						class="btn btn-primary">Editar</a> <a
						class="btn btn-danger btn-xs"
						href="controller.do?command=ExcluirProduto&id=${produto.idProduto }">Excluir</a>
					<a href="ListarProduto.jsp" class="btn btn-default">Voltar</a>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>