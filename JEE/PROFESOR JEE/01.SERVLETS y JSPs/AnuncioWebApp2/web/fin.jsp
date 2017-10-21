<%-- 
    Document   : fin
    Created on : 21-oct-2015, 19:20:50
    Author     : curso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Gracias por tu anuncio</h1>
        <%--
           <%=    ((modelo.Usuario)request.getAttribute("atusuario")).getNombre()    %>
          <%=    ((modelo.Usuario)request.getAttribute("atusuario")).getApellido()    %>
          <P>
        <%=    ((modelo.Anuncio)request.getAttribute("atanuncio")).getTema()    %>
         <%=    ((modelo.Anuncio)request.getAttribute("atanuncio")).getTexto() %>
        --%>
        
        <%--
        <jsp:useBean id="atusuario" class="modelo.Usuario" scope="request" />
        <jsp:getProperty name="atusuario" property="nombre" />
        <jsp:getProperty name="atusuario" property="apellido" />
        <P></P>
        <jsp:useBean id="atanuncio" class="modelo.Anuncio" scope="request" />
        <jsp:getProperty name="atanuncio" property="tema" />
        <jsp:getProperty name="atanuncio" property="texto" />
        --%>
        ${atusuario.nombre}  <BR>
        ${atusuario.apellido} <BR>
        
        ${atanuncio.tema}  <BR>
        ${atanuncio.texto} <BR>

    </body>
</html>
