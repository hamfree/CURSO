<%-- 
    Document   : index
    Created on : Jan 24, 2013, 8:34:06 AM
    Author     : student
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido</h1>
      
        <a href='<c:url value="DVDServlet?accion=nuevo" />'  >Agregar nuevo DVD </a><BR>
        <a href='<c:url value="DVDServlet?accion=listar" />'  >Listar DVDs </a><BR>
      <a href='<c:url value="login.jsp" />'  >Identificarse </a><BR>
    </body>
</html>
