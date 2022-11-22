<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Tblusuario"%>
<%@page import="model.Tblanunuser"%>
<%@page import="model.Tbltiposervico"%>
<%@page import="model.SistemaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.*"%>

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
            Tblanunuser anunUser;
            Tbltiposervico tps;
            String mensagem,nome,email,t,v,r,dt,dc,rq;
            
            nome = request.getParameter("nome");
            email = request.getParameter("email");
            t = request.getParameter("title");
            v = request.getParameter("valor");
            r = request.getParameter("tipoServ"); // se não der certo, reveja essa linha
            dt = request.getParameter("data");
            rq = request.getParameter("requisitos");
            dc = request.getParameter("desc");
            
            dao = new SistemaDao();
            user = dao.buscarUser(nome, email);
            
            //Pegando o ID
            int id = user.getIdUser();
            
            // Coversão de String para Double
            double price = Double.parseDouble(v);
            
            // Conversão de String para Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dt);
            
            // Tentativa de Conversão
            user = new Tblusuario(id);
            tps = new Tbltiposervico(r);
            
            
            anunUser = new Tblanunuser();
            anunUser.setIdUser(user);
            anunUser.setTituloAnunUser(t);
            anunUser.setPrecoAnunUser(price);
            anunUser.setNomeServ(tps);
            anunUser.setDataAnunUser(date);
            anunUser.setRequisitosAnunUser(rq);
            anunUser.setDescAnunUser(dc);
            
            mensagem = dao.salvarAnunUser(anunUser);
            if(mensagem.equals("salvou")){
             response.sendRedirect("anunUser.jsp?id=" + anunUser.getIdAnunUser() + "&nome=" + nome + "&email=" + email);
            } else {
             out.print(mensagem);
            }
        %>
    </body>
</html>
