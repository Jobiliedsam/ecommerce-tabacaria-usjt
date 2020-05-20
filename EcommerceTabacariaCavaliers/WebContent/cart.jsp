<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
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
		<meta charset="UTF-8">
		<title>Cadastro Cliente</title>
	</head>
	<body>
		<c:import url="./componentes/header.jsp"></c:import>
		<main>
			<div id="cart-page">
				<div class="container">
					<div class="row">
						<div class="col">
							<h3>Lista de Produtos</h3>
						</div>
					</div>
					<c:forEach var="produtoCarrinho" items="${produtosCarrinho}" varStatus="loop">
						<div class="row item">
							<div class="col-1 col-md-1 trash">
								<a href="controller.do?command=Carrinho&itemRemove=${loop.index}"><i
										class="fas fa-trash"></i></a>
							</div>
							<div class="col-2">
								<figure>
									<img src="./imagens/produtos/${produtoCarrinho.nomeDoProduto}_0.jpg">
								</figure>
							</div>
							<div class="col cart-p-name">
								<span> ${produtoCarrinho.nomeDoProduto } </span>
							</div>
							<div class="col-2">
								<span class="price"> ${produtoCarrinho.precoUnitario } </span>
							</div>
							<form class="col-2 cart-p-quantity" action="controller.do" method="post">
								<div class="input-group">
									<input type="hidden" name="idProduto" value="${produtoCarrinho.idProduto}"> <input
										type="text" name="qtd" id="qtd" class="form-control input-number"
										value="${produtoCarrinho.quantidadeProduto}"> <span class="input-group-btn">
										<button type="submit" class="quantity-right-plus btn btn-success btn-number"
											name="command" value="Carrinho">
											<span class="glyphicon glyphicon-minus"></span>
										</button>
									</span>
								</div>
							</form>
							<div class="col-2">
								<span class="price"> ${produtoCarrinho.precoUnitario *
									produtoCarrinho.quantidadeProduto} </span>
							</div>
						</div>
					</c:forEach>
					<div class="row">
						<div class="col offset-9 no-padding">
							<div class="buy-button">
								<a class="learn-more" href="index.jsp" title="Continuar Comprando">Continuar
									Comprando</a>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<h3>Consultar Frete</h3>
						</div>
					</div>
					<div class="row">
						<div class="col ship">
							<form>
								<label>Digite o CEP</label> <input type="text" name="" id="">
								<button type="submit">
									<i class="fas fa-search"></i>
								</button>
							</form>
						</div>
					</div>
					<div class="row">
						<div class="col offset-9 total-infos">
							<p>
								<strong>Sub-Total: ${orderHeader.valorTotal}</strong> <span></span>
							</p>
							<p>
								<strong>Valor do Frete:</strong> <span>R$ 19,90</span>
							</p>
							<p>
								<strong>Total:</strong> <span>R$ 79,90</span>
							</p>
						</div>
					</div>
					<div class="row">
						<div class="col offset-9 no-padding">
							<div class="buy-button">
								<a class="learn-more" href="request.jsp" title="Finalizar Compra">Finalizar Compra</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
		<c:import url="./componentes/footer.jsp"></c:import>
		<div id="back-to-top">
			<i class="fas fa-chevron-up"></i>
		</div>
		<script src="./js/backtotop.js"></script>
	</body>
</html>