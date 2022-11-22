<%-- 
    Document   : howworkFr
    Created on : Nov 17, 2022, 10:12:37 PM
    Author     : Stefano
--%>

<%@page import="java.net.URLEncoder"%>
<%@page import="model.Tblfreelancer"%>
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
        <link rel="stylesheet" href="css/main-hw.css" />
        
    </head>
    <body>
        
        <%
            Tblfreelancer fr;
            SistemaDao dao;
            String nome, email;
            
            nome = request.getParameter("nome");
            email = request.getParameter("email");

            fr = (Tblfreelancer) request.getAttribute("fr");
            dao = new SistemaDao();
            fr = dao.buscarFree(nome, email);
        %>

        <main>
            <section>
              <div class="nav-container header-content container">

                <nav class="navbar navbar-expand-sm justify-content-between fixed-top navbar-dark bottom-shadow bg-grad">
                    <div class="container-fluid content-center">
                        <a class="text-decoration-none logo" href="homeFr.jsp?nome=<%= fr.getNomeFr() %>&email=<%= fr.getEmailFr() %>">Bicos</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar" onclick="myFunction(this)">
                        <!--<span class="navbar-toggler-icon"></span>-->
                        <div class="bar1"></div>
                        <div class="bar2"></div>
                        <div class="bar3"></div>
                        </button>
                        <div class="collapse navbar-collapse" id="mynavbar">
                        <ul class="nav-list navbar-nav me-auto navMenu">
                            <li class="nav-item">
                            <a class="nav-link menu" href="homeFr.jsp?nome=<%= fr.getNomeFr() %>&email=<%= fr.getEmailFr() %>#second">Como Funciona</a>
                            </li>
                            <li class="nav-item">
                            <a class="nav-link menu" href="homeFr.jsp?nome=<%= fr.getNomeFr() %>&email=<%= fr.getEmailFr() %>#third">Serviços</a>
                            </li>
                        </ul>
                        <form class="d-flex">
                            <div class="text-end cont-btn d-flex">
                                <input type="text" text="Pesquisar" class="inp" placeholder="Pesquisar">
                                <div class="dropdown">
                                    <img class="iconcustom" data-bs-toggle="dropdown" src="img/icon-notify.png">
                                    <ul class="dropdown-menu dropCustom resp">
                                        <li><a class="dropdown-item aCustom" href="#">#</a></li>
                                        <li><a class="dropdown-item aCustom" href="#">#</a></li>
                                        <li><a class="dropdown-item aCustom" href="#">#</a></li>
                                    </ul>
                                </div>
                                <div class="dropdown">
                                    <img class="iconcustom2" data-bs-toggle="dropdown" src="img/icon-profile.png">
                                    <ul class="dropdown-menu dropCustom resp">
                                        <li><a class="dropdown-item aCustom" href="profileFr.jsp?nome=<%= fr.getNomeFr() %>&email=<%= fr.getEmailFr() %>">Perfil</a></li>
                                        <li><a class="dropdown-item aCustom" href="projectsFr.jsp?nome=<%= fr.getNomeFr() %>&email=<%= fr.getEmailFr() %>">Meus Projetos</a></li>
                                        <li><a class="dropdown-item aCustom" href="pubAnunFr.jsp?nome=<%= fr.getNomeFr() %>&email=<%= fr.getEmailFr() %>">Publicar Anúncio</a></li>
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
