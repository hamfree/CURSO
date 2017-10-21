<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="text-align: center">
        <h1>Gracias por su anuncio</h1>
        <h2>${atusuario.nombre} ${atusuario.apellido} </h2>
        
        <h3>Su anuncio es el siguiente:</h3>
        <p>${atanuncio.tema}</p>
        <p>${atanuncio.texto}</p>
    </body>
</html>
