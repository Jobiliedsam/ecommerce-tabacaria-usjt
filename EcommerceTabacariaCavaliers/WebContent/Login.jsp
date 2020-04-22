<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="br.com.cavaliers.tabacaria.model.Usuario"%>
<%@page import="br.com.cavaliers.tabacaria.dao.UsuarioDAO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%
	Usuario usuario = (Usuario) request.getAttribute("usuario");
	String email = request.getParameter("email");
	String senha = request.getParameter("senha");
	boolean status = usuario.verificausuario(email, senha);
	
	%>
	

</body>
</html>