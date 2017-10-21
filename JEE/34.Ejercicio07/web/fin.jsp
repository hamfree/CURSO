<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Su anuncio ha sido publicado</title>
    </head>
    <body>
        <h1>Gracias por su anuncio, señor ${atusuario.nombre} ${atusuario.apellido}</h1>
        <p>
            Su anuncio es el siguiente:
        </p>
        <p style="font-family: monospace;border : 1px solid red;">
            Tema ............: ${atanuncio.tema}<br>
            Descripcion .....: ${atanuncio.texto}
        </p>
        <p>
            <a href="index.jsp">Volver al inicio</a>
        </p>
    </body>
</html>
