<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Buscar Usuario</title>

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

<<<<<<< HEAD
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
                                        <h4 class="modal-title" id="modalLabel">Excluir Usuario</h4>
                                    </div>
                                    <div class="modal-body">
                                        Deseja excluir este Usuario?
                                    </div>
                                    <div class="modal-footer">
                                        <form action="controller.do" method="post">
                                            <input type="hidden" name="id" id="id_excluir" />
                                            <button type="submit" class="btn btn-primary" name="command" value="ExcluirUsuario">Sim</button>
                                            <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
=======
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
>>>>>>> dev-08-03-20
                        </div>
                        <!-- /.modal -->
                        <!-- Barra superior com os menus de navegação -->
                        <!-- Container Principal -->
                        <div id="main" class="container">
                            <form action="controller.do" method="post">
                                <div id="top" class="row">
                                    <div class="col-md-3">
                                        <h2>Usuario</h2>
                                    </div>
            
                                    <div class="col-md-6">
                                        <div class="input-group h2">
                                            <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Usuario">
                                            <span class="input-group-btn">
                            <button class="btn btn-primary" type="submit" name="command" value="ListarUsuario">Pesquisar
                                <span class="glyphicon glyphicon-search"></span>
                                            </button>
                                            </span>
                                        </div>
                                    </div>
            
                                    <div class="col-md-3">
                                        <a href="UsuarioIndex.jsp" class="btn btn-primary pull-right h2">Novo Usuario</a>
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
                                                <th>Email</th>
                                                <th>Password</th>
                                                <th class="actions">Ações</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="categoria" items="${lista }">
                                                    <tr>
                                                        <td>
                                                            ${usuario.id }
                                                        </td>
                                                        <td>
                                                            ${usuario.email }
                                                        </td>
                                                        <td>
                                                            ${usuario.password }
                                                        </td>
                                                        <td class="actions">
                                                            <a class="btn btn-success btn-xs" href="controller.do?command=VisualizarUsuario&id=${usuario.id }">Visualizar</a>
                                                            <a class="btn btn-warning btn-xs" href="controller.do?acao=EditarUsuario&id=${usuario.id }">Editar</a>
                                                            <button id="btn${usuario.id }%>" type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete-modal" data-cliente="${categoria.id }">Excluir</button>
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

<<<<<<< HEAD
                        <!-- Fim -->
=======
                        <div class="col-md-3">
                            <a href="UsuarioIndex.jsp" class="btn btn-primary pull-right h2">Novo Usuario</a>
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
                                    <th>Email</th>
                                    <th>Password</th>
                                    <th class="actions">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
          					<c:forEach var="usuario" items="${lista }">
                                       <tr>
                                            <td>
                                               ${usuario.id }
                                            </td>
                                            <td>
                                                ${usuario.email }
                                            </td>
                                            <td>
                                                ${usuario.password }
                                            </td>
                                            <td class="actions">
                                                <a class="btn btn-success btn-xs" href="controller.do?command=VisualizarUsuario&id=${usuario.id }">Visualizar</a>
                                                <a class="btn btn-warning btn-xs" href="controller.do?command=EditarUsuario&id=${usuario.id}">Editar</a>
                                                <a href="controller.do?command=ExcluirUsuario&id=${usuario.id }" class="btn btn-danger">Excluir</a>
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
>>>>>>> dev-08-03-20
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
            $("#delete-modal").on('show.bs.modal', function(event) {
                var button = $(event.relatedTarget); //botao que disparou a modal
                var recipient = button.data('usuario');
                $("#id_excluir").val(recipient);
            });
        </script>
    </body>
</html>