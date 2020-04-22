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
                            Deseja realmente excluir este fornecedor?
                        </div>
                        <div class="modal-footer">
                            <form action="Controller.do" method="post">
                                <input type="hidden" name="id" id="id_excluir" />
                                <button type="submit" class="btn btn-primary" name="command" value="ExcluirFornecedor">Sim</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.modal -->

 <div id="main" class="container">
                <form action="controller.do" method="post">
                    <div id="top" class="row">
                        <div class="col-md-3">
                            <h2>Fornecedores</h2>
                        </div>

                        <div class="col-md-6">
                            <div class="input-group h2">
                                <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Fornecedores (deixe vazio para trazer todos)">
                                <span class="input-group-btn">
                <button class="btn btn-primary" type="submit" name="command" value="ListarFornecedor">
                    <span class="glyphicon glyphicon-search"></span>
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
                                    <th>Descriçao</th>
                                    <th class="actions">Ações</th>
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
                                                <a class="btn btn-success btn-xs" href="Controller.do?command=VisualizarFornecedor&id=${fornecedor.idFornecedor }">Visualizar</a>
                                                <a class="btn btn-warning btn-xs" href="Controller.do?command=EditarFornecedor&id=${fornecedor.idFornecedor }">Editar</a>
                                                <button id="btn${fornecedor.idFornecedor }%>" type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete-modal" data-cliente="${fornecedor.idFornecedor }">Excluir</button>
                                            </td>
                                        </tr>
                            </c:forEach>

                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
            <!-- /#main -->
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