<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="br.com.cavaliers.tabacaria.model.Categoria" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro_Categoria</title>
</head>
<body>
	<%Categoria ct = (Categoria)request.getAttribute("categoria"); %>
	Id: <%=ct.getIdCategoria() %><br>
	Nome: <%=ct.getCategoria() %><br>
	Status: <%=ct.getStatus() %><br>
	Descricao: <%=ct.getDescricao() %><br>
</body>
</html>