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

<title>Alterar Fornecedor</title>
</head>
<body>
				<div id="main" class="container">
                    <h3 class="page-header">Alterar Fornecedor #${fornecedor.idFornecedor }</h3>
                    <!-- Formulario para alteração de fornecedor -->
                    <form action="Controller.do" method="post">
                        <!-- area de campos do form -->
                        <input type="hidden" name="id" value="${fornecedor.idFornecedor }" />
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label for="nome">Nome</label>
                                <input type="text" class="form-control" name="nomeFornecedor" id="nomeFornecedor" required maxlength="100" placeholder="nome completo" value="${fornecedor.nomeFornecedor }">
                            </div>
                        </div>
                        <div class="row">
							<div class="form-group col-md-12">
								<label for="cnpj"> Cnpj: </label> <input type="number"
						class="form-control" name="cnpj" id="cnpj" required
						maxlength="100" placeholder="cnpj" value="${fornecedor.cnpj }">
					</div>
					</div>
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="contatoTelefone">Telefone</label>
                                <input type="tel" class="form-control" name="contatoTelefone" id="contatoTelefone" maxlength="15" pattern="(?:\(\d{2}\)|\d{2})[- ]?\d{5}[- ]?\d{4}" placeholder="(99) 99999-9999" value="${fornecedor.contatoTelefone }">
                            </div>

                            <div class="form-group col-md-6">
                                <label for="contatoEmail">E-Mail</label>
                                <input type="email" class="form-control" name="contatoEmail" id="contatoEmail" required maxlength="60" placeholder="email obrigatório" value="${fornecedor.contatoEmail }">
                            </div>
                        </div>
                        <div class="row">
							<div class="form-group col-md-12">
								<label for="descricao"> Descricao: </label> <input
								type="text" class="form-control" name="descricao"
								id="descricao" required maxlength="100"
								placeholder="descricao" value="${fornecedor.descricao }">
						</div>
					</div>
                        <hr />
                        <div id="actions" class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary" name="command" value="AlterarFornecedor">Salvar</button>
                                <a href="ListarFornecedor.jsp" class="btn btn-default">Cancelar</a>
                            </div>
                        </div>
                    </form>
                </div>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>