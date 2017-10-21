<%-- 
    Document   : coleccion.jsp
    Created on : Jan 23, 2013, 2:50:47 PM
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
        <h1>Mi coleccion</h1>

        <P></P>
            <c:if test="${not empty atlista.lista}" >

            <c:forEach items="${atlista.lista}" var="elem" > 
                <c:out value="${elem.director}" /> - 
                <c:out value="${elem.titulo}" />
                <BR>
            </c:forEach>
        </c:if> 
        <BR>

        <a href='<c:url value="DVDServlet?accion=nuevo" />' >Agregar nuevo DVD </a><BR>
      o bien:<BR/>
        <c:url value="DVDServlet?accion=nuevo"  var="linkagregar" />
        <a href='${linkagregar}' >Agregar nuevo DVD </a><BR>

        
    </body>
</html>
