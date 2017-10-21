<%-- 
    Document   : index
    Created on : 13-nov-2015, 17:13:21
    Author     : curso
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mercado METADONA. Haga su compra</title>
    </head>
    <body style="text-align: center;font-family: monospace">
        <h1>Mercado METADONA. Haga su compra</h1>
        <p>
            Vaya comprando artículos introduciendo sus datos. Para comprarlos pulse "Comprar". 
        </p>
        <p>
            Una vez termine de comprar sus artículos pulse el enlace "Confirmar la compra". Si quiere desechar el carrito
            de la compra actual pulse sobre el enlace "Limpiar el carrito".
        </p>
        <hr>
        <c:if test="${sessionScope.carrito.lista.size() > 0}">
            <p><b>Su carrito actual de la compra</b></p>
            <table border="1"  style="margin: 0 auto;">
                <thead>
                    <tr>
                        <th>Codigo</th><th>Nombre</th><th>Precio (&euro;)</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="art" items="${sessionScope.carrito.lista}" >
                        <tr>
                            <td>
                                ${art.codigo}
                            </td>
                            <td>
                                ${art.nombre}
                            </td>
                            <td>
                                ${art.precio}
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <hr>
        <p style="color:red">${requestScope.mensaje}</p>
        <hr>
        <p>
            <a href="tomaDeDatos.jsp">[Continuar con la compra]</a>
        </p>
        <p>
            <a href="confirmar.jsp">[Confirmar la compra]</a>
        </p>
        <p>
            <a href="carrito?accion=limpiar">[Limpiar el carrito]</a>
        </p>
    </body>
</html>
