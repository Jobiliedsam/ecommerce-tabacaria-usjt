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

<title>Cadastro do Usuario</title>

</head>
<body>

	<div id="main" class="container">
		<h3 class="page header">Cadastre seu Usuario</h3>
		<form action="ManterUsuario.do" method="post">
			<div class="row">
				<div class="form-group col-md-8">
					<label for="email"> Email: </label> <input type="email"
						class="form-control" name="email" id="email" required
						maxlength="50" placeholder="email" />
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-8">
					<label for="password"> Senha:</label> <input type="password"
						class="form-control" name="password" id="password" required
						size="20" maxlength="20" placeholder="password" />
				</div>
			</div>
			<hr />
			<div id="action" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="acao"
						value="criar">Salvar</button>
				</div>
			</div>
		</form>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>