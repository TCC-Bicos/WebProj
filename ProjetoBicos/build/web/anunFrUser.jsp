<%-- 
    Document   : anun
    Created on : 26 de out. de 2022, 11:31:10
    Author     : Lab_ETESP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Tblusuario"%>
<%@page import="model.Tblfreelancer"%>
<%@page import="model.Tblanunfr"%>
<%@page import="model.SistemaDao"%>
<!DOCTYPE html>
<html Lang="pt">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="icon" type="image/png" href="img/bicos2.png" />
        <title>Bicos | Anúncio </title> 

        <!--FONTE-->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">

        <!--BOOTSTRAP-->
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        
        <!--CSS-->
        <link rel="stylesheet" href="css/style-anun1.css" />
    </head>
    <body>
        
        <%
            String nome,email,idAnun,nomeFr,emailFr;
            SistemaDao dao;
            Tblusuario user;
            Tblanunfr anunFr;
            Tblfreelancer fr;
            int idFr;
            
            idAnun = request.getParameter("id");
            nome = request.getParameter("nome");
            email = request.getParameter("email");
            
            //Conversão de String para Int
            int id = Integer.parseInt(idAnun);
            
            //Buscar dados das Tabelas AnunUser e Usuario
            dao = new SistemaDao();
            
            //Buscar dados do anúncio
            anunFr = dao.buscarAnunFree(id);
            
            //Pegar o IdUser da Tabela AnunUser
            idFr = anunFr.getIdFr().getIdFr();
            
            //Buscar dados do usuário (autor do anúncio)
            fr = dao.buscarFreeId(idFr);
            nomeFr = fr.getNomeFr();
            emailFr = fr.getEmailFr();
            
            //Buscar dados necessários do anúncio
            String nomeAnun, descAnun;
            double precoAnun;
            
            //TblAnunUser
            nomeAnun = anunFr.getTituloAnunFr();
            descAnun = anunFr.getDescAnunFr();
            precoAnun = anunFr.getPrecoAnunFr();
            
            //TblFreelancer
            user = dao.buscarUser(nome,email);
        %>

        <main>
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

            <!--SECOND-PAGE-->

            <div class="d-flex anun">
                <div class="col-5 photo">
                    <img>
                </div>
                <div class="col-7 d-flex name">
                    <div class="title">
                        <h1> <%=nomeAnun%> </h1>
                        <a href="profileFrUser.jsp?nome=<%=nome%>&email=<%=email%>&nomeFr=<%=nomeFr%>&emailFr=<%=emailFr%>"> <%=nomeFr%> </a>
                        <h3> <%=precoAnun%> </h3>
                        <a href="criarProjFrUser.jsp?id=<%= anunFr.getIdAnunFr() %>&nome=<%= user.getNomeUser() %>&email=<%= user.getEmailUser() %>">
                            <button> Contratar </button>     
                        </a>
                    </div>
                    <div class="description">
                        <h1> Descrição </h1>
                        <p> <%=descAnun%></p>
                    </div>
                </div>
            </div>
    
    
            <!--FOOTER-->


            <footer>
                <section class="slanted-header-sec">
                <ul class="footer__nav">            
                <div class="legal">
                    <a href="#" class="text-decoration-none logo">BICOS</a>
                    <a href="#" class="text-decoration-none bottom-links">Suporte</a>
                    <a href="#" class="text-decoration-none bottom-links">Termo de uso</a>
                    <a href="#" class="text-decoration-none bottom-links">Contato</a>
                    <ul class="wrapper">
                        <li class="icon facebook">
                            <span class="tooltip">Facebook</span>
                            <span><i class="fab fa-facebook-f"></i></span>
                        </li>
                        <li class="icon twitter">
                            <span class="tooltip">Twitter</span>
                            <span><i class="fab fa-twitter"></i></span>
                        </li>
                        <li class="icon email">
                            <span class="tooltip">Email</span>
                            <span><i class="fab fa-email"></i></span>
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
