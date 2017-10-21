<%@page import="modelo.Articulo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Gracias por su compra, se la enviamos a:</h1>
        <p>${comprador.nombre}</p>
        <p>${comprador.domicilio}</p>
        <p>&nbsp;</p>
        <c:forEach items="${pedidofinal.listaArticulos}" var="elem">
            ${elem} <br/><br/>
        </c:forEach>
        Precio total : ${cesta.precioTotal}
    </body>
</html>
