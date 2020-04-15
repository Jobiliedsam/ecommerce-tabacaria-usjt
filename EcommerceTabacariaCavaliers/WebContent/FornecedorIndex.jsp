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

<title>Fornecedor</title>

</head>
<body>

	<div id="main" class="container">
		<h3 class="page header">Cadastro de Fornecedor</h3>
		<form action="ManterFornecedor.do" method="post">
			<div class="row">
				<div class="form-group col-md-12">
					<label for="nomeFornecedor"> Nome: </label> <input type="text"
						class="form-control" name="nomeFornecedor" id="nomeFornecedor"
						required maxlength="100" placeholder="nomeFornecedor" />
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label for="cnpj"> Cnpj: </label> <input type="number"
						class="form-control" name="cnpj" id="cnpj" required
						maxlength="100" placeholder="cnpj" />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label for="contatoTelefone"> Telefone: </label> <input
						type="number" class="form-control" name="contatoTelefone"
						id="contatoTelefone" required maxlength="100"
						placeholder="contatoTelefone" />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label for="contatoEmail"> Email: </label> <input
						type="email" class="form-control" name="contatoEmail"
						id="contatoEmail" required maxlength="100"
						placeholder="contatoEmail" />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label for="descricao"> Descricao: </label> <input
						type="text" class="form-control" name="descricao"
						id="descricao" required maxlength="100"
						placeholder="descricao" />
				</div>
			</div>
			<hr />
			<div id="action" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="acao"
						value="Criar">Salvar</button>
				</div>
			</div>
		</form>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>