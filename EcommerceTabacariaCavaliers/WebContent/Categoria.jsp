<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="br.com.cavaliers.tabacaria.model.Categoria" %>
<!DOCTYPE htmls>
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