<%-- 
    Document   : listado
    Created on : 12-nov-2015, 18:22:42
    Author     : curso
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personas con el nombre ${nombre} en la base de datos</title>
    </head>
    <body style="text-align: center;font-family: monospace">
        <h1>Personas con el nombre ${nombre} en la base de datos</h1>
        <ul>
            <c:forEach var="p" items="${listaPersonas}" >
                <li>${p.dni} , ${p.nombre} , ${p.apellido}</li>
            </c:forEach>
        </ul>
        <a href="index.jsp">Volver al inicio</a>
    </body>
</html>
