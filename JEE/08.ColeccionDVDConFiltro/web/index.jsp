<%-- 
    Document   : index.jsp
    Created on : 29-oct-2015, 16:37:02
    Author     : curso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%
    String login = (String) session.getAttribute("login");
    if (login == null) {
        session.setAttribute("login", "NO");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi colección de DVD. Inicio</title>
    </head>
    <body>
        <div>
            <h1>Mi colección de DVD</h1>
            <h2>Bienvenido al menu principal</h2>
            <p>Usuario conectado: '${sessionScope.usuario}'</p>
            <p>Seleccione una opción para continuar</p>
            <ol>
                <li><a href="do?accion=irAgregar">Agregar nuevo DVD</a></li>
                <li><a href="do?accion=irListar">Listar DVDs</a></li>
                <li><a href="login.jsp">Identificarse</a></li>
            </ol>
        </div>
    </body>
</html>
