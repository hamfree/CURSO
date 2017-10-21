<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Introduzca su anuncio</title>
    </head>
    <body style="text-align: center">
        <h1>Introduzca su anuncio</h1>
        <p>
            Introduzca los datos de su anuncio, <%=request.getAttribute("nombre")%>
        </p>
        <p>
            Indique en el formulario a continuación los datos de su anuncio...
        </p>
        <form action='anuncio' method='post'>
            <p>Tema: <input type='text' name='tema' value='' /></p>
            <p>Texto: <input type='text' name='texto' value='' /></p>
            <p><input type='submit' value='Enviar' /></p>
        </form>
    </body>
</html>
