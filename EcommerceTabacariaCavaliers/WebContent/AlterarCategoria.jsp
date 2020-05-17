<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cavaliers - Alterar Pedido</title>

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
        

    </head>

    <body>

        <jsp:include page="./componentes/adm-top.jsp"></jsp:include>
		
		<div class="container-fluid">
			<div id="adm-page" class="row">

				<jsp:include page="./componentes/adm-menu.jsp"></jsp:include>

				<div id="admin-center" class="col">
					<div class="row">
						<div class="col">
							<!-- Adicionar aqui o conteúdo de administração -->

							<!-- Barra superior com os menus de navegação -->
                            <!-- Container Principal -->
                            <div id="main" class="container">
                                <h3 class="page-header">Alterar Pedido - ${pedidoHeader.idPedido }</h3>
                                <!-- Formulario para alteração de clientes -->
                                <form action="controller.do" method="post">
                                    <!-- area de campos do form -->
                                    <input type="hidden" name="id" value="${pedido.idPedido }" />
                                    <div class="row">
                                        <div class="form-group col-md-12">
                                            <label for="nomeCliente">Nome Cliente</label>
                                            <input type="text" class="form-control" name="nomeCliente" id="nomeCliente" required maxlength="100" placeholder="nome completo" value="${pedidoHeader.nomeCliente}">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-12">
                                            <label for="qtdItens">Quatidade de Itens</label>
                                            <input type="number" class="form-control" name="qtdItens" id="qtdItens" maxlength="15"  placeholder="Quantidade de Itens" value="${pedidoHeader.qtdItens }">
                                        </div>

                                        <div class="form-group col-md-12">
                                            <label for="valorTotal">Valor Total</label>
                                            <input type="number" class="form-control" name="valorTotal" id="valorTotal" required maxlength="60" placeholder="Valor Total" value="${pedidoHeader.valorTotal }">
                                        </div>
                                    </div>
                                    <hr />
                                    <div id="actions" class="row">
                                        <div class="col-md-12">
                                            <button type="submit" class="btn btn-primary" name="command" value="AlterarPedidoHeader">Salvar</button>
                                            <a href="ListarPedidoHeaderTeste.jsp" class="btn btn-default">Cancelar</a>
                                        </div>
                                    </div>
                                </form>
                            </div>

							<!-- Fim -->
						</div>
					</div>
				</div>
			</div>
		</div>

        <div id="back-to-top"><i class="fas fa-chevron-up"></i></div>
		
		<script src="./js/backtotop.js"></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>