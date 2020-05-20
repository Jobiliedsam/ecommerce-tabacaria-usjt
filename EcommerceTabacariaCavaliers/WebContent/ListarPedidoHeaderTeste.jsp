<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Buscar Pedido</title>

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

							<!-- Modal Não implementado -->
                            <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                                            </button>
                                            <h4 class="modal-title" id="modalLabel">Excluir Pedido</h4>
                                        </div>
                                        <div class="modal-body">
                                            Deseja excluir este pedido?
                                        </div>
                                        <div class="modal-footer">
                                            <form action="controller.do" method="post">
                                                <input type="hidden" name="id" id="id_excluir" />
                                                <button type="submit" class="btn btn-primary" name="command" value="ExcluirPedidoHeader">Sim</button>
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
                                <form action="controller.do" method="post">
                                    <div id="top" class="row">
                                        <div class="col-md-3">
                                            <h2>Pedido Header</h2>
                                        </div>
                
                                        <div class="col-md-6">
                                            <div class="input-group h2">
                                                <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Pedido">
                                                <span class="input-group-btn">
                                <button class="btn btn-primary" type="submit" name="command" value="ListarPedidoHeader">
                                    <span class="glyphicon glyphicon-search"></span>
                                                Pesquisar
                                                 </button>
                                                </span>
                                            </div>
                                        </div>
                
                                        <div class="col-md-3">
                                            <a href="CriarPedidoHeaderTeste.jsp" class="btn btn-primary pull-right h2">Novo Pedido</a>
                                        </div>
                                    </div>
                                    <!-- /#top -->
                                </form>
                                <hr />
                                <c:if test="${not empty listaPedidoHeader}">
                                    <div id="list" class="row">
                    
                                        <div class="table-responsive col-md-12">
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>
                                                        <th>ID</th>
                                                        <th>ID Cliente</th>
                                                        <th>Nome Cliente</th>
                                                        <th>Quantidade de Itens</th>
                                                        <th>Valor Total</th>
                                                        <th class="actions">Ações</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="pedidoHeader" items="${listaPedidoHeader }">
                                                        <tr>
                                                                <td>
                                                                ${pedidoHeader.idPedido }
                                                                </td>
                                                                <td>
                                                                    ${pedidoHeader.idCliente }
                                                                </td>
                                                                <td>
                                                                    ${pedidoHeader.nomeCliente }
                                                                </td>
                                                                <td>
                                                                    ${pedidoHeader.qtdItens }
                                                                </td>
                                                                <td>
                                                                	${pedidoHeader.valorTotal }
                                                                </td>
                                                                <td class="actions">
                                                                    <a class="btn btn-success btn-xs" href="controller.do?command=VisualizarPedidoHeader&id=${pedidoHeader.idPedido}">Visualizar</a>
                                                                    <a class="btn btn-warning btn-xs" href="controller.do?command=EditarPedidoHeader&id=${pedidoHeader.idPedido}">Editar</a>
                                                                <a class="btn btn-danger btn-xs" href="controller.do?command=ExcluirPedidoHeader&id=${pedidoHeader.idPedido}">Excluir</a>
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
            <!-- /#main -->

        <div id="back-to-top"><i class="fas fa-chevron-up"></i></div>
		
		<script src="./js/backtotop.js"></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script type="text/javascript">
            $("#delete-modal").on('show.bs.modal', function(event) {
                var button = $(event.relatedTarget); //botao que disparou a modal
                var recipient = button.data('pais');
                $("#id_excluir").val(recipient);
            });
        </script>
    </body>
</html>