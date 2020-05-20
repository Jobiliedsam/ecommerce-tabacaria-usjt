<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Buscar Cliente</title>
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
		<c:import url="./componentes/adm-top.jsp"></c:import>
		<div class="container-fluid">
			<div id="adm-page" class="row">
				<c:import url="./componentes/adm-menu.jsp"></c:import>
                <div id="admin-center" class="col">
                    <div class="row">
                        <div class="col">
                            <!-- Adicionar aqui o conteúdo de administração -->
                            <!-- Modal Não implementado -->
                            <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog"
                                aria-labelledby="modalLabel">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"
                                                aria-label="Fechar"><span aria-hidden="true">&times;</span>
                                            </button>
                                            <h4 class="modal-title" id="modalLabel">Excluir Cliente</h4>
                                        </div>
                                        <div class="modal-body"> Deseja realmente excluir este cliente? </div>
                                        <div class="modal-footer">
                                            <form action="controller.do" method="post">
                                                <input type="hidden" name="id" id="id_excluir" />
                                                <button type="submit" class="btn btn-primary" name="command"
                                                    value="ExcluirCliente">Sim</button>
                                                <button type="button" class="btn btn-default"
                                                    data-dismiss="modal">N&atilde;o</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /.modal -->
                            <!-- Barra superior com os menus de navegação -->
                            <!-- Container Principal -->
                            <div id="main" class="container">
                                <form action="controller.do" method="post">
                                    <div id="top" class="row">
                                        <div class="col-md-3">
                                            <h2>Cliente</h2>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="input-group h2">
                                                <input name="data[search]" class="form-control" id="search" type="text"
                                                    placeholder="Pesquisar Cliente">
                                                <span class="input-group-btn">
                                                    <button class="btn btn-primary" type="submit" name="command"
                                                        value="ListarCliente">Pesquisar <span
                                                            class="glyphicon glyphicon-search"></span>
                                                    </button>
                                                </span>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <a href="singup.jsp" class="btn btn-primary pull-right h2">Novo Cliente</a>
                                        </div>
                                    </div>
                                    <!-- /#top -->
                                </form>
                                <hr />
                                <c:if test="${not empty listaCliente}">
                                    <div id="list" class="row">
                                        <div class="table-responsive col-md-12">
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>
                                                        <th>ID</th>
                                                        <th>Nome</th>
                                                        <th>Celular</th>
                                                        <th>Telefone</th>
                                                        <th>Email</th>
                                                        <th>Genero</th>
                                                        <th>Cpf</th>
                                                        <th>Tipo</th>
                                                        <th>DataNascimento</th>
                                                        <th class="actions">Ações</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="cliente" items="${listaCliente }">
                                                        <tr>
                                                            <td> ${cliente.idCliente } </td>
                                                            <td> ${cliente.nomeCompleto} </td>
                                                            <td> ${cliente.celular} </td>
                                                            <td> ${cliente.telefone } </td>
                                                            <td> ${cliente.email } </td>
                                                            <td> ${cliente.genero} </td>
                                                            <td> ${cliente.cpfCnpj} </td>
                                                            <td> ${cliente.tipo } </td>
                                                            <td> ${cliente.dataDeNascimento } </td>
                                                            <td> ${cliente.rg} </td>
                                                            <td class="actions">
                                                                <a class="btn btn-success btn-xs"
                                                                    href="controller.do?command=VisualizarCliente&id=${cliente.idCliente }">Visualizar</a>
                                                                <a class="btn btn-warning btn-xs"
                                                                    href="controller.do?command=EditarCliente&id=${cliente.idCliente }&id=${endereco.idEndereco}">Editar</a>
                                                                <a class="btn btn-danger btn-xs"
                                                                    href="controller.do?command=ExcluirCliente&id=${cliente.idCliente}&idUsuario=${usuario.idUsuario}&idEndereco=${endereco.idEndereco}">Excluir</a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <!-- /#list -->
                                    <div id="bottom" class="row">
                                        <div class="col-md-12">
                                            <!-- paginação ainda não foi implementada -->
                                            <ul class="pagination">
                                                <li class="disabled"><a>&lt; Anterior</a>
                                                </li>
                                                <li class="disabled"><a>1</a>
                                                </li>
                                                <li><a href="#">2</a>
                                                </li>
                                                <li><a href="#">3</a>
                                                </li>
                                                <li class="next"><a href="#" rel="next">Próximo &gt;</a>
                                                </li>
                                            </ul>
                                            <!-- /.pagination -->
                                        </div>
                                    </div>
                                </c:if>
                                <!-- /#bottom -->
                            </div>
                            <!-- /#main -->
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
        <script type="text/javascript">
            $("#delete-modal").on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget); //botao que disparou a modal
                var recipient = button.data('cliente');
                $("#id_excluir").val(recipient);
            });
        </script>
    </body>
</html>