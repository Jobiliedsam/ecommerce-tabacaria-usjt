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

        <title>Criar Fornecedor</title>
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
                                <h3 class="page-header">Incluir Fornecedor</h3>
                                
                                <form action="controller.do" method="post">
                                    <!-- area de campos do form -->
                                    <div class="row">
                                        <div class="form-group col-md-12">
                                            <label for="nomeFornecedor">Nome</label>
                                            <input type="text" class="form-control" name="nomeFornecedor" id="nomeFornecedor" required maxlength="100" placeholder="Nome Completo">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-12">
                                            <label for="cnpj"> Cnpj: </label> <input type="number"
                                                class="form-control" name="cnpj" id="cnpj" required
                                                maxlength="100" placeholder="cnpj" />
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-6">
                                            <label for="contatoTelefone">Telefone</label>
                                            <input type="tel" class="form-control" name="contatoTelefone" id="contatoTelefone" maxlength="15" pattern="(?:\(\d{2}\)|\d{2})[- ]?\d{5}[- ]?\d{4}" placeholder=" (99) 99999-9999">
                                        </div>
                                        
                                        <div class="form-group col-md-6">
                                            <label for="contatoEmail">E-Mail</label>
                                            <input type="email" class="form-control" name="contatoEmail" id="contatoEmail" required maxlength="60" placeholder="email obrigat�rio">
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
                                            <button type="submit" class="btn btn-primary" name="command" value="CriarFornecedor">Salvar</button>
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