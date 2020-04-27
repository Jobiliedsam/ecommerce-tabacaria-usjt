<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">

        <link rel="stylesheet" href="./css/bootstrap-grid.css">
        <link rel="stylesheet" href="./css/bootstrap-grid.min.css">
        <link rel="stylesheet" href="./css/bootstrap-reboot.css">
        <link rel="stylesheet" href="./css/bootstrap.css">
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <link rel="stylesheet" href="./css/fontawesome.min.css">
        <link rel="stylesheet" href="./css/style.css">
        <link rel="stylesheet" href="./css/admin.css">

        <link
            href="https://fonts.googleapis.com/css?family=Lobster&display=swap"
            rel="stylesheet">
        <link
            href="https://fonts.googleapis.com/css?family=Fira+Sans&display=swap"
            rel="stylesheet">

        <title>Buscar Fornecedor</title>
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

							<!-- Modal -->
                            <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                                            </button>
                                            <h4 class="modal-title" id="modalLabel">Excluir Fornecedor</h4>
                                        </div>
                                        <div class="modal-body">
                                            Deseja excluir este fornecedor?
                                        </div>
                                        <div class="modal-footer">
                                            <form action="controller.do" method="post">
                                                <input type="hidden" name="id" id="id_excluir" />
                                                <button type="submit" class="btn btn-primary" name="command" value="ExcluirFornecedor">Sim</button>
                                                <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /.modal -->
                            <!-- Barra superior com os menus de navega��o -->
                            <!-- Container Principal -->
                            <div id="main" class="container">
                                <form action="controller.do" method="post">
                                    <div id="top" class="row">
                                        <div class="col-md-3">
                                            <h2>Fornecedor</h2>
                                        </div>
                
                                        <div class="col-md-6">
                                            <div class="input-group h2">
                                                <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Fornecedor">
                                                <span class="input-group-btn">
                                <button class="btn btn-primary" type="submit" name="command" value="ListarFornecedor">
                                    <span class="glyphicon glyphicon-search"></span>
                                                Pesquisar
                                                 </button>
                                                </span>
                                            </div>
                                        </div>
                
                                        <div class="col-md-3">
                                            <a href="CriarFornecedor.jsp" class="btn btn-primary pull-right h2">Novo Fornecedor</a>
                                        </div>
                                    </div>
                                    <!-- /#top -->
                                </form>
                                <hr />
                                <c:if test="${not empty lista}">
                                <div id="list" class="row">
                
                                    <div class="table-responsive col-md-12">
                                        <table class="table table-striped" cellspacing="0" cellpadding="0">
                                            <thead>
                                                <tr>
                                                    <th>ID</th>
                                                    <th>Nome</th>
                                                    <th>Cnpj</th>
                                                    <th>Telefone</th>
                                                    <th>E-Mail</th>
                                                    <th>Descri�ao</th>
                                                    <th class="actions">A��es</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                              <c:forEach var="fornecedor" items="${lista }">
                                                       <tr>
                                                            <td>
                                                               ${fornecedor.idFornecedor }
                                                            </td>
                                                            <td>
                                                                ${fornecedor.nomeFornecedor }
                                                            </td>
                                                            <td>
                                                                ${fornecedor.cnpj }
                                                            </td>
                                                            <td>
                                                                ${fornecedor.contatoTelefone }
                                                            </td>
                                                            <td>
                                                                ${fornecedor.contatoEmail }
                                                            </td>
                                                            <td>
                                                                ${fornecedor.descricao }
                                                            </td>
                                                            <td class="actions">
                                                                <a class="btn btn-success btn-xs" href="controller.do?command=VisualizarFornecedor&id=${categoria.idFornecedor }">Visualizar</a>
                                                                <a class="btn btn-warning btn-xs" href="controller.do?command=EditarFornecedor&id=${fornecedor.idFornecedor }">Editar</a>
                                                                <button id="btn${fornecedor.idFornecedor }"  
                                                                type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete-modal" data-fornecedor="${fornecedor.idFornecedor }">Excluir</button>
                                                            </td>
                                                        </tr>
                                            </c:forEach>
                
                                            </tbody>
                                        </table>
                
                                    </div>
                                </div>
                            <!-- /#main -->
                            <!-- /#list -->

                            <div id="bottom" class="row">
                                <div class="col-md-12">
                                    <!-- pagina��o ainda n�o foi implementada -->
                                    <ul class="pagination">
                                        <li class="disabled"><a>&lt; Anterior</a>
                                        </li>
                                        <li class="disabled"><a>1</a>
                                        </li>
                                        <li><a href="#">2</a>
                                        </li>
                                        <li><a href="#">3</a>
                                        </li>
                                        <li class="next"><a href="#" rel="next">Pr�ximo &gt;</a>
                                        </li>
                                    </ul>
                                    <!-- /.pagination -->
                                </div>
                            </div>
                            </c:if>
                            <!-- /#bottom -->
            </div>
            <!-- /#main -->
            <div id="back-to-top"><i class="fas fa-chevron-up"></i></div>
		
            <script src="./js/backtotop.js"></script>
            <script src="js/jquery.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script type="text/javascript">
                $("#delete-modal").on('show.bs.modal', function(event) {
                    var button = $(event.relatedTarget); //botao que disparou a modal
                    var recipient = button.data('fornecedor');
                    $("#id_excluir").val(recipient);
                });
            </script>
    </body>
</html>