<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>CAVALIERS - Visualizar Cliente</title>
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
</head>
<body>
	<jsp:include page="./componentes/adm-top.jsp"></jsp:include>
	<div class="container-fluid">
		<div id="adm-page" class="row">
			<jsp:include page="./componentes/adm-menu.jsp"></jsp:include>
			<div id="admin-center" class="col">
				<div class="row">
					<div class="col">
						<!-- Adicionar aqui o conteúdo de administração -->
						<!-- Modal Não implementado -->
						<div class="modal fade" id="delete-modal" tabindex="-1"
							role="dialog" aria-labelledby="modalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Fechar">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="modalLabel">Excluir Cliente</h4>
									</div>
									<div class="modal-body">Deseja excluir este Cliente?</div>
									<div class="modal-footer">
										<form action="controller.do" method="post">
											<input type="hidden" name="id" value="${cliente.idCliente }" />
											<button type="submit" class="btn btn-primary" name="command"
												value="ExcluirCliente">Sim</button>
											<button type="button" class="btn btn-default"
												data-dismiss="modal">N&atilde;o</button>
										</form>
									</div>
								</div>
							</div>
						</div>
						<!-- /.modal -->
						<!-- Barra superior com os menus de navegação -->
						<!-- Container Principal -->
						<div id="main" class="container">
							<h3 class="page-header">Visualizar Cliente
								${cliente.idCliente }</h3>
							<hr />
							<div class="row">
								<div class="col-md-4">
									<h5>Nome</h5>
									<p>${cliente.nomeCompleto}</p>
								</div>
								<div class="col-md-4">
									<h5>Celular</h5>
									<p>${cliente.celular}</p>
								</div>
								<div class="col-md-4">
									<h5>Telefone</h5>
									<p>${cliente.telefone }</p>
								</div>
							</div>
							<hr />
							<div class="row">
								<div class="col-md-4">
									<h5>Email</h5>
									<p>${cliente.email }</p>
								</div>
								<div class="col-md-4">
									<h5>Genero</h5>
									<p>${cliente.genero }</p>
								</div>
								<div class="col-md-4">
									<h5>CPF/CNPJ</h5>
									<p>${cliente.cpfCnpj }</p>
								</div>
							</div>
							<hr />
							<div class="row">
								<div class="col-md-4">
									<h5>Tipo</h5>
									<p>${cliente.tipo }</p>
								</div>
								<div class="col-md-4">
									<h5>Data de Nascimento</h5>
									<p>${cliente.dataDeNascimento }</p>
								</div>
								<div class="col-md-4">
									<h5>RG</h5>
									<p>${cliente.rg }</p>
								</div>
							</div>
							<hr />
							<div class="row">
							</div>
							<hr />
							<div class="row">
								<div class="col-md-4">
									<h5>CEP</h5>
									<p>${endereco.cep }</p>
								</div>
								<div class="col-md-4">
									<h5>Endereço</h5>
									<p>${endereco.enderecoP }</p>
								</div>
								<div class="col-md-4">
									<h5>Bairro</h5>
									<p>${endereco.enderecoS}</p>
								</div>
							</div>
							<hr />
							<div class="row">
								<div class="col-md-4">
									<h5>Cidade</h5>
									<p>${endereco.cidade }</p>
								</div>
								<div class="col-md-4">
									<h5>Estado</h5>
									<p>${endereco.estado}</p>
								</div>
								<div class="col-md-4">
									<h5>Complemento</h5>
									<p>${endereco.complemento }</p>
								</div>
							</div>
						</div>
						<hr />
						<div id="actions" class="row">
							<div class="col-md-12">
								<a
									href="controller.do?command=EditarCliente&id=${cliente.idCliente }"
									class="btn btn-primary">Editar</a> <a
									class="btn btn-danger btn-xs"
									href="controller.do?command=ExcluirCliente&id=${cliente.idCliente}&idUsuario=${usuario.idUsuario}">Excluir</a>
								<a href="ClienteLista.jsp" class="btn btn-default">Voltar</a>
							</div>
						</div>
					</div>
					<!-- Fim -->
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