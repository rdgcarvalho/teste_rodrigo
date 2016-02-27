<%-- 
    Document   : formusuario
    Created on : 27/02/2016, 06:22:35
    Author     : rodrigo
--%>

<%@page import="entidade.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulário</title>
    </head>
    <body>
        <%
            Usuario u = (Usuario)request.getAttribute("usu");
        %>
        <form action="usucontroller.do" method="post">
            ID: <input type="number" name="id" value="<% out.print(u.getId()); %>"/>
            Nome:<input type="text" name="nome" value="<% out.print(u.getNome()); %>"/>
            Login:<input type="text" name="login" value="<% out.print(u.getLogin());%>"/>
            Senha:<input type="password" name="senha" value="<% out.print(u.getSenha());%>"/>
            
            <input type="submit" value="Salvar"/>
        </form>
    </body>
</html>
