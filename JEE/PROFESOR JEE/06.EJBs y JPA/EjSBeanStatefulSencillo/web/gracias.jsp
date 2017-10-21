<%-- 
    Document   : gracias
    Created on : 30-abr-2012, 13:07:41
    Author     : jesus
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
        <h1>Ok, Al tajo!!! </h1>
        <c:forEach items="${atlista}" var="elem" >
            ${elem} <BR/>
            
        </c:forEach>

    </body>
</html>
