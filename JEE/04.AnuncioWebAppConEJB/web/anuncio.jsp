<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal de Anuncios. Indique su anuncio</title>
    </head>
    <body style="text-align: center">
        <h1> Bienvenido, ${atusuario.nombre}  ${atuario.apellido}</h1>
        <h2>Indique los parámetros de su anuncio</h2>
        <form action="<%= response.encodeURL("anuncio")%> ">
            <p>Tema: <input type="text" name="tema"  /></p>
            <p>Texto: <input type="text" name="texto" /></p>
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
