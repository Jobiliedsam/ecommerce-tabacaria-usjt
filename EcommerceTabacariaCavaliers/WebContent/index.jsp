<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    
    <link rel="stylesheet" href="./css/banner_slider.css">
    <link rel="stylesheet" href="./css/bootstrap-grid.css">
    <link rel="stylesheet" href="./css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="./css/bootstrap-reboot.css">
    <link rel="stylesheet" href="./css/bootstrap.css">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/fontawesome.min.css">
    <link rel="stylesheet" href="./css/slider_gallery.css">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/admin.css.css">

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
                <jsp:include page="./componentes/product_grid.html"></jsp:include>
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