<%-- 
    Document   : pubAnunFr
    Created on : Nov 14, 2022, 3:51:58 PM
    Author     : Stefano
--%>

<%@page import="java.sql.*"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="model.Tbltiposervico"%>
<%@page import="model.Tblfreelancer"%>
<%@page import="model.SistemaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/customPubAnun.css">
        <link rel="stylesheet" href="css/responsive.css" />
        <title> Criar Anúncio | Bicos </title>
    </head>
    <body>
        <%
            Tblfreelancer fr;

            fr = (Tblfreelancer) request.getAttribute("fr");
            //if (user == null) {
            //    response.sendRedirect("index.html");
            //}

            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            SistemaDao dao = new SistemaDao();
            fr = dao.buscarFree(nome, email);
        %>
        <div class="container">
            <div class="form-image">
                <label for="contract" class="label-contract">Inserir Arquivo</label>
                <input id="contract" type="file" name="contract" placeholder="Inserir Arquivo">
            </div>
            <div class="form">
                <form action="pubAnunFrBack.jsp?nome=<%= nome%>&email=<%= email%>" id="formPubFr">
                    <div class="form-header">
                        <div class="title">
                            <h1> Anunciar </h1>
                        </div>
                    </div>
                    
                    <input id="nome" type="hidden" name="nome" value="<%= nome%>">
                    <input id="email" type="hidden" name="email" value="<%= email%>">
                    
                    <div class="input-group">
                        <div class="input-box">
                            <label for="title">Nome do Projeto</label>
                            <input id="title" type="text" name="title" placeholder="Digite o Nome" required>
                        </div>

                        <div class="input-box">
                            <label for="valor">Valor</label>
                            <input id="valor" type="text" name="valor" placeholder="R$0,00" required>
                        </div>

                        <div class="input-box long">
                            <label for="lang">Tipo de Serviço</label>
                            <select name="tipoServ" id="tipoServ">
                                <%
                                try {
                                    String Query = "select * from Tbltiposervico";
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema?useTimezone=true&serverTimezone=UTC&useSSL=false", "root", "dr34q1cv");
                                    Statement stm = conn.createStatement();
                                    ResultSet rs = stm.executeQuery(Query);
                                    while(rs.next()) {
                                        %>
                                        <option value="<%= rs.getString("nomeServ")%>"> <%=rs.getString("nomeServ")%> </option>
                                        <%
                                    }
                                } 
                                catch (Exception e) {

                                }
                                %>
                            </select>
                        </div>

                        <div class="input-box date">
                            <label for="data">Data</label>
                            <input id="data" type="date" name="data" required>
                        </div>

                        <div class="input-box longText">
                            <label for="desc">Descrição</label>
                            <textarea class="high" id="desc" type="text" name="desc" placeholder="Digite a Descrição" required></textarea>
                        </div>
                    
                    </div> 

                    <div class="continue-button">
                        <button type="button" class="btn btn-primary continue-button" onclick="Anunciar()"> Criar </button>
                    </div>
                </form>
            </div>
        </div>
        
        <script>
            function Anunciar() {
                formPubFr.submit();
            }
        </script>
    </body>
</html>