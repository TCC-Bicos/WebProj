<%-- 
    Document   : loguser
    Created on : 8 de out. de 2022, 19:05:09
    Author     : Pedro Teruel
--%>

<%@page import="model.Tblusuario"%>
<%@page import="model.SistemaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            SistemaDao dao;
            Tblusuario user;
            String mensagem, eml, sen;
            eml = request.getParameter("email");
            sen = request.getParameter("senha");

            dao = new SistemaDao();
            user = dao.validarLogin(eml, sen);
            if (user == null) {
                mensagem = "Usuário e/ou senha inválidos";
                request.setAttribute("mensagem", mensagem);
                RequestDispatcher disp = request.getRequestDispatcher("loginerro.jsp");
                disp.forward(request, response);                
            } else {
                request.setAttribute("user", user);
                RequestDispatcher disp = request.getRequestDispatcher("home.jsp?nome="+ user.getNomeUser() +"&email=" + user.getEmailUser());
                disp.forward(request, response);
            }

        %>

    </body>
</html>
