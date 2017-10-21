<%-- 
    Document   : anuncio
    Created on : 21-oct-2015, 19:14:56
    Author     : curso
--%>

<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <H1> Bienvenido 
          
          <%=    ((Usuario)session.getAttribute("atusuario")).getNombre()    %>
          <%=    ((Usuario)session.getAttribute("atusuario")).getApellido()    %>
           
             <%--
             <jsp:useBean id="atusuario" class="modelo.Usuario" scope="session" />
             <jsp:getProperty name="atusuario" property="nombre" />
             <jsp:getProperty name="atusuario" property="apellido" />
          --%>
          ${atusuario.nombre}  <BR>
          ${atusuario.apellido}
          
        </H1>
          <!--
        <form action="anuncio" >
            -->
            <form action="<%= response.encodeURL("anuncio") %> ">
            Tema: <input type="text" name="tema"  /><BR>
            Texto: <input type="text" name="texto" /><BR>
            <input type="submit" value="Enviar" />
        </form>

    </body>
</html>
