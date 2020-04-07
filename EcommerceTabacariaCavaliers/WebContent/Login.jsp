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
	%>
	Id:
	<%=usuario.getId()%><br> Email
	<%=usuario.getEmail()%><br> Password
	<%=usuario.getPassword()%><br>
	<%//verifica usuario
		boolean status = usuario.verificausuario();
	%>

	<%//resultado
		//if (usuario.result == true) {
		//out.print("login feito com sucesso");
	} //else {
		//out.println("email ou senha invalidos ");
	}
	%>
</body>
</html>