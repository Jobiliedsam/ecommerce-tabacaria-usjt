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

	<link href="https://fonts.googleapis.com/css?family=Lobster&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Fira+Sans&display=swap" rel="stylesheet">

<title>Categoria </title>

</head>
<body>

<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Incluir Categoria</h3>
		<!-- Formulario para inclusao de pais -->
		<form action="controller.do" method="post">
			<!-- area de campos do form -->
			<div class="row">
				<div class="form-group col-md-12">
					<p><label for="nomeCategoria">Nome</label></p>
					 <input type="text" class="form-control" name="nomeCategoria" id="nomeCategoria" required maxlength="100" placeholder="nome completo">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label for="status">Status</label> <input type="text"
						class="form-control" name="status" id="status" maxlength="15"
						placeholder="status">

				</div>
				<div class="form-group col-md-12">
					<label for="descricao">Descricao</label> <input type="text"
						class="form-control" name="descricao" id="descricao" required
						maxlength="60" placeholder="descricao">

				</div>
			</div>
			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="command"
						value="CriarCategoria">Salvar</button>
					<a href="CategoriaLista.jsp" class="btn btn-default">Voltar</a>
				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>