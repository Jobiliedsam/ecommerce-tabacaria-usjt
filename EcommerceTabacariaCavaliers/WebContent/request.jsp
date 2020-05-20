<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
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
        <meta charset="UTF-8">
        <title>Informações do Pedido</title>
    </head>
    <body>
        <jsp:include page="./componentes/header.jsp"></jsp:include>
        <main>
            <!-- Carrinho de Compras -->
            <div id="request-page">
                <div class="container">
                    <div class="row">
                        <div class="col-8">
                            <h3>Informações de Entrega</h3>
                            <form class="info-form" action="controller.do" method="post">
                                <div class="row">
                                    <div class="col">
                                        <label>Nome do Destinatário</label>
                                        <input type="text" class="form-control" id="completeName"
                                            value="${currentUser.nomeCompleto}">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <label>Endereço</label>
                                        <input type="text" class="form-control" id="address"
                                            value="${currentUserEndereco.enderecoP}">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <label>Complemento</label>
                                        <input type="text" class="form-control"
                                            value="${currentUserEndereco.complemento}">
                                    </div>
                                    <div class="col">
                                        <label>Bairro</label>
                                        <input type="text" class="form-control"
                                            value="${currentUserEndereco.enderecoS}">
                                    </div>
                                    <div class="col">
                                        <label>Cidade</label>
                                        <input type="text" class="form-control" value="${currentUserEndereco.cidade}">
                                    </div>
                                    <div class="col">
                                        <label for="inputState">Estado</label>
                                        <select id="inputState" class="form-control">
                                            <option selected>${currentUserEndereco.estado}</option>
                                            <option value="AC">Acre</option>
                                            <option value="AL">Alagoas</option>
                                            <option value="AP">AmapÃ¡</option>
                                            <option value="AM">Amazonas</option>
                                            <option value="BA">Bahia</option>
                                            <option value="CE">CearÃ¡</option>
                                            <option value="DF">Distrito Federal</option>
                                            <option value="ES">EspÃ­rito Santo</option>
                                            <option value="GO">GoiÃ¡s</option>
                                            <option value="MA">MaranhÃ£o</option>
                                            <option value="MT">Mato Grosso</option>
                                            <option value="MS">Mato Grosso do Sul</option>
                                            <option value="MG">Minas Gerais</option>
                                            <option value="PA">ParÃ¡</option>
                                            <option value="PB">ParaÃ­ba</option>
                                            <option value="PR">ParanÃ¡</option>
                                            <option value="PE">Pernambuco</option>
                                            <option value="PI">PiauÃ­</option>
                                            <option value="RJ">Rio de Janeiro</option>
                                            <option value="RN">Rio Grande do Norte</option>
                                            <option value="RS">Rio Grande do Sul</option>
                                            <option value="RO">RondÃ´nia</option>
                                            <option value="RR">Roraima</option>
                                            <option value="SC">Santa Catarina</option>
                                            <option value="SP">SÃ£o Paulo</option>
                                            <option value="SE">Sergipe</option>
                                            <option value="TO">Tocantins</option>
                                            <option value="EX">Estrangeiro</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <label>CEP</label>
                                        <input type="text" class="form-control" value="${currentUserEndereco.cep}">
                                    </div>
                                    <div class="col">
                                        <label>Telefone</label>
                                        <input type="tel" class="form-control" value="${currentUser.telefone}">
                                    </div>
                                    <div class="col">
                                        <label>Celular</label>
                                        <input type="tel" class="form-control" value="${currentUser.celular }">
                                    </div>
                                </div>
                                <h3>Informações de Pagamento</h3>
                                <div class="row">
                                    <div class="col">
                                        <div class="form-check">
                                            <input class="form-check-input" type="radio" value="option1" checked>
                                            <label class="form-check-label"> Cartão de Crédito </label>
                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="form-check">
                                            <input class="form-check-input" type="radio">
                                            <label class="form-check-label"> Boleto Bancário </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <label>Numero do Cartão</label>
                                        <input type="text" class="form-control">
                                    </div>
                                    <div class="col-5">
                                        <label>Data de Validade</label>
                                        <div class="row">
                                            <div class="col-3 no-padding-right">
                                                <input type="text" class="form-control" placeholder="MM">
                                            </div>
                                            <div class="col min-padding-left">
                                                <input type="text" class="form-control" placeholder="AAAA">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <label>Nome no CartÃ£o</label>
                                        <input type="text" class="form-control">
                                    </div>
                                    <div class="col-3">
                                        <label>Codigo de Segurança</label>
                                        <input type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <label>CPF do titular do CartÃ£o</label>
                                        <input type="text" class="form-control">
                                    </div>
                                    <div class="col-3">
                                        <label>Data de Nascimento</label>
                                        <input type="text" class="form-control">
                                        <small class="form-text text-muted">Ex: 01/01/1980</small>
                                    </div>
                                    <div class="col-4">
                                        <label>Telefone</label>
                                        <div class="row">
                                            <div class="col-4 no-padding-right">
                                                <input type="text" class="form-control" placeholder="DDD">
                                            </div>
                                            <div class="col min-padding-left">
                                                <input type="text" class="form-control" placeholder="Telefone">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <label>Quantidade de Parcelas</label>
                                        <select class="form-control">
                                            <!-- Precisa de um Array contando o Juros nas parcelas -->
                                            <option value="1" selected>1x - </option>
                                            <option value="2">2x - </option>
                                            <option value="3">3x - </option>
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <button type="submit" name="command" value="CriarPedidoHeader">Concluir
                                            Pedido</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="col-4" id="aside-fixed-container">
                            <div class="row">
                                <div class="col summary" id="aside-fixed">
                                    <h2>Resumo do pedido</h2>
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>Descrição</th>
                                                <th>Valor</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <!-- Um array com as infos de cada Produto -->
                                            <c:forEach var="produtoCarrinho" items="${produtosCarrinho}">
                                                <tr>
                                                    <td>
                                                        <h3>"${produtoCarrinho.nomeDoProduto }"</h3> Quantidade:
                                                        ${produtoCarrinho.quantidadeProduto}<br> Valor do item:
                                                        ${produtoCarrinho.precoUnitario}<br>
                                                    </td>
                                                    <td>R$ <strong>${produtoCarrinho.valorProduto}</strong></td>
                                                </tr>
                                            </c:forEach>
                                            <!-- Fim do Item -->
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <td>
                                                    <h4>Frete</h4>
                                                </td>
                                                <td>
                                                    <span>R$ <strong>19,90</strong></span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <h4>Sub Total</h4>
                                                </td>
                                                <td>
                                                    <span>R$ <strong>${orderHeader.valorTotal}</strong></span>
                                                </td>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <jsp:include page="./componentes/footer.jsp"></jsp:include>
        <script src="./js/fixe_position.js"></script>
    </body>
</html>