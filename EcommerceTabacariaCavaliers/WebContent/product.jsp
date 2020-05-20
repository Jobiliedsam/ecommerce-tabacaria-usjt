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
                            <img id="product-img-ative" src="./imagens/produtos/${produtoDesc.nomeP}_0.jpg">
                            <div class="product-img-gallery">
                                <img src="./imagens/produtos/${produtoDesc.nomeP}_1.jpg">
                                <img src="./imagens/produtos/${produtoDesc.nomeP}_2.jpg">
                            </div>
                        </div>
                        <div class="col-5 produtc-infos">
                            <h1 class="product-name">
                                <c:out value="${produtoDesc.nomeP}"></c:out>
                            </h1>
                            <p class="product-price">
                                <span class="price-currency">R$ </span>
                                <span class="price-fraction">${produtoDesc.precoF}</span>
                            </p>
                            <p class="product-small-desc">
                            </p>
                            <div class="product-meta">
                                <p>
                                    <span>Categoria: </span>
                                    <span class="product-sku">${produtoDesc.categoria}</span>
                                </p>
                                <p>
                                    <span>Fornecedor: </span>
                                    <span class="product-brand">${produtoDesc.fornecedor}</span>
                                </p>
                                <p>
                                    <span>Código do Produto: </span>
                                    <span class="product-reference">${produtoDesc.idProduto}</span>
                                </p>
                                <p>
                                    <span>Disponibilidade: </span>
                                    <span class="product-quantity">${produtoDesc.quantidade} itens</span>
                                </p>
                            </div>
                            <div class="buy-button">
                                <!-- Adicionar ao Carrinho e comprar-->
                                <a href="controller.do?command=Carrinho&idProduto=${produtoDesc.idProduto}"
                                    title="Adicionar ao carrinho">
                                    <i class="fas fa-cart-plus"></i>
                                </a>
                                <button type="submit" title="Comprar">Comprar</button>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col product-description">
                            <div class="item">
                                <!-- Esses itens nÃ£o precisam estar assim, pode ser apenas um texto em vez de lista -->
                                <h3>Descrição</h3>
                                <ul class="description-box">
                                    <li>${produtoDesc.descricao}</li>
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