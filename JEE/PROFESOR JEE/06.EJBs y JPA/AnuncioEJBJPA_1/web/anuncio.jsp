<%-- 
    Document   : fin
    Created on : 08-feb-2012, 13:08:42
    Author     : Infomática
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido</h1>



     
        ${sessionScope.atusuario.nombre} <BR/>
        ${atusuario.apellido}
    </P>
        <form action="anuncio">
            Tema: <input type="text" name="tema" size="30" /><BR>
            Mensaje: <input type="text" name="msg" size="50" /><BR>
            <input type="submit" value="enviar" />
        </form>

    </body>
</html>
