<%@page import="java.util.List"%>
<%@page import="model.SistemaDao"%>
<%@page import="model.Tblfreelancer"%>
<%@page import="model.Tblusuario"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="model.Tblanunuserfr"%>
<!DOCTYPE html>
<html Lang="pt">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
        <META HTTP-EQUIV="Expires" CONTENT="-1">
        <meta http-equiv="refresh">
        <link rel="icon" type="image/png" href="img/bicos2.png" />
        <title>Bicos | Profile </title> 

        <!--FONTE-->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">

        <!--BOOTSTRAP-->

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

        <!--CSS-->
        <link rel="stylesheet" href="css/main-profile.css" />
        <link rel="stylesheet" href="css/style-projects.css" />
    </head>
    <body onload="">
        <%
            Tblusuario user;
            Tblfreelancer fr;
            List<Tblanunuserfr> listaAnunUserFr;
            // List<Tblanunuser> listaAnunUser;

            user = (Tblusuario) request.getAttribute("user");
            //if (user == null) {
            //    response.sendRedirect("index.html");
            //}

            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String nomeFr = request.getParameter("nomeFr");
            String emailFr = request.getParameter("emailFr");
            
            SistemaDao dao = new SistemaDao();
            fr = dao.buscarFree(nomeFr, emailFr);
            String desc = fr.getDescFr();
            String img = fr.getImgFr();
            
            //int id = user.getIdUser();
            //listaAnunUser = dao.buscarAnunIdUser(id);
            
            user = dao.buscarUser(nome, email);
        %>   
        <main>
            <section class="slanted-header">
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
                                        <a class="nav-link menu" href="home.jsp?nome=<%= user.getNomeUser() %>&email=<%= user.getEmailUser() %>#second">Como Funciona</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link menu" href="home.jsp?nome=<%= user.getNomeUser() %>&email=<%= user.getEmailUser() %>#third">Serviços</a>
                                    </li>
                                </ul>
                                <form class="d-flex">
                                    <div class="text-end cont-btn d-flex">
                                        <input type="text" text="Pesquisar" class="inp" placeholder="Pesquisar">
                                        <div class="dropdown">
                                            <img class="iconcustom" data-bs-toggle="dropdown" src="img/icon-notify.png">
                                            <ul class="dropdown-menu dropCustom">
                                                <li><a class="dropdown-item aCustom" href="#">#</a></li>
                                                <li><a class="dropdown-item aCustom" href="#">#</a></li>
                                                <li><a class="dropdown-item aCustom" href="#">#</a></li>
                                            </ul>
                                        </div>
                                        <div class="dropdown">
                                            <%
                                                if (img == "" || img == null) {
                                            %>
                                            <img class="iconcustom2" data-bs-toggle="dropdown" src="img/icon-profile.png">
                                            <%
                                            } else {
                                            %>
                                            <img class="iconcustom2" data-bs-toggle="dropdown" src="user_img/<%=img%>">
                                            <%
                                                }
                                            %>                                           


                                            <ul class="dropdown-menu dropCustom">
                                                <li><a class="dropdown-item aCustom" href="profile.jsp?nome=<%= user.getNomeUser() %>&email=<%= user.getEmailUser() %>">Perfil</a></li>
                                                <li><a class="dropdown-item aCustom" href="projects.jsp?nome=<%= user.getNomeUser() %>&email=<%= user.getEmailUser() %>">Meus Projetos</a></li>
                                                <li><a class="dropdown-item aCustom" href="pubAnun.jsp?nome=<%= user.getNomeUser() %>&email=<%= user.getEmailUser() %>">Publicar Anúncio</a></li>
                                                <li><a class="dropdown-item aCustom" href="#">Chat</a></li>
                                                <li><a class="dropdown-item aCustom" href="faq.html">FAQ</a></li>
                                                <li><a class="dropdown-item aCustom" href="index.html">Sair</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </nav>

                </div>

                <div class="container mh">
                    <div class="row">
                        <div class="col-md-3 align-self-center pd-top line-d">
                            <%
                                if (img == "" || img == null) {
                            %>
                            <img class="icon-profile" src="img/icon-profile.png">
                            <%
                            } else {
                            %>
                            <img class="icon-profile" src="user_img/<%=img%>">
                            <%
                                }
                            %>

                        </div>
                        <div class="col-md-6 pd-top line-d c-top">
                            <h2 class="first-desc"><%= fr.getNomeFr() %></h2>
                            <h2 class="type-desc type-desc-first"><%= desc %></h2>
                        </div>
                        <div class="col-md-3 align-self-center pd-top line-d">
                            <a href="emailFr.jsp?nome=<%= user.getNomeUser() %>&email=<%= user.getEmailUser() %>&nomeFr=<%= fr.getNomeFr() %>&emailFr=<%= fr.getEmailFr() %>">
                                <button type="button" class="btn btn-outline-primary me-2 btn-act btn-log">
                                    Entrar em Contato
                                </button>
                            </a>
                        </div>
                    </div>
                </div>

                <a class="descer" href="#third">
                    <span class="botao"></span>
                </a>
            </section>

            <!--SECOND-PAGE-->
            
            <div class="align-self-center line-d faq-content container txt-center">
                <h1 class="help">Ações</h1>
            </div>

            <section id="third" class="second-container">
                <div class="container mh3">
                    <div class="moderator">
                        <%
                            int idFr;

                            idFr = fr.getIdFr();

                            listaAnunUserFr = dao.findAllAnunUserFr(idFr);

                            for(Tblanunuserfr anunUserFr: listaAnunUserFr) {
                        %>
                        <div class="row third-show row-c3">
                            <div class="col-md-4 align-self-center pd-top line-d">
                                <div class="third-showcase">
                                    <div class="padding-third">
                                        <div class="row">
                                            <div class="col-md-7 align-self-center pd-top line-d">
                                                <h1 class="type-title"><%= anunUserFr.getNomeAnunUser() %></h1>
                                            </div>
                                            <div class="col-md-5 align-self-center pd-top line-d">

                                            </div>
                                        </div>
                                        <h2 class="type-desc"><%= anunUserFr.getDescAnunUser() %></h2>
                                    </div>
                                </div>
                            </div>                       
                        </div>
                        <% } %>
                    </div>
                </div>
            </section>


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