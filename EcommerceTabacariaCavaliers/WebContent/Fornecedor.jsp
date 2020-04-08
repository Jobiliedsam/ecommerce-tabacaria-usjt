<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="br.com.cavaliers.tabacaria.model.Fornecedor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro_Fornecedor</title>
</head>
<body>

	<%Fornecedor fornecedor = (Fornecedor)request.getAttribute("fornecedor"); %>
	Id: <%=fornecedor.getIdFornecedor() %><br>
	Nome: <%=fornecedor.getNomeFornecedor() %><br>
	Telefone: <%=fornecedor.getContatoTelefone() %><br>
	Descricao: <%=fornecedor.getDescricao() %><br>
</body>
</html>