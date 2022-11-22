<%-- 
    Document   : payment.jsp
    Created on : Nov 20, 2022, 10:49:57 PM
    Author     : Stefano
--%>
<%@page import="model.Tblusuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style-payment.css">
        <title> Pagamento | Bicos </title>
    </head>
    <body>
        <%
            String nome, email;
            nome = request.getParameter("nome");
            email = request.getParameter("email");
        %>
        <div class="big">
            <div class="main">
                <div class="title">
                    <h1> Escolha a Forma de Pagamento </h1>
                </div>
                <div class="content">
                    <div class="option">
                        <img src="img/transfer.png">
                        <a href="home.jsp?nome=<%= nome%>&email=<%= email%>"> Boleto </a>
                    </div>
                    <div class="option">
                        <img src="img/credit.png">
                        <a href="home.jsp?nome=<%= nome%>&email=<%= email%>"> Cartão de Crédito </a>
                    </div>
                    <div class="option">
                        <img src="img/debit.png">
                        <a href="home.jsp?nome=<%= nome%>&email=<%= email%>"> Cartão de Débito </a>
                    </div>
                    <div class="option">
                        <img src="img/pix.png">
                        <a href="home.jsp?nome=<%= nome%>&email=<%= email%>"> Pix </a>
                    </div>
                </div>
            </div>
        </div>

        <!--ANIMAÇÃO--> 
        <script src="https://unpkg.com/aos@next/dist/aos.js"></script>
        <script> AOS.init({duration:1500}); </script>
        
    </body>
</html>
