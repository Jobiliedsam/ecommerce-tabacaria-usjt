<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cavaliers - Alterar Cliente</title>

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
                                <h3 class="page-header">Alterar Cliente #${cliente.idCliente }</h3>
                                <!-- Formulario para alteração de clientes -->
                                <form action="controller.do" method="post">
                                    <!-- area de campos do form -->
                                    <input type="hidden" name="id" value="${cliente.idCliente }" />
                                    <div class="row">
                                        <div class="form-group col-md-12">
                                            <label for="nomeCliente">Nome</label>
                                            <input type="text" class="form-control" name="nomeCliente" id="nomeCliente" required maxlength="100" placeholder="Cliente" value="${cliente.nomeCompleto }">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-12">
                                            <label for="celularCliente">Celular</label>
                                            <input type="tel" class="form-control" name="celularCliente" id="celularCliente" maxlength="11"  placeholder="celular" value="${cliente.celular }">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-12">
                                            <label for="telefoneCliente">Telefone</label>
                                            <input type="tel" class="form-control" name="telefoneCliente" id="telefoneCliente" maxlength="11"  placeholder="telefone" value="${cliente.telefone }">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-12">
                                            <label for="emailCliente">Email</label>
                                            <input type="email" class="form-control" name="emailCliente" id="emailCliente" maxlength="50"  placeholder="@cavaliers" value="${cliente.email }">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-12">
                                            <label for="generoCliente">Genero</label>
                                            <input type="text" class="form-control" name="generoCliente" id="generoCliente" maxlength="10"  placeholder="genero" value="${cliente.genero}">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-12">
                                            <label for="cpfCliente">Cpf</label>
                                            <input type="number" class="form-control" name="cpfCliente" id="cpfCliente" maxlength="11"  placeholder="cpf" value="${cliente.cpfCnpj }">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-12">
                                            <label for="Física">Tipo</label>
                                            <input type="text" class="form-control" name="Física" id="Física" maxlength="11"  placeholder="Física" value="${cliente.tipo }">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-12">
                                            <label for="DataDeNascimento">DataDeNascimento</label>
                                            <input type="date" class="form-control" name="DataDeNascimento" id="DataDeNascimento" maxlength="08"  placeholder="DataDeNascimento" value="${cliente.dataDeNascimento }">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-12">
                                            <label for="rg">RG</label>
                                            <input type="number" class="form-control" name="rg" id="rg" maxlength="11"  placeholder="rg" value="${cliente.rg}">
                                        </div>
                                    </div>
                                    <hr />
                                    <div id="actions" class="row">
                                        <div class="col-md-12">
                                            <button type="submit" class="btn btn-primary" name="command" value="AlterarCliente">Salvar</button>
                                            <a href="ClienteLista.jsp" class="btn btn-default">Cancelar</a>
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