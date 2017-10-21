<%-- 
    Document   : tomaDeDatos
    Created on : 13-nov-2015, 17:21:44
    Author     : curso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mercado METADONA. Compra de artículos</title>
    </head>
    <body style="text-align: center;font-family: monospace">
        <h1>Mercado METADONA. Compra de artículos</h1>
        <form name="frmComprar" action="carrito" method="POST">
            <p>Código......: <input type="text" name="codigo" value="" size="10" /></p>
            <p>Nombre......: <input type="text" name="nombre" value="" size="40" /></p>
            <p>Precio......: <input type="text" name="precio" value="0.0" size="5" />&euro;</p>
            <p><input type="submit" value="Comprar" name="btnComprar" /></p>
        </form>
        <a href="carrito?accion=confirmar">Confirmar la compra</a>
    </body>
</html>
