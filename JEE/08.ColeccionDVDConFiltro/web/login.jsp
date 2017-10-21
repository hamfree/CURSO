<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Coleccion de DVD. Inicio de sesion</title>
    </head>
    <body>
        <h1>Inicio de sesion</h1>
        <form name="frmLogin" action="do?accion=login" method="POST">
            <input type="hidden" name="login" value="SI" />
            <p>Usuario : <input type="text" name="usuario" value="" size="15" /></p>
            <p>Clave <input type="password" name="clave" value="" size="15" /></p>
            <p><input type="submit" value="Enviar" name="btnEnviar" /></p>
        </form>
    </body>
</html>
