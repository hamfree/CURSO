<%-- 
    Document   : intento
    Created on : 07-feb-2014, 14:13:41
    Author     : Jesus
--%>

<%@page import="paq1.Mastermind"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
               <h1>Juego del Mastermind</h1>
               <P></P>
   Adivine el numero  secreto
  <P></P>
    <form method="POST" action="seguir">
   
   Numero Candidato: <input type="text" name="candidato" size="5"></p>
   <input type="submit" value="Enviar" ></p>
    </form>
   <P></P>
   <%
         Mastermind m = (Mastermind) session.getAttribute("atmaster");
                for (String elem : m.getIntentos()) {
                    out.println(elem + "<br>");
                }
   %>
    </body>
</html>
