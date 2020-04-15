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

<div id="main" class="container">
		<h3 class="page header">Cadastro de Categoria</h3>
		<form action="ManterCategoria.do" method="post">
			<div class="row">
				<div class="form-group col-md-12">
					<label for="nomeCategoria"> Nome: </label> <input type="text"
						class="form-control" name="nomeCategoria" id="nomeCategoria" required
						maxlength="100" placeholder="nomeCategoria" />
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label for="status"> Status: </label> <input type="text"
						class="form-control" name="status" id="status" required
						maxlength="100" placeholder="status" />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label for="descricao"> Descrição: </label> <input type="text"
						class="form-control" name="descricao" id="descricao" required
						maxlength="100" placeholder="Descricao" />
				</div>
			</div>
		<hr/>
		<div id="action" class="row">
			<div class="col-md-12">
				<button type="submit" class="btn btn-primary" name="acao" value="Criar">Salvar</button>
			</div>
		</div>
		</form>
</div>

<script src= "js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>