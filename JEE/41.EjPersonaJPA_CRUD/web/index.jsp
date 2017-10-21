<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Gestionar Persona con JPA. Operaciones CRUD</title>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body style="text-align:center;font-family: monospace">
        <h1>Gestionar Persona con JPA. Operaciones CRUD</h1>
        <form action="gestPersona" method="POST" accept-charset="UTF-8">
            <p>DNI....... :<input type="text" name="dni" value="${dni}" /></p>
            <p>Nombre.... :<input type="text" name="nombre" value="${nombre}" /></p>
            <p>Apellido.. : <input type="text" name="apellido" value="${apellido}" /></p>
            <p>
                <input name="accion" type="submit" value="AGREGAR" /> 
                 | <input name="accion" type="submit" value="BUSCAR POR ID" />
                 | <input name="accion" type="submit" value="BUSCAR POR NOMBRE" />
                 | <input name="accion" type="submit" value="BORRAR" />
                 | <input name="accion" type="submit" value="MODIFICAR" />
            </p>
            <hr>
            <p>${respuesta}</p>
        </form>
    </body>
</html>
