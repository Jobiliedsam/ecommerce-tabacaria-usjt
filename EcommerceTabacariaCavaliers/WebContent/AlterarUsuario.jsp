<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cavaliers - Alterar Usuario</title>

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
        

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body>

        <jsp:include page="./componentes/adm-top.html"></jsp:include>
		
		<div class="container-fluid">
			<div id="adm-page" class="row">

				<jsp:include page="./componentes/adm-menu.html"></jsp:include>

				<div id="admin-center" class="col">
					<div class="row">
						<div class="col">
							<!-- Adicionar aqui o conteúdo de administração -->

							<!-- Barra superior com os menus de navegação -->
                            <!-- Container Principal -->
                            <div id="main" class="container">
                                <h3 class="page-header">Alterar Usuario #${usuario.id }</h3>
                                <!-- Formulario para alteração de clientes -->
                                <form action="controller.do" method="post">
                                    <!-- area de campos do form -->
                                    <input type="hidden" name="id" value="${usuario.id }" />
                                    <div class="row">
                                        <div class="form-group col-md-12">
                                            <label for="email">email</label>
                                            <input type="email" class="form-control" name="email" id="email" required maxlength="100" placeholder="@cavaliers" value="${usuario.email}">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-12">
                                            <label for="password">senha</label>
                                            <input type="password" class="form-control" name="password" id="password" maxlength="40"  placeholder="senha" value="${usuario.password}">
                                        </div>
                                    </div>
                                    <hr />
                                    <div id="actions" class="row">
                                        <div class="col-md-12">
                                            <button type="submit" class="btn btn-primary" name="command" value="AlterarUsuario">Salvar</button>
                                            <a href="UsuarioLista.jsp" class="btn btn-default">Cancelar</a>
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