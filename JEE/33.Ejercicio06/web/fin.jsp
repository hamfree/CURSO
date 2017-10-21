<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrando beans con JSTL y Lenguaje de Expresión EL</title>
    </head>
    <body>
        <h1>Mostrando beans con JSTL y Lenguaje de Expresión EL</h1>
        <p>
            Accediendo a la colección utilizando un bucle de JSTL...
        </p>
        <p style="font-family:monospace ;border: 1px solid green;">
            <c:if test="${not empty empleado}" >
                Nombre del empleado ....: <c:out value="${empleado.nombre}" /><br>
                <c:forEach var="tfno" items="${empleado.telefonos}" varStatus="i">
                    Contador ...............: ${i.index}<br>
                    Tipo ...................: <c:out value="${tfno.tipo}" /><br>
                    Número .................: <c:out value="${tfno.numero}" /><br><br>
                </c:forEach>
            </c:if>
        </p>
        <p>
            Otra forma, accediendo directamente a las propiedades de los distintos objetos :
        </p>
        <p style="font-family:monospace ;border: 1px solid red;">
            Telefono 0<br>
            Tipo .....: <c:out value="${empleado.telefonos[0].tipo}" /><br>
            Numero ...: <c:out value="${empleado.telefonos[0].numero}" /><br><br>
            Telefono 1<br>
            Tipo .....: <c:out value="${empleado.telefonos[1].tipo}" /><br>
            Numero ...: <c:out value="${empleado.telefonos[1].numero}" />
        </p>
        <a href="<c:out value="index.html" />">Volver al inicio</a>
    </body>
</html>
