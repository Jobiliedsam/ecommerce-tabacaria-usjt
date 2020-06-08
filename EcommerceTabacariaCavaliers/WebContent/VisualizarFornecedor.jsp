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
<title>Visualizar Fornecedor</title>
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
						<!-- Modal -->
						<div class="modal fade" id="delete-modal" tabindex="-1"
							role="dialog" aria-labelledby="modalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Fechar">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="modalLabel">Excluir
											Fornecedor</h4>
									</div>
									<div class="modal-body">Deseja realmente excluir este
										fornecedor?</div>
									<div class="modal-footer">
										<form action="controller.do" method="post">
											<input type="hidden" name="id"
												value="${fornecedor.idFornecedor }" />
											<button type="submit" class="btn btn-primary" name="command"
												value="ExcluirFornecedor">Sim</button>
											<button type="button" class="btn btn-default"
												data-dismiss="modal">N&atilde;o</button>
										</form>
									</div>
								</div>
							</div>
						</div>
						<!-- /.modal -->
						<div id="main" class="container">
							<h3 class="page-header">Visualizar Fornecedor
								${fornecedor.idFornecedor }</h3>
							<hr />
							<div class="row">
								<div class="col-md-12">
									
										<h5>Nome</h5>
									
									<p>${fornecedor.nomeFornecedor }</p>
								</div>
							</div>
							<hr />
							<div class="row">
								<div class="col-md-6">
									
										<h5>Cnpj</h5>
									
									<p>${fornecedor.cnpj }</p>
								</div>
								<div class="col-md-6">
									
										<h5>Telefone</h5>
									
									<p>${fornecedor.contatoTelefone }</p>
								</div>
							</div>
							<hr />
							<div class="row">
								<div class="col-md-6">
									
										<h5>Email</h5>
									
									<p>${fornecedor.contatoEmail }</p>
								</div>
								
								<div class="col-md-6">
									
										<h5>Descrição</h5>
									
									<p>${fornecedor.descricao }</p>
								</div>
							</div>
							<hr />
							<div id="actions" class="row">
								<div class="col-md-12">
									<a
										href="controller.do?command=EditarFornecedor&id=${fornecedor.idFornecedor }"
										class="btn btn-primary">Editar</a> <a href="#"
										class="btn btn-danger" data-toggle="modal"
										data-target="#delete-modal">Excluir</a> <a
										href="ListarFornecedor.jsp" class="btn btn-default">Voltar</a>
								</div>
							</div>
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