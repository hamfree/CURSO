<%-- 
    Document   : newjsp
    Created on : 26-oct-2015, 20:08:35
    Author     : curso
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
        <c:out value="${empleado.nombre}" /><BR/>
        <c:forEach items="${empleado.telefonos}" var="elemento"  varStatus="i"   >
            ${i.index}
            <c:out value="${elemento.tipo}" />  &nbsp;
            <c:out value="${elemento.numero}" />   &nbsp;
            <BR/>
        </c:forEach>
        <P></P>
            <c:out value="${empleado.telefonos[0].tipo}" />
        <P></P>
        Otra forma: <P></P>

     
        
        
    </body>
</html>
