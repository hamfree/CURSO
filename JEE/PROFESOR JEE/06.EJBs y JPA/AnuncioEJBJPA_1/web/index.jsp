<%-- 
    Document   : index
    Created on : 11-feb-2014, 20:05:00
    Author     : Usuario
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <H1> Bienvenido a la pagina, registrate</H1>
        <form action="hola" >
            usuario: <input type="text" name="user"  /><BR>
            password: <input type="text" name="pass" /><BR>
            <input type="submit" value="Enviar" />
        </form>
        <P></P>
        <c:out value="${mensaje}" />
    </body>
</html>
