<%-- 
    Document   : horror505
    Created on : 28-oct-2015, 17:57:35
    Author     : curso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ha habido un error interno</h1>
        <%-- Para que esto vaya es necesario que la pagina sea isErrorPage --%>
        <%= exception %></P>
         ${pageContext.exception.message}</P>
        ${pageContext.errorData.requestURI}
        
    </body>
</html>
