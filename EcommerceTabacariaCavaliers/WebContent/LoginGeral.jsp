<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="br.com.cavaliers.tabacaria.model.Usuario"%>
<%@page import="br.com.cavaliers.tabacaria.dao.UsuarioDAO"%>

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

		<title>Login</title>
	</head>
	<body>

		<jsp:include page="./componentes/header.jsp"></jsp:include>
		<main>
			<%
				Usuario usuario = (Usuario) request.getAttribute("usuario");
				String email = request.getParameter("email");
				String senha = request.getParameter("senha");	
			%>

			<jsp:include page="./componentes/login.html"></jsp:include>

		</main>

		<jsp:include page="./componentes/footer.jsp"></jsp:include>
		
		<div id="back-to-top"><i class="fas fa-chevron-up"></i></div>
        <script src="./js/backtotop.js"></script>	
	</body>
</html>