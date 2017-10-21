<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Articulo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito de la compra</title>
    </head>
    <body>
        <h1>Compra de Articulos</h1>
        <form action="comprar" method="post">
           Codigo del articulo: <input  type="text" name="codigo"><br/>
           Nombre del articulo: <input  type="text" name="nombre"><br/>
           Precio: <input  type="text" name="precio"><br/>
            <br/><br/>
            <input type='submit' value='Enviar Datos'><br/>
        </form>
        <p>&nbsp;</p>
        <a href="finalizar">Finalizar compra</A>
        <p>&nbsp;</p>
        Cesta: <br/><br/>
        <c:forEach  items="${cesta.listaArticulos}"  var="elem">
            ${elem} <br/><br/>
        </c:forEach>
    </body>
</html>
