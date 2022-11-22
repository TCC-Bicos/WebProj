<%@page import="model.Tblusuario"%>
<%@page import="model.Tblanunuser"%>
<%@page import="model.TblofertauF"%>
<%@page import="model.SistemaDao"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String nome,email,idAnunUser,prop,mensagem;
            SistemaDao dao;
            Tblusuario user;
            Tblanunuser anunUser;
            TblofertauF ofertaUser;
            
            idAnunUser = request.getParameter("id");
            nome = request.getParameter("nome");
            email = request.getParameter("email");
            prop = request.getParameter("proposta");
            
            //Conversão de String para Int
            int id = Integer.parseInt(idAnunUser);
            
            //Conversão de String para Double
            double proposta = Double.parseDouble(prop);
            
            dao = new SistemaDao();
            user = dao.buscarUser(nome, email);
            anunUser = dao.buscarAnun(id);
            
            int idUser = user.getIdUser();
            
            ofertaUser = new TblofertauF();
//         idUser = ofertaUser.getIdAnunFr();
            
            mensagem = dao.salvarAnunUser(anunUser);
            if(mensagem.equals("salvou")){
             response.sendRedirect("home.jsp?nome=" + nome + "&email=" + email);
            } else {
             out.print(mensagem);
            }
        %>
    </body>
</html>
