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

<link href="https://fonts.googleapis.com/css?family=Lobster&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Fira+Sans&display=swap" rel="stylesheet">

<title>Produto</title>
</head>
<body>

<div id="main" class="container">
        <h3 class="page-header">Incluir Fornecedor</h3>
        
        <form action="controller.do" method="post">
            <!-- area de campos do form -->
            <div class="row">
                <div class="form-group col-md-12">
                    <label for="nomeP">Nome do Produto</label>
                    <input type="text" class="form-control" name="nomeP" id="nomeP" required maxlength="50" placeholder="Nome do Produto">
                </div>
            </div>
            <div class="row">
				<div class="form-group col-md-12">
					<label for="precoF"> Preço: </label> <input type="number"
						class="form-control" name="precoF" id="precoF" required
						maxlength="10" placeholder="Preço do Produto" />
				</div>
			</div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="categoria">Categoria</label>
                    <input type="text" class="form-control" name="categoria" id="categoria" maxlength="15" placeholder="Categoria do Produto">
                </div>

                <div class="form-group col-md-6">
                    <label for="status">Status</label>
                    <input type="text" class="form-control" name="status" id="status" required maxlength="50" placeholder="Status do Produto">
                </div>
            </div>
            <div class="row">
				<div class="form-group col-md-12">
					<label for="descricao"> Descricao: </label> <input
						type="text" class="form-control" name="descricao"
						id="descricao" required maxlength="100"
						placeholder="Descrição" />
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


<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>