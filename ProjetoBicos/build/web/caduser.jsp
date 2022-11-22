<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Tblusuario"%>
<%@page import="model.SistemaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <%
            SistemaDao dao;
            Tblusuario user;
            String mensagem, n, eml, cpf, date, ntel, pwd, gen;
            n = request.getParameter("name");
            cpf = request.getParameter("cpf");
            date = request.getParameter("date");
            eml  = request.getParameter("email");
            ntel  = request.getParameter("number");
            pwd  = request.getParameter("password");
            gen = request.getParameter("gender");
            
            // Conversão de String para Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dt = sdf.parse(date);
            
            user = new Tblusuario(); 
            user.setNomeUser(n);
            user.setCPFUser(cpf);
            user.setDataNascUser(dt);
            user.setEmailUser(eml);
            user.setTelUser(ntel);
            user.setSenhaUser(pwd);
            user.setGeneroUser(gen);
            
            dao = new SistemaDao();
            mensagem = dao.salvarUser(user);
            if(mensagem.equals("salvou")){
             response.sendRedirect("index.html");
            } else {
             out.print(mensagem);
            }
            
        %>
        
        
    </body>
</html>
