<%-- 
    Document   : prof-edited
    Created on : 13 de out. de 2022, 16:23:28
    Author     : Pedro Teruel
--%>

<%@page import="org.apache.commons.io.FileExistsException"%>
<%@page import="org.apache.commons.fileupload.FileUploadException"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="model.Tblusuario"%>
<%@page import="model.Tblfreelancer"%>
<%@page import="model.SistemaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
        <META HTTP-EQUIV="Expires" CONTENT="-1">
    </head>
    <body>
        <%
            String email_antigo = "";
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                List<FileItem> items = upload.parseRequest(request);
                Tblfreelancer usu = new Tblfreelancer();
                for (FileItem item : items) {
                    if (item.isFormField()) { //se o campo for um campo comum de formulário
                        String name = item.getFieldName();
                        String value = item.getString();
                        if (name.equals("name")) {
                            usu.setNomeFr(value);
                        } else if (name.equals("desc")) {
                            usu.setDescFr(value);
                        } else if (name.equals("email")) {
                            usu.setEmailFr(value);
                        } else if (name.equals("n-senha")) {
                            usu.setSenharFr(value);
                        } else if (name.equals("tel")) {
                            usu.setTelFr(value);
                        } else if (name.equals("email-antigo")) {
                            email_antigo = value;
                        }

                        // outros
                    } else { //se o campo for uma imagem
                        String fieldName = item.getFieldName();
                        String fileName = item.getName();
                        String nomeImagem = usu.getNomeFr() + "-" + fileName;
                        String caminhoSalvar = "F:\\Projeto\\ProjetoBicos\\web\\user_img\\" + nomeImagem;
                        File uploadFile = new File(caminhoSalvar);
                        item.write(uploadFile);
                        if (fieldName.equals("foto")) {
                            if (fileName.equals("")) {
                                SistemaDao dao = new SistemaDao();
                                Tblfreelancer usuario = dao.buscarUserEmlAntigoFr(email_antigo);
                                usu.setImgFr(usuario.getImgFr());
                            } else {
                                usu.setImgFr(nomeImagem);
                            }
                        }

                    }
                }
                SistemaDao dao = new SistemaDao();
                Tblfreelancer fr = dao.alterarFr(usu, email_antigo);
                if (fr != null) {
                    response.sendRedirect("profilefr.jsp?nome=" + usu.getNomeFr() + "&email=" + usu.getEmailFr());
                    String a = "";
                } else {
                    out.print("Erro ao tentar salvar a alteracao");
                }
            } catch (FileUploadException ex) {
                out.print("Erro" + ex.getMessage());
            } catch (FileExistsException ex) {
                out.print("A foto já foi utilizada para este usuário");
            } catch (Exception ex) {
                out.print("Erro" + ex.getMessage());
            }
        %>

    </body>
</html>
