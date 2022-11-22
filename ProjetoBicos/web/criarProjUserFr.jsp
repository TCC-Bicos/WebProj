<%-- 
    Document   : criarProjUserFr
    Created on : Nov 19, 2022, 6:39:24 PM
    Author     : Stefano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.SistemaDao"%>
<%@page import="model.Tblfreelancer"%>
<%@page import="model.Tblanunuser"%>
<%@page import="model.Tblanunuserfr"%>
<%@page import="model.Tblprojanunuser"%>
<%@page import="model.TblnotifU"%>
<%@page import="java.util.Date"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            SistemaDao dao;
            Tblfreelancer fr, idFr;
            Tblanunuser anunUser, idAnunUser;
            Tblanunuserfr anunUserFr, idSend;
            Tblprojanunuser prjAnunUser;
            TblnotifU notifU;
            String idRec, nome, email, mensagem, mensagem1, mensagem2;
            int idAnun, id;
            Date date;
            
            idRec = request.getParameter("id");
            nome = request.getParameter("nome");
            email = request.getParameter("email");
            
            dao = new SistemaDao();
            
            fr = dao.buscarFree(nome, email);
            int idFree = fr.getIdFr();
            idFr = new Tblfreelancer(idFree);
            
            idAnun = Integer.parseInt(idRec);
            
            //Buscar dados da TblAnunUser
            anunUser = dao.buscarAnun(idAnun);
            id = anunUser.getIdAnunUser();
            idAnunUser = new Tblanunuser(id); //Converter int para TblAnunUser
            
            //Adicionar dados na TblAnunUserFr
            String nomeAnun, descAnun;
            
            nomeAnun = anunUser.getTituloAnunUser();
            descAnun = anunUser.getDescAnunUser();
            
            anunUserFr = new Tblanunuserfr();
            anunUserFr.setIdAnunUser(idAnunUser);
            anunUserFr.setIdFr(idFr);
            anunUserFr.setNomeAnunUser(nomeAnun);
            anunUserFr.setDescAnunUser(descAnun);
            
            mensagem = dao.salvarAnunUserFr(anunUserFr);
            if(mensagem.equals("salvou")) {
            
                int idAnunUserFr = anunUserFr.getIdAnunUserFr();
                idSend = new Tblanunuserfr(idAnunUserFr);
                //Adicionar dados na Tblprojanunuser
                date = anunUser.getDataAnunUser();

                prjAnunUser = new Tblprojanunuser();
                prjAnunUser.setIdAnunUserFr(idSend);
                prjAnunUser.setDataInicioProjAnunUser(date);

                //Adicionar dados na Tblnotifu
                notifU = new TblnotifU();
                notifU.setIdAnunUserFr(idSend);
                notifU.setMensagemNotiFU(nome + " aceitou a sua solicitação de serviço!");

                mensagem1 = dao.salvarPrjAnunUser(prjAnunUser);
                mensagem2 = dao.salvarNotiFU(notifU);
                if(mensagem1.equals("salvou")){
                    if(mensagem2.equals("salvou")) {
                        response.sendRedirect("homeFr.jsp?nome=" + nome + "&email=" + email);
                    }
                } else {
                 out.print(mensagem1 + mensagem2);
                }
            } else {
                out.print(mensagem);
            }
            
            
        %>
    </body>
</html>
