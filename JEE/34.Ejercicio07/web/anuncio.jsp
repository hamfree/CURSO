<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal de Anuncios. Introduzca su anuncio</title>
    </head>
    <body>
        <h1> Bienvenido ${atusuario.nombre} ${atusuario.apellido}</h1>
        <p>Introduzca los datos de su anuncio a continuación:</p>
        <form action="<%= response.encodeURL("anuncio")%>"  style="font-family: monospace;">
            Tema ......: <input type="text" name="tema"  /><br>
            Texto .....: <input type="text" name="texto" /><br>
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
