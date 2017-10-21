<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mercado METADONA. Confirme su compra e introduzca sus datos de envío</title>
    </head>
    <body  style="text-align: center;font-family: monospace">
        <h1>Mercado METADONA. Confirme su compra e introduzca sus datos de envío</h1>
        <c:if test="${sessionScope.carrito.lista.size() > 0}">
            <h2><b>Este es el listado de articulos de su carrito de la compra</b></h2>
            <table border="1"  style="margin: 0 auto;border-color: blue">
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
        <p>Precio total : 
            <span style="font-weight: bold;color: green">${sessionScope.carrito.valor} &euro;</span>
        </p>
        <p>Indique a continuación su nombre y su dirección para poder enviarle sus productos.</p>
        <form name="frmConfirmar" action="carrito" method="POST">
            <input type="hidden" name="accion" value="finalizar" />
            <p>
                Nombre :<input type="text" name="nombre" value="" size="25" />
            </p>
            <p>
                Direccion : <textarea name="direccion" cols="40" rows="3"></textarea>
            </p>
            <p><input type="submit" value="Confirmar" name="btnConfirmar" /></p>
        </form>
    </body>
</html>
