<%-- 
    Document   : gracias
    Created on : 30-abr-2012, 13:07:41
    Author     : jesus
--%>

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
        ${comprador.nombre}<P></p>
            ${comprador.domicilio}

        <P></p>
        <c:forEach   items="${pedidofinal.lista}"  var="elem">
            ${elem} <BR></br>
        </c:forEach>
        ${cesta.precioTotal}

    </body>
</html>
