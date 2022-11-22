<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Tblusuario"%>
<%@page import="model.Tblanunuser"%>
<%@page import="model.Tbltiposervico"%>
<%@page import="model.SistemaDao"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/customPubAnun.css">
        <link rel="stylesheet" href="css/responsive.css" />
        <title> Editar Anúncio | Bicos </title>
    </head>
    <body>
        <%
            SistemaDao dao;
            Tblusuario user;
            Tblanunuser anunUser;
            Tbltiposervico tps;
            int id;
            String mensagem, nome, email, t, v, nonServ, dt, dc, rq;

            id = Integer.parseInt(request.getParameter("idAnun"));
            nome = request.getParameter("nome");
            email = request.getParameter("email");
            
            t = request.getParameter("titulo");
            
            v = request.getParameter("valor");
            nonServ = request.getParameter("tipoServ"); // se não der certo, reveja essa linha
            dt = request.getParameter("data");
            rq = request.getParameter("requisitos");
            dc = request.getParameter("desc");

            dao = new SistemaDao();
            user = dao.buscarUser(nome, email);

            //Pegando o ID
            //int id = user.getIdUser();
            // Coversão de String para Double
            double price = Double.parseDouble(v);

            // Conversão de String para Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dt);

            //int id, String n, String t, String desc, double p, String r, Date d
            int retorno = dao.alterarAnunUser(id, nonServ, t, dc, price, rq, date);
            if(retorno==1){
            response.sendRedirect("projects.jsp?nome="+nome+"&email="+email);
            }else{
              mensagem="Erro na alteração";
              response.sendRedirect("mensagens.jsp?mensagem=" + mensagem);
            }
            // Tentativa de Conversão
            //user = new Tblusuario(id);
            //tps = new Tbltiposervico(r);
            /*
            
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

             */
        %>
    </body>
</html>
