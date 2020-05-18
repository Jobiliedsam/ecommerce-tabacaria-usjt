<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<jsp:useBean id="produtosService" class="br.com.cavaliers.tabacaria.service.ProdutoService"></jsp:useBean>
<c:set var="produtoDescId" scope="session" value="${param.produtoDescId}"></c:set>
<c:set var="produtoDesc" scope="session" value="${produtosService.carregar(produtoDescId)}"></c:set>
	<body>
		<jsp:include page="./componentes/header.jsp"></jsp:include>
		<main>
			<!-- Produto -->
<div id="product-page">
    <div class="container">
        <div class="row">
            <div class="col-7 product-img">
                <img id="product-img-ative" src="./images/produtos/isqueiro.jpg">
                <div class="product-img-gallery">
                    <img src="./images/produtos/isqueiro.jpg">
                    <img src="./images/produtos/isqueiro.jpg">
                    <img src="./images/produtos/isqueiro.jpg">
                </div>
            </div>
            <div class="col-5 produtc-infos">
                <h1 class="product-name">
                    <c:out value="${produtoDesc}"></c:out>
                </h1>
                <p class="product-promotion">
                    <span>De</span> 
                    <span class="price-currency">R$</span> 
                    <span class="price-fraction">100</span>
                    <span class="price-separator">,</span>
                    <span class="price-decimal">00</span>
                    <span>por</span>
                </p>
                <p class="product-price">
                    <span class="price-currency">R$ </span>                                 
                    <span class="price-fraction">79</span>
                    <span class="price-separator">, </span>
                    <span class="price-decimal">90</span>
                </p>
                <p class="product-small-desc">
                    Descrição curta, exemplo: Esse produto é top, compra logo
                </p>
                <div class="product-meta">
                    <p>
                        <span>REF: </span>
                        <span class="product-sku">REFERENCIADOPRODUTO</span>
                    </p>
                    <p>
                        <span>Marca: </span>
                        <span class="product-brand">Zippo</span>
                    </p>
                    <p>
                        <span>Modelo: </span>
                        <span class="product-model">Normal</span>
                    </p>
                    <p>
                        <span>ReferÃªncia: </span>
                        <span class="product-reference">99999998845412</span>
                    </p>
                    <p>
                        <span>Disponibilidade: </span>
                        <span class="product-quantity">10</span>
                    </p>
                </div>
                <div class="buy-button">
                    <form>
                        <!-- Adicionar ao Carrinho e comprar-->
                        <a href="#" title="Adicionar ao carrinho">
                            <i class="fas fa-cart-plus"></i>
                        </a>
                        <button type="submit" title="Comprar">COMPRAR</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col product-description">
                <div class="item">
                    <!-- Esses itens nÃ£o precisam estar assim, pode ser apenas um texto em vez de lista -->
                    <h3>Descrição</h3>
                    <ul class="description-box">
                        <li>- Info 1</li>
                        <li>- Info 2</li>
                        <li>- Info 3</li>
                        <li>- Info 4</li>
                        <li>- Info 5</li>
                        <li>- Info 6</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
			
		</main>
		<jsp:include page="./componentes/footer.jsp"></jsp:include>
		
		<div id="back-to-top"><i class="fas fa-chevron-up"></i></div>
        <script src="./js/backtotop.js"></script>
	</body>
</html>