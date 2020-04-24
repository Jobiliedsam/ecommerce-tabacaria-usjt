<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>CAVALIERS - Visualizar Categoria</title>

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
        </head>

        <body>
                <!-- Modal Não implementado -->
                <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                                </button>
                                <h4 class="modal-title" id="modalLabel">Excluir Usuario</h4>
                            </div>
                            <div class="modal-body">
                                Deseja excluir este Usuario?
                            </div>
                            <div class="modal-footer">
                                <form action="controller.do" method="post">
                                    <input type="hidden" name="id" value="${usuario.id }" />
                                    <button type="submit" class="btn btn-primary" name="command" value="ExcluirUsuario">Sim</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.modal -->
                <!-- Barra superior com os menus de navegação -->
                <!-- Container Principal -->
                <div id="main" class="container">
                    <h3 class="page-header">Visualizar Usuario ${usuario.id }</h3>
                    <div class="row">
                        <div class="col-md-12">
                            <p><strong>Email</strong>
                            </p>
                            <p>
                                ${usuario.email }
                            </p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <p><strong>Password</strong>
                            </p>
                            <p>
                                ${usuario.password }
                            </p>
                        </div>
                    </div>
                    <hr />
                    <div id="actions" class="row">
                        <div class="col-md-12">
                            <a href="controller.do?command=EditarUsuario&id=${usuario.id }" class="btn btn-primary">Editar</a>
                            <a href="controller.do?command=ExcluirUsuario&id=${usuario.id }" class="btn btn-danger">Excluir</a>
                            <a href="UsuarioLista.jsp" class="btn btn-default">Voltar</a>
                        </div>
                    </div>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>