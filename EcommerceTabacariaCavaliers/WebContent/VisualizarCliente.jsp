<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>CAVALIERS - Visualizar Cliente</title>

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
                                <h4 class="modal-title" id="modalLabel">Excluir Cliente</h4>
                            </div>
                            <div class="modal-body">
                                Deseja excluir este Cliente?
                            </div>
                            <div class="modal-footer">
                                <form action="controller.do" method="post">
                                    <input type="hidden" name="id" value="${cliente.idCliente }" />
                                    <button type="submit" class="btn btn-primary" name="command" value="ExcluirCliente">Sim</button>
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
                    <h3 class="page-header">Visualizar Cliente ${cliente.idCliente }</h3>
                    <div class="row">
                        <div class="col-md-12">
                             <p><strong>Nome</strong>
                            </p>
                            <p>
                                ${cliente.nomeCompleto}
                            </p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <p><strong>Celular</strong>
                            </p>
                            <p>
                                ${cliente.celular}
                            </p>
                        </div>
                        <div class="col-md-12">
                            <p><strong>Telefone</strong>
                            </p>
                            <p>
                                ${cliente.telefone }
                            </p>
                        </div>
                        <div class="col-md-12">
                            <p><strong>Email</strong>
                            </p>
                            <p>
                               ${cliente.email }
                            </p>
                        </div>
                        <div class="col-md-12">
                            <p><strong>Genero</strong>
                            </p>
                            <p>
                                ${cliente.genero }
                            </p>
                        </div>
                        <div class="col-md-12">
                            <p><strong>Cpf</strong>
                            </p>
                            <p>
                                ${cliente.cpfCnpj }
                            </p>
                        </div>
                        <div class="col-md-12">
                            <p><strong>Tipo</strong>
                            </p>
                            <p>
                                ${cliente.tipo }
                            </p>
                        </div>
                        <div class="col-md-12">
                            <p><strong>DataNascimento</strong>
                            </p>
                            <p>
                                ${cliente.dataDeNascimento }
                            </p>
                        </div>
                        <div class="col-md-12">
                            <p><strong>rg</strong>
                            </p>
                            <p>
                                ${cliente.rg }
                            </p>
                        </div>
                    </div>
                    <hr />
                    <div id="actions" class="row">
                        <div class="col-md-12">
                            <a href="Controller.do?command=EditarCliente&id=${cliente.idCliente }" class="btn btn-primary">Editar</a>
                            <a class="btn btn-danger btn-xs" href="Controller.do?command=ExcluirCliente&id=${cliente.idCliente }">Excluir</a>
                            <a href="ClienteLista.jsp" class="btn btn-default">Voltar</a>
                        </div>
                    </div>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>