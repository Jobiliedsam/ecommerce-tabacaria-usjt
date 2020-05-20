<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<title>Login</title>
	</head>
	<body>
	<c:import url="./componentes/header.jsp"></c:import>
		<div id="main" class="container">
			<h3 class="page header">Logar</h3>
			<form action="controller.do" method="post">
				<div class="row">
					<div class="form-group col-md-8">
						<label for="email"> Email: </label> <input type="email" class="form-control" name="email"
							id="email" required maxlength="50" placeholder="email" />
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-8">
						<label for="password"> Senha:</label> <input type="password" class="form-control"
							name="password" id="password" required size="20" maxlength="20" placeholder="password" />
					</div>
				</div>
				<hr />
				<div id="action" class="row">
					<div class="col-md-6">
						<button type="submit" class="btn btn-primary" name="command" value="FazerLogin">Logar</button>
					</div>
				</div>
				<div id="top" class="row">
					<div class="col-md-3">
						<a href="singup.jsp" class="btn btn-primary pull-right h2">Novo Usuario</a>
					</div>
				</div>
			</form>
		</div>
	<c:import url="./componentes/footer.jsp"></c:import>
	</body>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</html>