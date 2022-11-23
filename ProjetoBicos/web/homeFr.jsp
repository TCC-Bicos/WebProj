<%@page import="java.net.URLEncoder"%>
<%@page import="model.Tblusuario"%>
<%@page import="model.Tblfreelancer"%>
<%@page import="model.SistemaDao"%>
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
        <link rel="stylesheet" href="css/style-homeFr.css" />
    </head>
    <body>
        <%
            //String nome, email, nomesep;
            Tblfreelancer fr;
            String nome, email;
            
            nome = request.getParameter("nome");
            email = request.getParameter("email");

            fr = (Tblfreelancer) request.getAttribute("fr");
            SistemaDao dao = new SistemaDao();
            fr = dao.buscarFree(nome, email);
            //if (user == null) {
            //    response.sendRedirect("index.html");
            //}

            //nome = URLEncoder.encode(user.getNomeUser(), "UTF-8");
            //email = user.getEmailUser();
            /*
            String[] nomeSeparado = nome.split("+");
            nomesep = "";
            for (int i = 0; i < nomeSeparado.length; i++) {
                nomesep = nomesep + nomeSeparado[i] + " ";
            }*/
        %>    

        <main>
            <section class="slanted-header">
                <div class="nav-container header-content container">

                    <nav class="navbar navbar-expand-sm justify-content-between fixed-top navbar-dark bottom-shadow bg-grad">
                        <div class="container-fluid content-center">
                            <a class="text-decoration-none logo" href="#">Bicos</a>
                            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar" onclick="myFunction(this)">
                                <!--<span class="navbar-toggler-icon"></span>-->
                                <div class="bar1"></div>
                                <div class="bar2"></div>
                                <div class="bar3"></div>
                            </button>
                            <div class="collapse navbar-collapse" id="mynavbar">
                                <ul class="nav-list navbar-nav me-auto navMenu">
                                    <li class="nav-item">
                                        <a class="nav-link menu" href="#second">Como Funciona</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link menu" href="#third">Serviços</a>
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
                                            <img class="iconcustom2" data-bs-toggle="dropdown" src="img/icon-profile.png"> 
                                            <ul class="dropdown-menu dropCustom">
                                                <li><a class="dropdown-item aCustom" href="profileFr.jsp?nome=<%= fr.getNomeFr() %>&email=<%= fr.getEmailFr() %>">Perfil</a></li>
                                                <li><a class="dropdown-item aCustom" href="projectsFr.jsp?nome=<%= fr.getNomeFr() %>&email=<%= fr.getEmailFr() %>">Meus Projetos</a></li>
                                                <li><a class="dropdown-item aCustom" href="pubAnunFr.jsp?nome=<%= fr.getNomeFr() %>&email=<%= fr.getEmailFr() %>">Publicar Anúncio</a></li>
                                                <li><a class="dropdown-item aCustom" href="#">Chat</a></li>
                                                <li><a class="dropdown-item aCustom" href="faq.html">FAQ</a></li>
                                                <li><a class="dropdown-item aCustom" href="index.html">Sair</a></li>
                                            </ul>
                                            <span class="nome">
                                                <%= fr.getNomeFr() %>
                                            </span>                                        
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </nav>

                </div>

                <div class="container mh">
                    <div class="row">
                        <div class="col-md-6 align-self-center pd-top line-d">
                            <h2 class="first-desc">Ache o melhor Freelancer para seu trabalho.</h2>
                            <button type="button" class="btn-job btn btn-outline-light">Trabalhos disponiveis</button>
                        </div>
                        <div class="col-md-6 align-self-center pd-top text-end div-showcase">
                            <img class="showcase" src="./img/showcase.png" alt="#">
                        </div>
                    </div>
                </div>
            </section>

            <div class="bg-logo">
                <img class="img-bg-logo" src="img/bg-logo.png">
            </div>

            <!--SECOND-PAGE-->

            <section id="second" class="second-container">
                <div class="container mh2">
                    <div class="row">
                        <div class="col-md-6 align-self-center pd-top line-d">
                            <h2 class="second-title">Como funciona?</h2><br/ ><br/ >
                            <h3 class="second-desc">A plataforma Bicos oferece oportunidades de trabalho para freelancers de diversas áreas. Aqui, você pode publicar ou encontrar projetos, além de encontrar freelancers para a realização de uma tarefa.</h3>
                            <button type="button" class="btn-more"><a class="a-norm" href="howworkFr.jsp?nome=<%= fr.getNomeFr() %>&email=<%= fr.getEmailFr() %>" style="text-decoration: none;">Ver mais</a></button>
                        </div>
                        <div class="col-md-6 align-self-center pd-top text-end div-showcase">
                            <div class="second-showcase container">
                                <img class="second-img" src="./img/undrawconn1.png" alt="#">
                            </div>
                        </div>
                    </div>
                </div>
                <a class="descer" href="#third">
                    <span class="botao"></span>
                </a>
            </section>

            <!--THIRD-PAGE-->

            <section id="third" class="second-container">
                <div class="container mh3">
                    <h2 class="second-title">Serviços oferecidos</h2><br/ ><br/ >
                    <div class="row third-show  row-c3">
                        <div class="col-md-4 align-self-center pd-top line-d">
                            <div class="third-showcase">
                                <div class="padding-third">
                                    <div class="row">
                                        <div class="col-md-7 align-self-center pd-top line-d">
                                            <h1 class="type-title">Designer Gráfico</h1>
                                        </div>
                                        <div class="col-md-5 align-self-center pd-top line-d">
                                            <img class="type-img">
                                        </div>
                                    </div>
                                    <h2 class="type-desc">Encontre os melhores designers disponíveis. Esse serviço é excelente para crição de logotipos diversos, interface gráfica de aplicações, arte para estampas, etc.</h2>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 align-self-center pd-top line-d">
                            <div class="third-showcase">
                                <div class="padding-third">
                                    <div class="row">
                                        <div class="col-md-7 align-self-center pd-top line-d">
                                            <h1 class="type-title">Desenvolvedor Web</h1>
                                        </div>
                                        <div class="col-md-5 align-self-center pd-top line-d">
                                            <img class="type-img">
                                        </div>
                                    </div>
                                    <h2 class="type-desc">Encontre os melhores desenvolvedores disponíveis. Esse serviço é perfeito para projetos de criação de Web Sites, HTML, Bootstrap, PHP, JSP, etc. </h2>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 align-self-center pd-top line-d">
                            <div class="third-showcase">
                                <div class="padding-third">
                                    <div class="row">
                                        <div class="col-md-7 align-self-center pd-top line-d">
                                            <h1 class="type-title">Certificado em SEO</h1>
                                        </div>
                                        <div class="col-md-5 align-self-center pd-top line-d">
                                            <img class="type-img">
                                        </div>
                                    </div>
                                    <h2 class="type-desc">Encontre os melhores freelancers disponíveis. Esse serviço é perfeito para projetos de Wordpress, SEO, PHP, Link Building, etc.</h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <button type="button" class="btn-more more"><a class="a-norm" href="jobs.jsp?nome=<%= fr.getNomeFr() %>&email=<%= fr.getEmailFr() %>" style="text-decoration: none;"> Ver mais </a></button>
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