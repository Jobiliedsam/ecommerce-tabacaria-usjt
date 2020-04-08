<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
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
	<title>Cadastro de Produto</title>
</head>
<body>
	<jsp:include page="./componentes/header.html"></jsp:include>
	
	<section id="cadastro-produto">
	<jsp:useBean id="categoriaService" class="br.com.cavaliers.tabacaria.service.CategoriaService"></jsp:useBean>
	   <div class="container">
	       <h4> Cadastro de Produtos</h4>
	       <form action="ManterProduto.do" method="GET" enctype="multipart/form-data">
	           <div class="row">
	               <div class="col">
	                   <label for="nomeProduto">Nome do Produto</label>
	                   <input type="text" name="nomeProduto" class="form-control">
	               </div>
	           </div>
	           <div class="row">
	               <div class="col">
	                   <label for="precoProduto">Preço Produto</label>
	                   <input type="text" name="precoProduto" class="form-control">
	               </div>
	               <div class="col">
	                   <label for="categoria">Categoria</label>
	                   <select name="categoria" class="form-control">	       
	                   		<c:forEach var="cat" items="${ categoriaService.carregarAll()}">
	                   			<option value="${cat.categoria}">${cat.categoria}</option>
	                   		</c:forEach>
	                    </select>
	                </div>
	            </div>
	            <div class="row">
	                <div class="col">
	                    <label for="descricao">Descrição</label>
	                    <input type="text" name="descricao" class="form-control">
	                </div>
	            </div>
	            <div class="row">
	                <div class="col-3">
	                    <label for="foto">Foto do Produto</label>
	                    <input type="file" name="foto" class="form-control">
	                </div>
	            </div>
	            <div class="row">
	                <div class="col">
	                    <input type="submit" class="form-control" value="Cadastrar">
	                </div>
	            </div>
	        </form>
	    </div>
	</section>

	<jsp:include page="./componentes/footer.html"></jsp:include>

	<jsp:include page="./componentes/administration.html"></jsp:include>

	<div id="back-to-top"><i class="fas fa-chevron-up"></i></div>

	<script src="./js/backtotop.js"></script>
</body>
</html>