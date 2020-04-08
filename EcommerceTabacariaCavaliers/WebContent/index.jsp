<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="./css/style.css">
    
    <link rel="stylesheet" href="./css/fontawesome.min.css">
    
    <link rel="stylesheet" href="./css/slider_gallery.css">
    <link rel="stylesheet" href="./css/banner_slider.css">
    <link rel="stylesheet" href="./css/admin.css">

    <link href="https://fonts.googleapis.com/css?family=Lobster&display=swap" rel="stylesheet"> 
    <link href="https://fonts.googleapis.com/css?family=Fira+Sans&display=swap" rel="stylesheet">  
    <title>Home</title>
</head>
	<body>
		<jsp:include page="./componentes/header.html"></jsp:include>
        
        <main>

            <jsp:include page="./componentes/banner_home.html"></jsp:include>

            <section class="product-showcase">
                <jsp:include page="./componentes/product_slide_gallery.html"></jsp:include>
            </section>
            
            <section class="product-grid">
                <div class="container">
                <jsp:useBean id="produtosService" class="br.com.cavaliers.tabacaria.service.ProdutoService"></jsp:useBean>
   	 <div class="row">
   	 <!--  Inicio do forEach -->
   	 	<c:forEach var="produtos" items="${produtosService.carregarAll()}">
        <div class="col-lg-6 shadow mb-5">
                    <div class="media align-items-lg-center flex-lg-row m-3" >
                        <img src="./imagens/produtos/isqueiro.jpg" alt="" width="500" class="ml-lg-3 order-2 order-lg-2">
                        <div class="media-body">
                            <h5 class="mt-10">${produtos.nomeP}</h5>
                            <p class="font-italic text-muted mb-0 small">${produtos.descricao }</p>
                            <div class="d-flex align-items-center justify-content-between mt-2">
                                <h4 class="font-weight-bold my-2">R$ ${produtos.precoF }</h4>
                        <div>
                        <!-- Adicionar ao carrinho -->
                <a class="add-to-cart" href="./cart.jsp" title="Adicionar ao Carrinho">
                    <i class="fas fa-cart-plus"></i>
                </a>
                <!-- Levar a pagina do produto -->
                <a class="learn-more" href="./product.jsp" title="Saiba mais">Saiba Mais</a>
            </div>
                            </div>
                        </div>
                    </div>
                </div>
               </c:forEach>
                <!-- Fim do forEach -->
             </div>
             </div>
            </section>

        </main>
        
        <jsp:include page="./componentes/footer.html"></jsp:include>

        <jsp:include page="./componentes/administration.html"></jsp:include>
        
        <div id="back-to-top"><i class="fas fa-chevron-up"></i></div>

        <script src="./js/backtotop.js"></script>
        <script src="./js/banner_slider.js"></script>
        <script src="./js/slider_gallery.js"></script>
	</body>
</html>