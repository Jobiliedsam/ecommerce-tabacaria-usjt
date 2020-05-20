<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Tabacaria Cavaliers</title>
        <!-- Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/fontawesome.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/banner_slider.css">
        <link rel="stylesheet" href="css/slider_gallery.css">
        <link href="https://fonts.googleapis.com/css?family=Lobster&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Fira+Sans&display=swap" rel="stylesheet">
    </head>
    <body>
        <div class="page">
            <section id="header">
                <header>
                    <div id="header-top" class="white">
                        <div class="container">
                            <div class="row">
                                <div class="col">
                                    <span>Bem vindo</span>
                                </div>
                                <div class="col">
                                    <i class="fas fa-phone"></i>
                                    <!-- Pegar fone no sistema-->
                                    <a href="tel:1199999999">(11) 9999 - 9999</a>
                                </div>
                                <div class="col">
                                    <i class="fab fa-whatsapp"></i>
                                    <!-- Pegar Whatsapp no sistema-->
                                    <a href="tel:1199999999">(11) 99999 - 9999</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="header-middle">
                        <div class="container">
                            <div class="row">
                                <div class="col-3 logo">
                                    <img src="template/images/logo.png" />
                                </div>
                                <div class="col-6 search-bar">
                                    <form>
                                        <!-- Aqui integração-->
                                        <input type="text" name="" id="">
                                        <button type="submit"><i class="fas fa-search"></i></button>
                                    </form>
                                </div>
                                <div class="col-2 login-display">
                                    <!-- Nome da pessoa logada, também pode ser um link para pagina de gerenciamento de pedidos-->
                                    <span>Faça Login <a href="#">Fuinha</a></span>
                                </div>
                                <div class="col-1 shop-cart">
                                    <!-- Informação de quantos itens tem no carrinho dentro do span -->
                                    <!-- Precisa link copm atela de Carrinho -->
                                    <a href="#" id="cart"><i class="fas fa-shopping-cart"><span
                                                id="products-number">00</span></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="header-bottom">
                        <div class="container">
                            <div class="row">
                                <div class="col-9 menu-categories">
                                    <!-- Se possivel isso pode ser dinâmico com banco de dados 
                            Restricão para quantidade que ira aparecer-->
                                    <ul>
                                        <li><a href="#">Arguiles</a></li>
                                        <li><a href="#">Tabaco</a></li>
                                        <li><a href="#">Pipes</a></li>
                                        <li><a href="#">Esqueiros</a></li>
                                    </ul>
                                </div>
                                <div class="col-3 questions white">
                                    <!-- Abrir pagina de contato ou chat -->
                                    <a href="#">Tire suas duvidas</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </header>
            </section>
            <section id="main">
                <!-- Pagina do Cliente -->
                <div id="order-confirmation">
                    <div class="container">
                        <div class="row confirmation">
                            <div class="col no-padding">
                                <h3><i class="fas fa-check-circle"></i>Pedido Confirmado</h3>
                                <p>SEU PEDIDO FOI REALIZADO COM SUCESSO.</p>
                                <p>Breve você recebera um e-mail no endereço <span>maninho@maninho.com.br</span> com
                                    todos detalhes do pedido.</p>
                            </div>
                        </div>
                        <div class="row order-info">
                            <div class="col no-padding">
                                <h4>Informação de Entrega</h4>
                                <p>Carinha que mora logo alí</p>
                                <p>Endereço: Rua teste, 666 - Vila Helena</p>
                                <p>São Paulo - SP</p>
                                <p>CEP: 08080-800</p>
                                <p>Tipo de Envio: Correis SEDEX</p>
                                <p>Códido de Rastreio: BR00000000000SE</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section id="footer">
                <footer>
                    <div id="footer-top">
                        <div class="container">
                            <div class="row">
                                <!--Aqui entraram as colunas e conteudo -->
                            </div>
                        </div>
                    </div>
                    <div id="footer-middle">
                        <div class="container">
                            <div class="row">
                                <div class="col-3 footer-widget">
                                    <h3>Institucional</h3>
                                    <!-- Caso possivel Links podem ser adicionados com controlador -->
                                    <ul>
                                        <li><a href="#">Empresa</a></li>
                                        <li><a href="#">Fale Conosco</a></li>
                                        <li><a href="#">Envio</a></li>
                                        <li><a href="#">Politica de Garantia</a></li>
                                    </ul>
                                </div>
                                <div class="col-3 footer-widget">
                                    <h3>Endereço</h3>
                                    <!-- Aqui, poderia remover o mapa caso a loja seja apenas virtual -->
                                    <ul>
                                        <li><i class="fas fa-map-marker-alt"></i><span>Rua Estamos em quarentena,
                                                7070</span></li>
                                        <li><iframe
                                                src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d467689.7971944828!2d-46.8754915172196!3d-23.68216038895823!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce448183a461d1%3A0x9ba94b08ff335bae!2zU8OjbyBQYXVsbywgU1A!5e0!3m2!1spt-BR!2sbr!4v1585409349302!5m2!1spt-BR!2sbr"
                                                width="100%" height="80" frameborder="0" style="border:0;"
                                                allowfullscreen="" aria-hidden="false" tabindex="0"></iframe></li>
                                    </ul>
                                </div>
                                <div class="col-3 footer-widget">
                                    <h3>Contato</h3>
                                    <!-- Caso possivel Links podem ser adicionados com controlador -->
                                    <ul>
                                        <li><i class="fab fa-whatsapp"></i><a href="#">(11) 99999 - 9999</a></li>
                                        <li><i class="fas fa-phone"></i><a href="#">(11) 9999 - 9999</a></li>
                                        <li><i class="fas fa-envelope"></i><small><a
                                                    href="#">contato@tabacariacavaliers.com.br</a></small></li>
                                    </ul>
                                </div>
                                <div class="col-3 footer-widget">
                                    <small>Formas de pagamento</small>
                                    <img src="template/images/payment-forms.png" alt="Formas de Pagamento" srcset="">
                                    <br>
                                    <span>Redes Sociais</span>
                                    <ul class="social-bt">
                                        <li><a href="#"><i class="fab fa-facebook"></i></a></li>
                                        <li><a href="#"><i class="fab fa-instagram"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="footer-bottom">
                        <div class="container">
                            <div class="row">
                                <!-- Essas duas linhas também podem ser dinâmicas -->
                                <span id="copyright">Copyright © 2020 Tabacaria Cavaliers | Criado por <a
                                        href="#">Cavaliers Soluctions</a></span>
                                <!-- Por padrão hoje o Google pede essas informações para Shopping e ADS -->
                                <span id="address">Matriz, Av. Estamos em quarentena, 7070, CEP 00000-000, Não Saia, São
                                    Paulo -SP / CNPJ: 00.000.000.0000-00.</span>
                            </div>
                        </div>
                    </div>
                </footer>
            </section>
            <!-- Adicionais, como poo ups, botão de Whatsapp e chat flutuantes -->
            <div id="back-to-top"><i class="fas fa-chevron-up"></i></div>
        </div>
        <!-- Scripts -->
        <script src="template/js/fixe_position.js"></script>
    </body>
</html>