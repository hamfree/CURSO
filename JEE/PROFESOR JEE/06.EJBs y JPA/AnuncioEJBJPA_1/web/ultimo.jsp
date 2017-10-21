<%-- 
    Document   : ultimo
    Created on : 08-feb-2012, 13:54:10
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
        ${sessionScope.atusuario.nombre} <BR/>
        ${atusuario.apellido}
        
        <h1>Tu tema y mensaje es:</h1>
         ${atanuncio.tema}<P/>
          ${atanuncio.mensaje}<P/>
    </body>
</html>
