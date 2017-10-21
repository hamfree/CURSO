<%-- 
    Document   : intento
    Created on : 07-feb-2014, 14:13:41
    Author     : Jesus
--%>

<%@page import="paq1.Mastermind"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
               <h1>Juego del Mastermind</h1>
 Enhorabuena!
  <P></P>
  <%
         Mastermind m = (Mastermind) session.getAttribute("atmaster");
                for (String elem : m.getIntentos()) {
                    out.println(elem + "<br>");
                }
   %>
    </body>
</html>
