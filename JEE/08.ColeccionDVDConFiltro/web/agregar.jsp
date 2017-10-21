<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar un DVD nuevo</title>
    </head>
    <body>
        <div>
            <h1>Agregar un DVD nuevo</h1>
            <form name="frmAgregarDVD" action="do?accion=agregar" method="POST">
                
                <!-- 
                También se puede utilizar un campo oculto de nombre 'accion' y que tenga como valor 
                la acción que se necesite realizar, en este caso sería 'agregar'. El código sería así:
                
                <input type="hidden" name="accion" value"agregar" />
                
                -->
                
                <p>Titulo .........:<input type="text" name="titulo" value="" /></p>
                <p>Director .......:<input type="text" name="director" value="" /></p>
                <p><input type="submit" value="Enviar" name="cmdEnviar" /></p>
                <p><a href="index.jsp">Volver al Inicio</a></p>
            </form>
        </div>
    </body>
</html>
