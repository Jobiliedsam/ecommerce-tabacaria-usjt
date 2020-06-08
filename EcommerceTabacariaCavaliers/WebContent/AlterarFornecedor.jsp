<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Cavaliers - Alterar Fornecedor</title>
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
							<h3 class="page-header">Alterar Fornecedor
								#${fornecedor.idFornecedor}</h3>
							<form action="controller.do" method="post">
								<input type="hidden" name="idFornecedor"
									value="${fornecedor.idFornecedor }" />
								<div class="row">
									<div class="form-group col-md-12">
										<label for="nome">Nome</label> <input type="text"
											class="form-control" name="nomeFornecedor"
											id="nomeFornecedor" required maxlength="100"
											placeholder="nome completo"
											value="${fornecedor.nomeFornecedor}">
									</div>
								</div>
								<div class="row">
									<div class="form-group col-md-6">
										<label for="cnpj"> Cnpj: </label> <input type="number"
											class="form-control" name="cnpj" id="cnpj" required
											maxlength="100" placeholder="cnpj" value="${fornecedor.cnpj}">
									</div>

									<div class="form-group col-md-6">
										<label for="contatoTelefone">Telefone</label> <input
											type="tel" class="form-control" name="contatoTelefone"
											id="contatoTelefone" maxlength="15" placeholder="Telefone"
											value="${fornecedor.contatoTelefone}">
									</div>
								</div>
								<div class="row">
									<div class="form-group col-md-6">
										<label for="contatoEmail">E-Mail</label> <input type="email"
											class="form-control" name="contatoEmail" id="contatoEmail"
											required maxlength="60" placeholder="email"
											value="${fornecedor.contatoEmail}">
									</div>
									<div class="form-group col-md-6">
										<label for="descricao"> Descrição: </label> <input type="text"
											class="form-control" name="descricao" id="descricao" required
											maxlength="100" placeholder="descricao"
											value="${fornecedor.descricao}">
									</div>
								</div>
								<hr />
								<div id="actions" class="row">
									<div class="col-md-12">
										<button type="submit" class="btn btn-primary" name="command"
											value="AlterarFornecedor">Salvar</button>
										<a href="ListarFornecedor.jsp" class="btn btn-default">Cancelar</a>
									</div>
								</div>
							</form>
						</div>
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