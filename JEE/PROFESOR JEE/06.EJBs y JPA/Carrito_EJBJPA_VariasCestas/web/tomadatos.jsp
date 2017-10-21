<%@page import="modelo.Articulo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Toma de datos</title>
    </head>
    <body>
        <h1>Compra Finalizada</h1>
        Cesta:<br/><br/>
        <c:forEach   items="${cesta.listaArticulos}"  var="elem">
            ${elem} <br/><br/>
        </c:forEach>
        ${cesta.precioTotal}
        <form action="confirmar" method="post">
            Su nombre: <input  type="text" name="nombre"><br/>
            Direccion de envio: <input type="text" name="direccion"><br/>
            <br/>
            <input type='submit' value='Enviar Datos'> <br/>
        </form>
    </body>
</html>
