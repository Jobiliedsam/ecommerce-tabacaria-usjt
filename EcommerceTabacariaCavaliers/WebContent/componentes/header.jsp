<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- SessÃ£o Header -->
<header>
    <div id="header-top" class="white">
        <div class="container">
            <div class="row">
                <div class="col">
                    <span>Bem vindo</span>
                </div>
                <div class="col">
                    <i class="fas fa-phone"></i>
                    <!-- Pegar fone no sistema-->
                    <a href="tel:1199999999">(11) 9999 - 9999</a>
                </div>
                <div class="col">
                    <i class="fab fa-whatsapp"></i>
                    <!-- Pegar Whatsapp no sistema-->
                    <a href="tel:1199999999">(11) 99999 - 9999</a>
                </div>
            </div>
        </div>
    </div>
    <div id="header-middle">
        <div class="container">
            <div class="row">
                <div class="col-3 logo">
                    <a href="./index.jsp">
                    	<img src="./imagens/logo.png" onclick="index.jsp" />
                    </a>
                    
                </div>
                <div class="col-6 search-bar">
                    <form>
                        <!-- Aqui integraÃ§Ã£o-->
                        <input type="text" name="" id="">
                        <button type="submit"><i class="fas fa-search"></i></button>
                    </form>
                </div>
                <div class="col-2 login-display">
                	<span><a href="UsuarioIndex.jsp">Logar</a></span>
                    <!-- Nome da pessoa logada, tambÃ©m pode ser um link para pagina de gerenciamento de pedidos-->
                    <span><a href="singup.jsp">Cliente</a></span>
                </div>
                <div class="col-1 shop-cart">
                    <!-- InformaÃ§Ã£o de quantos itens tem no carrinho dentro do span -->
                    <!-- Precisa link copm atela de Carrinho -->
                    <a href="cart.jsp" id="cart"><i class="fas fa-shopping-cart"><span id="products-number">00</span></i></a>
                </div>
            </div>
        </div>
    </div>
    <div id="header-bottom">
        <div class="container">
            <div class="row">
                <div class="col-9 menu-categories">
                    <!-- Se possivel isso pode ser dinÃ¢mico com banco de dados 
                    RestricÃ£o para quantidade que ira aparecer-->
                    <ul>

                        <li><a href="controller.do?command=SairLogin">Sair</a></li>
                    </ul>
                </div>
                <div class="col-3 questions white">
                    <!-- Abrir pagina de contato ou chat -->
                    <a href="#">Tire suas duvidas</a>
                </div>
            </div>
        </div>
    </div>    
</header>
