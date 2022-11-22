<%@page import="model.Tblfreelancer"%>
<%@page import="model.SistemaDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
            Tblfreelancer fr;
            String mensagem, n, eml, cpf, date, ntel, pwd, desc, gen;
            n = request.getParameter("name");
            cpf = request.getParameter("cpf");
            date = request.getParameter("date");
            eml  = request.getParameter("email");
            ntel  = request.getParameter("number");
            pwd  = request.getParameter("password");
            desc = request.getParameter("desc");
            gen = request.getParameter("gender");
            
            // Conversão de String para Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dt = sdf.parse(date);
            
            fr = new Tblfreelancer(); 
            fr.setNomeFr(n);
            fr.setCPFFr(cpf);
            fr.setDataNascFr(dt);
            fr.setEmailFr(eml);
            fr.setTelFr(ntel);
            fr.setSenharFr(pwd);
            fr.setDescFr(desc);
            fr.setGeneroFr(gen);
            
            dao = new SistemaDao();
            mensagem = dao.salvarFree(fr);
            if(mensagem.equals("salvou")){
             response.sendRedirect("index.html");
            } else {
             out.print(mensagem);
            }
            
        %>
        
        
    </body>
</html>
