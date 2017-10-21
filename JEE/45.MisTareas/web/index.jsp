<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mis tareas</title>
    </head>
   <body style="text-align: center">
        <h1>Mis Tareas</h1>
        <p>Vaya añadiendo las tareas rellenando el campo con la etiqueta "Tarea :" y pulse el botón "Añadir". Después, para ver 
        la lista de tareas introducidas, pulse el enlace "Finalizar"</p>
        <form name="frmEnvioTarea" action="enviar" method="POST">
            <input type="hidden" name="accion" value="agregar" />
            <p>Tarea : <input type="text" name="tarea" value="" size="45" /></p>
            <p><input type="submit" value="Añadir" name="btnAñadir" /></p>
        </form>
        <p><a href="enviar?accion=finalizar">Finalizar</a></p>
        <p style="color: red">${requestScope.mensaje}</p>
    </body>
</html>
