<%-- 
    Document   : projects
    Created on : Oct 30, 2022, 5:04:14 PM
    Author     : Stefano
--%>

<%@page import="java.util.List"%>
<%@page import="model.Tblusuario"%>
<%@page import="model.Tblanunuser"%>
<%@page import="model.SistemaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html Lang="pt">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="icon" type="image/png" href="img/bicos2.png" />
        <title>Bicos: Companies & Employees</title> 

        <!--FONTE-->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">

        <!--BOOTSTRAP-->
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        
        <!--CSS-->
        <link rel="stylesheet" href="css/style-projects.css" />
        <link rel="stylesheet" href="css/responsive.css" />
    </head>
    <body>
        
        <%
            SistemaDao dao;
            Tblusuario user;
            
            List<Tblanunuser> listaAnunUser;
            
            int id;
            String nome, email;
            
            nome = request.getParameter("nome");
            email = request.getParameter("email");
            
            dao = new SistemaDao();
            user = dao.buscarUser(nome, email);
            
            //Pegar o idUser para buscar os dados dos projetos criados por esse usuário.
            id = user.getIdUser();
            listaAnunUser = dao.buscarAnunIdUser(id);
            
        %>
        
        <main>
            <div class="nav-container header-content container">

                                    <nav class="navbar navbar-expand-sm justify-content-between fixed-top navbar-dark bottom-shadow bg-grad">
                        <div class="container-fluid content-center">
                            <a class="text-decoration-none logo" href="home.jsp?nome=<%= user.getNomeUser() %>&email=<%= user.getEmailUser() %>">Bicos</a>
                            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar" onclick="myFunction(this)">
                                <!--<span class="navbar-toggler-icon"></span>-->
                                <div class="bar1"></div>
                                <div class="bar2"></div>
                                <div class="bar3"></div>
                            </button>
                            <div class="collapse navbar-collapse" id="mynavbar">
                                <ul class="nav-list navbar-nav me-auto navMenu">
                                    <li class="nav-item">
                                        <a class="nav-link menu active" href="howworkUser.jsp?nome=<%= user.getNomeUser() %>&email=<%= user.getEmailUser() %>">Como Funciona</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link menu" href="#">Serviços</a>
                                    </li>
                                </ul>
                                <form class="d-flex">
                                    <div class="text-end cont-btn d-flex center-c">
                                        <form method="post" action="pesquisar.jsp">
                                          <input type="text" name="pesquisa" class="inp" placeholder="Pesquisar">
                                          <input type="hidden" name="nome"  value="<%= user.getNomeUser() %>">
                                          <input type="hidden" name="email" value="<%= user.getEmailUser() %>">
                                        </form>
                                        <div class="dropdown">
                                            <img class="iconcustom" data-bs-toggle="dropdown" src="img/icon-notify.png">
                                            <ul class="dropdown-menu dropCustom">
                                                <li><a class="dropdown-item aCustom" href="#">#</a></li>
                                                <li><a class="dropdown-item aCustom" href="#">#</a></li>
                                                <li><a class="dropdown-item aCustom" href="#">#</a></li>
                                            </ul>
                                        </div>
                                        <div class="dropdown center-c">
                                            <img class="iconcustom2" data-bs-toggle="dropdown" src="img/icon-profile.png"> 
                                            <ul class="dropdown-menu dropCustom">
                                                <li><a class="dropdown-item aCustom" href="profile.jsp?nome=<%= user.getNomeUser() %>&email=<%= user.getEmailUser() %>">Perfil</a></li>
                                                <li><a class="dropdown-item aCustom" href="projects.jsp?nome=<%= user.getNomeUser() %>&email=<%= user.getEmailUser() %>">Meus Projetos</a></li>
                                                <li><a class="dropdown-item aCustom" href="pubAnun.jsp?nome=<%= user.getNomeUser() %>&email=<%= user.getEmailUser() %>">Publicar Anúncio</a></li>
                                                <li><a class="dropdown-item aCustom" href="faq.html">FAQ</a></li>
                                                <li><a class="dropdown-item aCustom" href="index.html">Sair</a></li>
                                            </ul>
                                            <span class="nome">
                                                <%= user.getNomeUser() %>
                                            </span>                                        
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </nav>

            </div>

            <div class="align-self-center line-d faq-content container txt-center">
                <p class="FAQ"><%=nome%></p>
                <h1 class="help">Meus Projetos</h1>
            </div>

            <!--FIRST-PAGE-->

            <section id="third" class="second-container">
                <div class="container mh3">
                    <!-- <h2 class="second-title">Pendentes</h2><br/ ><br/ > -->
                    <div class="moderator">
                        <% for(Tblanunuser anunUser: listaAnunUser) { %>
                            <div class="row third-show row-c3">
                                <div class="col-md-4 align-self-center pd-top line-d">
                                    <div class="third-showcase">
                                        <div class="padding-third">
                                            <div class="row">
                                                <div class="col-md-7 align-self-center pd-top line-d">
                                                    <h1 class="type-title"><%= anunUser.getTituloAnunUser() %></h1>
                                                </div>
                                                <div class="col-md-5 align-self-center pd-top line-d">
                                                    <img class="type-img">
                                                </div>
                                            </div>
                                            <h2 class="type-desc"><%= anunUser.getDescAnunUser() %></h2>
                                            <a href="anunUser.jsp?id=<%=anunUser.getIdAnunUser()%>&nome=<%=nome%>&email=<%=email%>">
                                                <button style="float:left" class="viewP"> Abrir </button>
                                            </a>
                                            <a href="editAnunUser.jsp?id=<%=anunUser.getIdAnunUser()%>&nome=<%=nome%>&email=<%=email%>">
                                                <button class="viewPD"> Editar </button>
                                            </a>
                                        </div>
                                    </div>
                                </div>                       
                            </div>
                         <% } %>     
                     </div>
                </div>
            </section>

            <!--SECOND-PAGE-->
            <%--
            <section id="third" class="second-container">
                <div class="container mh3">
                    <h2 class="second-title">Concluídos</h2><br/ ><br/ >
                    <div class="row third-show  row-c3">
                        <div class="col-md-4 align-self-center pd-top line-d">
                            <div class="third-showcase">
                                <div class="padding-third">
                                    <div class="row">
                                        <div class="col-md-7 align-self-center pd-top line-d">
                                            <h1 class="type-title">Design de Logo</h1>
                                        </div>
                                        <div class="col-md-5 align-self-center pd-top line-d">
                                            <img class="type-img" src="./img/#">
                                        </div>
                                    </div>
                                    <h2 class="type-desc">Criação de logotipo da empresa, "Bicos: Companies & Employees". Logo simples, discreto e moderno, ressaltando a seriedade da companhia.</h2>
                                    <button class="viewR"> Abrir </button>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 align-self-center pd-top line-d">
                            <div class="third-showcase">
                                <div class="padding-third">
                                    <div class="row">
                                        <div class="col-md-7 align-self-center pd-top line-d">
                                            <h1 class="type-title">Design de Site</h1>
                                        </div>
                                        <div class="col-md-5 align-self-center pd-top line-d">
                                            <img class="type-img" src="./img/#">
                                        </div>
                                    </div>
                                    <h2 class="type-desc">Produção de design de site para a empresa "Lijahr" para fins comerciais. Aparência boa, moderna e discreta, destacando os anúncios dos produtos. </h2>
                                    <button class="viewR"> Abrir </button>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 align-self-center pd-top line-d">
                            <div class="third-showcase">
                                <div class="padding-third">
                                    <div class="row">
                                        <div class="col-md-7 align-self-center pd-top line-d">
                                            <h1 class="type-title">Banco de Dados</h1>
                                        </div>
                                        <div class="col-md-5 align-self-center pd-top line-d">
                                            <img class="type-img" src="./img/#">
                                        </div>
                                    </div>
                                    <h2 class="type-desc">Criação de Banco de Dados para controle de estoque de uma loja de roupas. Para melhores detalhes, entre em contato conosco.</h2>
                                    <button class="viewR"> Abrir </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <button type="button" class="btn-more more"><a class="a-norm" href="concluidos.html" style="text-decoration: none;"> Ver mais </a></button>
                </div>
            </section>
            --%>

            <!--FOOTER-->


            <footer>
                <section class="slanted-header-sec">
                    <ul class="footer__nav">            
                        <div class="legal">
                            <a href="#" class="text-decoration-none logo logof">BICOS</a>
                            <a href="faq.html" class="text-decoration-none bottom-links">Suporte</a>
                            <a href="#" class="text-decoration-none bottom-links">Termo de uso</a>
                            <a href="#" class="text-decoration-none bottom-links">Contato</a>
                            <ul class="wrapper">
                                <li class="icon facebook">
                                    <span class="tooltip">Facebook</span>
                                    <img class="social-img" src="img/facebook.png">
                                    <span><i class="fab fa-facebook-f">
                                        </i></span>
                                </li>
                                <li class="icon twitter">
                                    <span class="tooltip">Twitter</span>
                                    <span><i class="fab fa-twitter">
                                            <img class="social-img" src="img/tt-logo1.png">
                                        </i></span>
                                </li>
                                <li class="icon email">
                                    <span class="tooltip">Email</span>
                                    <span><i class="fab fa-email">
                                            <img class="social-img" src="img/gmail.png">
                                        </i></span>
                                </li>
                            </ul>
                        </div>
                    </ul>
                    <p class="copyright">© Bicos Company 2022. All rights reserved. </p>
                </section>
            </footer>

        </main>


        <script>
            function myFunction(x) {
              x.classList.toggle("change");
            }
        </script>

    </body>
</html>
