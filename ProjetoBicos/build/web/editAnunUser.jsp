<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="model.Tblanunuser"%>
<%@page import="java.sql.*"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="model.Tbltiposervico"%>
<%@page import="model.Tblusuario"%>
<%@page import="model.SistemaDao"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/customPubAnun.css">
        <link rel="stylesheet" href="css/responsive.css" />
        <title> Editar Anuncio | Bicos </title>
    </head>
    <body>
        <%
            Tblusuario user;
            Tblanunuser anunUser;

            // user = (Tblusuario) request.getAttribute("user");
            //anun = (Tblanunuser) request.getAttribute("anun");
            //String titulo, valor, data;
            //if (user == null) {
            //    response.sendRedirect("index.html");
            //}
            // titulo = anun.getTituloAnunUser();
            //valor = anun.getPrecoAnunUser();
            //data = anun.getDataAnunUser();
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            SistemaDao dao = new SistemaDao();
            user = dao.buscarUser(nome, email);
            anunUser = dao.buscarAnun(id);

            //SimpleDateFormat formatBra;
            //formatBra = new SimpleDateFormat("dd/MM/yyyy",Locale.US);
            //Date data = formatBra.parse(anunUser.getDataAnunUser().toString());

        %>
        <div class="container">
            <div class="form-image">
                <label for="contract" class="label-contract">Inserir Arquivo</label>
                <input id="contract" type="file" name="contract" placeholder="Inserir Arquivo">
            </div>
            <div class="form">
                <form method="post" action="editpubAnunUser.jsp" id="formPubUser">
                    <div class="form-header">
                        <div class="title">
                            <h1> Editar Anuncio </h1>
                        </div>
                    </div>

                    <input id="nome" type="hidden" name="nome" value="<%= nome%>">
                    <input id="email" type="hidden" name="email" value="<%= email%>">
                    <input id="idAnun" type="hidden" name="idAnun" value="<%= anunUser.getIdAnunUser()%>">

                    <div class="input-group">
                        <div class="input-box">
                            <label for="title">Nome do Projeto</label>
                            <!--<input id="title" type="text" name="title" placeholder="Ex: Logotipo Empresarial" required>-->
                            <input class="form-control" id="title" name="titulo" type="text" value="<%= anunUser.getTituloAnunUser()%>">
                        </div>

                        <div class="input-box">
                            <label for="valor">Valor do Projeto</label>
                            <!--<input id="valor" type="text" name="valor" placeholder="R$0,00" required>-->
                            <input class="form-control" id="title" name="valor" type="text" value="<%= anunUser.getPrecoAnunUser()%>">                           
                        </div>

                        <div class="input-box long">
                            <label for="tipoServ">Tipo de Serviço</label>
                            <input class="form-control" id="tipoServ" name="tipoServ" type="text" value="<%= anunUser.getNomeServ().getNomeServ() %>" readonly>   
                        </div>

                        <div class="input-box date">
                            <label for="data">Data</label>
                            <!--<input id="data" type="date" name="data" required>-->
                            <input class="form-control" id="data" name="data" type="date" required>
                        </div>

                        <div class="input-box longText">
                            <label for="requisitos">Requisitos</label>
                            <textarea class="high" id="requisitos" type="text" name="requisitos" required><%= anunUser.getRequisitosAnunUser()%></textarea>

                        </div>

                        <div class="input-box longText">
                            <label for="desc">Descrição</label>
                            <textarea class="high" id="desc" type="text" name="desc" required><%= anunUser.getDescAnunUser()%></textarea>
                        </div>

                    </div> 

                    <div class="continue-button">
                        <button type="button" class="btn btn-primary continue-button" onclick="Anunciar()"> Salvar Alteração </button>
                    </div>
                </form>
            </div>
        </div>

        <script>
            function Anunciar() {
                if (document.getElementById("data").value === "") {
                    alert("Digite uma data válida");
                } else {
                    formPubUser.submit();
                }
            }

        </script>
    </body>
</html>