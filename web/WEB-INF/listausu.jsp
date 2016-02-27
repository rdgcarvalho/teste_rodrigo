<%@page import="entidade.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de usuarios</title>
        
        <script type="text/javascript">
            function confirmaExclusao(id){
                if(window.confirm("Tem certeza que quer excluir?")){
                    location.href="usucontroller.do?acao=exc&id="+id;
                }
            }
        </script>
    </head>
    <body>
        <h1>Tabela test</h1>
            
              <%List<Usuario> lista =(List<Usuario>)request.getAttribute("lista");%>
              <table border="1" rules="all">
                  <tr> <th> id </th> <th> nome </th> <th> açao </th></tr>
              <% for(Usuario u:lista){ %>
              <tr>
                  <td><% out.print(u.getId() );%></td>
                  <td><% out.print(u.getNome());%></td>
                  <td> <a href="javascript:confirmaExclusao(<% out.print(u.getId());%>)">excluir</a> | <a href="usucontroller.do?acao=alt&id=<% out.print(u.getId());%>">alterar</a>  </td>
              <tr>
             <% } %>
              
              
              </table>
    </body>
</html>
