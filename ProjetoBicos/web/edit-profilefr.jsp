<%@page import="model.Tblfreelancer"%>
<%@page import="model.Tblusuario"%>
<%@page import="model.SistemaDao"%>
<!DOCTYPE html>
<html Lang="pt">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
        <META HTTP-EQUIV="Expires" CONTENT="-1">
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
        <link rel="stylesheet" href="css/edit-profile.css" />
        <link rel="stylesheet" href="css/responsive.css" />

    </head>
    <body>
        <%
            SistemaDao dao;
            Tblfreelancer fr;
            
            fr = (Tblfreelancer) request.getAttribute("user");
            
            String nome, email, pwd, tel, desc, img;
            nome = request.getParameter("nome");
            email = request.getParameter("email");

            dao = new SistemaDao();
            fr = dao.buscarFree(nome, email);
            //if (user == null) {

            //} 
            pwd = fr.getSenharFr();
            tel = fr.getTelFr();
            desc = fr.getDescFr();
            img = fr.getImgFr();

        %>  
        <main>
            <div class="container-xl px-4 mt-4">
                <nav class="nav nav-borders">
                    <a class="nav-link active ms-0" target="__blank">Editar Perfil</a>
                </nav>
                <hr class="mt-0 mb-4">
                <div class="row">
                    <form method="post" action="prof-editedfr.jsp" id="formulario" enctype='multipart/form-data'>
                        <div class="col-xl-8">
                            <div class="card mb-4">
                                <div class="card-header">Detalhes da conta</div>
                                <div class="card-body">

                                    <div class="mb-3">
                                        <label class="small mb-1" for="name">Nome</label>
                                        <input class="form-control" id="name" name="name" type="text" value="<%= nome%>">
                                    </div>
                                    <div class="mb-3">
                                        <label class="small mb-1" for="desc">Descrição</label>
                                        <% if (desc == null) { %>     
                                        <input class="form-control" id="desc" name="desc" value="" type="text" placeholder="Ex: Lorem ipsum dolor sit amet, consectetur adipiscing elit.">
                                        <% } else {%>
                                        <input class="form-control" id="desc" name="desc" value="<%= desc%>" type="text" placeholder="Ex: Lorem ipsum dolor sit amet, consectetur adipiscing elit.">

                                        <% }%>
                                    </div>
                                    <div class="mb-3">
                                        <label class="small mb-1" for="email">Email</label>
                                        <input id="email" name="email-antigo" type="hidden" value="<%= email%>">
                                        <input class="form-control" id="email" name="email" type="email" value="<%= email%>">
                                    </div>
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-6">
                                            <label class="small mb-1" for="conf-senha">Senha Atual</label>
                                            <input class="form-control" id="conf-senha" name="conf-senha" type="password">
                                            <input class="form-control" id="senha-atual" name="senha-atual" type="hidden" value="<%= pwd%>">
                                        </div>
                                        <div class="col-md-6">
                                            <label class="small mb-1" for="n-senha">Nova Senha</label>
                                            <input class="form-control" id="n-senha" name="n-senha" type="password">
                                        </div>
                                    </div>
                                    <div class="mb-3">
                                        <label class="small mb-1" for="tel">Numero de Telefone</label>
                                        <input class="form-control" id="tel" name="tel" type="tel" placeholder="Ex: 11 99888-7777" value="<%= tel%>">
                                    </div>

                                    <div class="col-xl-4">
                                        <div class="card mb-4 mb-xl-0">
                                            <div class="card-header">Foto de Perfil</div>
                                            <div class="card-body text-center">
                                                <% if (img == null) {  %>
                                                <img class="img-account-profile rounded-circle mb-2" src="img/icon-profile.png" alt="">
                                                <div class="small font-italic text-muted mb-4">JPG ou PNG max 5MB</div>
                                                <input class="btn btn-primary save" type="file" name="foto" value="Carregar Imagem">
                                                <%} else {%>
                                                <img class="img-account-profile rounded-circle mb-2" src="user_img/<%= img%>" alt="">
                                                <div class="small font-italic text-muted mb-4">JPG ou PNG max 5MB</div>
                                                <input class="btn btn-primary save" type="file" name="foto" value="<%=img%>">
                                                <% }%>


                                            </div>
                                        </div>
                                    </div>

                                    <div class="btns">
                                        <input type="button" value="Salvar Mudanças" class="btn btn-primary save" onclick="validarSenha()">
                                        <button class="btn btn-primary txt-end cancel" type="button"><a class="a-norm" href="profile.jsp">Cancelar</a></button>
                                        <p id="mensagem"></p>
                                    </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                </div>
            </div>
        </main>


        <script>
            function myFunction(x) {
                x.classList.toggle("change");
            }

            function validarSenha() {
                document.getElementById("mensagem").innerHTML = "";
                let formulario = document.getElementById("formulario");
                let p = document.getElementById("senha-atual").value;
                let cp = document.getElementById("conf-senha").value;
                if (p === cp) {
                    formulario.submit();
                } else {
                    document.getElementById("mensagem").innerHTML = "Senha atual não é válida.";
                    p.focus();
                }
            }
        </script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
        <script src="js/bootstrap.min.js"></script> 

    </body>
</html>

