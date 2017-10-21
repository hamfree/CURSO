<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal de anuncios. Final del proceso</title>
    </head>
    <body style="text-align: center">
        <h1>Gracias por su anuncio, 
            <%-- Usando el lenguaje de expresiones EL (Expression Language) --%>
            ${atadiosusuario.nombre}
            ${atadiosusuario.apellido}
        </h1>

        <h2>El tema y texto de tu anuncio es el siguiente:</h2>
        <h3>TEMA</h3>
        <%-- Usando el lenguaje de expresiones EL (Expression Language) --%>
        <p>${atanuncio.tema}</p>
        <h3>TEXTO</h3>
        <%-- Usando el lenguaje de expresiones EL (Expression Language) --%>
        <p>${atanuncio.texto}</p>
        <!-- Accedemos a las cabeceras HTTP usando el Lenguaje de Expresiones EL  -->
        <p>
            Host.......... : ${header["host"]}<br>
            URL anterior.. : ${header["referer"]}
        </p>
    </body>
</html>