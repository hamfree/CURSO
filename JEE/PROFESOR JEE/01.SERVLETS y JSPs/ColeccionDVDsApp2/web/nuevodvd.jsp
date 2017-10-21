<%-- 
    Document   : nuevodvd
    Created on : Jan 24, 2013, 8:46:25 AM
    Author     : student
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Agregar un  DVD nuevo</h1>
        <form action='<c:url value="DVDServlet" />'  method="post" >
            <input type="hidden" name="accion" value="insertar" />
            Titulo: <input type="text" name="titulo" value="" /> <BR>
            Director: <input type="text" name="director" value="" /><BR>
            <input type="submit" value="Enviar" />
        </form>
        
        <BR>
             <a href='<c:url value="DVDServlet?accion=listar" />'   >Listar DVDs </a>
    </body>
</html>
