<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="br.com.cavaliers.tabacaria.model.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro_Usuario</title>
</head>
<body>
	<%Usuario usuario = (Usuario)request.getAttribute("usuario"); %>
	Id: <%=usuario.getId() %><br>
	Email: <%=usuario.getEmail() %><br>
	Password: <%=usuario.getPassword() %><br>
	
</body>
</html>