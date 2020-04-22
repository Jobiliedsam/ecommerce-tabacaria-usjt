<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Cavaliers - Alterar Categoria</title>

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
			
            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">
    
            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">
        </head>

        <body>
                <!-- Barra superior com os menus de navegação -->
                <!-- Container Principal -->
                <div id="main" class="container">
                    <h3 class="page-header">Alterar Categoria #${categoria.idCategoria }</h3>
                    <!-- Formulario para alteração de clientes -->
                    <form action="controller.do" method="post">
                        <!-- area de campos do form -->
                        <input type="hidden" name="id" value="${categoria.idCategoria }" />
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label for="nome">Nome</label>
                                <input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="nome completo" value="${categoria.nomeCategoria }">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label for="status">Status</label>
                                <input type="text" class="form-control" name="status" id="status" maxlength="15"  placeholder="status" value="${categoria.status }">
                            </div>

                            <div class="form-group col-md-12">
                                <label for="descricao">Descricao</label>
                                <input type="text" class="form-control" name="descricao" id="descricao" required maxlength="60" placeholder="descricao" value="${categoria.descricao }">
                            </div>
                        </div>
                        <hr />
                        <div id="actions" class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary" name="command" value="AlterarCategoria">Salvar</button>
                                <a href="CategoriaLista.jsp" class="btn btn-default">Cancelar</a>
                            </div>
                        </div>
                    </form>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>