<%-- 
    Document   : fin
    Created on : 09-nov-2015, 19:31:42
    Author     : curso
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tu lista de tareas</title>
    </head>
    <body style="text-align: center">
        <h1>Listado de tus tareas</h1>
        <!-- Aquí mostraremos el arraylist con las tareas del usuario -->
        <div style="text-align: center">
            <table border="1" style="margin: 0 auto;text-align: left;">
                <thead>
                <th>
                    Tareas
                </th>
                </thead>
                <c:forEach var="tarea" items="${requestScope.tareas}">
                    <tr>
                        <td>
                            ${tarea}
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <p><a href="index.jsp">Volver al inicio</a></p>
    </body>
</html>
