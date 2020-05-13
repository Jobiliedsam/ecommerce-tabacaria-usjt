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

        <title>Criar Produto</title>
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

							<div id="main" class="container">
                                <h3 class="page-header">Incluir Produto</h3>
        
        							<form action="controller.do" method="post">
                                    <!-- area de campos do form -->
                                    <div class="row">
                                        <div class="form-group col-md-12">
                                            <label for="nomeP">Nome do Produto:</label>
                                            <input type="text" class="form-control" name="nomeP" id="nomeP" required maxlength="100" placeholder="Nome do Produto">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-12">
                                            <label for="precoF"> Pre�o: </label> <input type="number"
                                                class="form-control" name="precoF" id="precoF" required
                                                maxlength="100" placeholder="Pre�o do Produto" />
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-6">
                                            <label for="categoria">Categoria:</label>
                                            <input type="text" class="form-control" name="categoria" id="categoria" maxlength="15"  placeholder="Categoria ">
                                        </div>
                                        
                                        <div class="form-group col-md-6">
                                            <label for="fornecedor">Fornecedor</label>
                                            <input type="text" class="form-control" name="fornecedor" id="fornecedor" required maxlength="60" placeholder="Fornecedor">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                            <label for="status">Status</label>
                                            <input type="text" class="form-control" name="status" id="status" required maxlength="60" placeholder="Status">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-12">
                                            <label for="descricao"> Descricao: </label> <input
                                                type="text" class="form-control" name="descricao"
                                                id="descricao" required maxlength="100"
                                                placeholder="descricao" />
                                        </div>
                                    </div>
                                    <hr />
                                    <div id="actions" class="row">
                                        <div class="col-md-12">
                                            <button type="submit" class="btn btn-primary" name="command" value="CriarProduto">Salvar</button>
                                            <a href="index.jsp" class="btn btn-default">Cancelar</a>
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