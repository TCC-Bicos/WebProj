<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Tblfreelancer"%>
<%@page import="model.Tblanunfr"%>
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
            Tblfreelancer fr;
            Tblanunfr anunFr;
            Tbltiposervico tps;
            String mensagem,nome,email,t,v,r,dt,dc;
            
            nome = request.getParameter("nome");
            email = request.getParameter("email");
            t = request.getParameter("title");
            v = request.getParameter("valor");
            r = request.getParameter("tipoServ"); // se não der certo, reveja essa linha
            dt = request.getParameter("data");
            dc = request.getParameter("desc");
            
            dao = new SistemaDao();
            fr = dao.buscarFree(nome, email);
            
            //Pegando o ID
            int id = fr.getIdFr();
            
            // Coversão de String para Double
            double price = Double.parseDouble(v);
            
            // Conversão de String para Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dt);
            
            // Tentativa de Conversão
            fr = new Tblfreelancer(id);
            tps = new Tbltiposervico(r);
            
            
            anunFr = new Tblanunfr();
            anunFr.setIdFr(fr);
            anunFr.setTituloAnunFr(t);
            anunFr.setPrecoAnunFr(price);
            anunFr.setNomeServ(tps);
            anunFr.setDataAnunFr(date);
            anunFr.setDescAnunFr(dc);
            
            mensagem = dao.salvarAnunFree(anunFr);
            if(mensagem.equals("salvou")){
             response.sendRedirect("anunFr.jsp?id=" + anunFr.getIdAnunFr() + "&nome=" + nome + "&email=" + email);
            } else {
             out.print(mensagem);
            }
        %>
    </body>
</html>
