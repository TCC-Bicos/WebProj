<%-- 
    Document   : howworkUser.jsp
    Created on : Nov 17, 2022, 9:52:44 PM
    Author     : Stefano
--%>

<%@page import="model.SistemaDao"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="model.Tblusuario"%>

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
        <link rel="stylesheet" href="css/main-hw.css" />
        
    </head>
    <body>
        
        <%
            Tblusuario user;

            user = (Tblusuario) request.getAttribute("user");
            //if (user == null) {
            //    response.sendRedirect("index.html");
            //}

            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            SistemaDao dao = new SistemaDao();
            user = dao.buscarUser(nome, email);
            String img = user.getImgUser();
            String desc = user.getDescUser();
        %>

        <main>
            <section>
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
                                        <a class="nav-link menu" href="freeAvailable.jsp?nome=<%= user.getNomeUser() %>&email=<%= user.getEmailUser() %>">Serviços</a>
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
                    <p class="FAQ">BICOS</p>
                    <h1 class="help">Como funciona?</h1>
                </div>
                <div class="container mh">
                        
                        <section id="second" class="second-container">
                            <div class="container mh2 mh3">
                                <div class="row">
                                    <div class="col-md-6 align-self-center pd-top line-d">
                                        <h2 class="second-title">Para Freelancers.</h2><br/ ><br/ >
                                        <h3 class="second-desc">Na Bicos, os freelancers podem divulgar seu perfil profissional, além de poderem publicar projetos e descobrir diversas oportunidades em diversas áreas de seu interesse.</h3>
                                       
                                    </div>
                                    <div class="col-md-6 align-self-center pd-top text-end div-showcase">
                                        <div class="second-showcase container">
                                            <img class="second-img" src="./img/undrawdev1.png" alt="#">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>

                        <section id="second" class="second-container">
                            <div class="container mh2">
                                <div class="row">
                                    <div class="col-md-6 align-self-center pd-top text-end div-showcase">
                                        <div class="second-showcase container">
                                            <img class="second-img" src="./img/undrawclient1.png" alt="#">
                                        </div>
                                    </div>
                                    <div class="col-md-6 align-self-center pd-top line-d">
                                        <h2 class="second-title">Para Usuários</h2><br/ ><br/ >
                                        <h3 class="second-desc"> Você possui algum projeto em mente que nunca conseguiu tornar real?</br  ></br  >
                                        Aqui na Bicos, você acha os melhores freelancers para realizar o projeto dos seus sonhos. Os usuários podem publicar propostas de projetos, para encontrar os melhores freelancers disponíveis.</h3>
                                        
                                    </div>
                                    
                                </div>
                            </div>
                        </section>

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
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
        <script src="js/bootstrap.min.js"></script> 

    </body>
</html>
