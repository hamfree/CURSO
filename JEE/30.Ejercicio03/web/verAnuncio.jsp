<%-- 
    Document   : verAnuncio
    Created on : 21-oct-2015, 17:57:11
    Author     : curso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gracias, por publicar su anuncio</title>
    </head>
    <body>
        <h1 style='text-align: center'>Gracias</h1>
        <p style='text-align: center'>
            Vendo : <%=request.getAttribute("tema")%><br>
            Descripcion: <%=request.getAttribute("texto")%><br>
        </p>
    </body>
</html>
