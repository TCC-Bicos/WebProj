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
                Tblusuario usu = new Tblusuario();
                for (FileItem item : items) {
                    if (item.isFormField()) { //se o campo for um campo comum de formulário
                        String name = item.getFieldName();
                        String value = item.getString();
                        if (name.equals("name")) {
                            usu.setNomeUser(value);
                        } else if (name.equals("desc")) {
                            usu.setDescUser(value);
                        } else if (name.equals("email")) {
                            usu.setEmailUser(value);
                        } else if (name.equals("n-senha")) {
                            usu.setSenhaUser(value);
                        } else if (name.equals("tel")) {
                            usu.setTelUser(value);
                        } else if (name.equals("email-antigo")) {
                            email_antigo = value;
                        }

                        // outros
                    } else { //se o campo for uma imagem
                        String fieldName = item.getFieldName();
                        String fileName = item.getName();
                        String nomeImagem = usu.getNomeUser() + "-" + fileName;
                        String caminhoSalvar = "F:\\Projeto\\ProjetoBicos\\web\\user_img\\" + nomeImagem;
                        File uploadFile = new File(caminhoSalvar);
                        item.write(uploadFile);
                        if (fieldName.equals("foto")) {
                            if (fileName.equals("")) {
                                SistemaDao dao = new SistemaDao();
                                Tblusuario usuario = dao.buscarUserEmlAntigo(email_antigo);
                                usu.setImgUser(usuario.getImgUser());
                            } else {
                                usu.setImgUser(nomeImagem);
                            }
                        }

                    }
                }
                SistemaDao dao = new SistemaDao();
                Tblusuario user = dao.alterarUser(usu, email_antigo);
                if (user != null) {
                    response.sendRedirect("profile.jsp?nome=" + usu.getNomeUser() + "&email=" + usu.getEmailUser());
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
