<%-- 
    Document   : index
    Created on : 28-oct-2015, 18:18:09
    Author     : curso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="horror505.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pagina de inicio</h1>
        <%=
            ((String)request.getAttribute("gggg")).toLowerCase()
        %>
    </body>
</html>
