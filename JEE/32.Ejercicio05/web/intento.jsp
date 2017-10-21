<%-- 
    Document   : intento
    Created on : 22-oct-2015, 20:00:39
    Author     : curso
--%>

<%@page import="com.acme.Mastermind"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Intenta adivinar el número secreto.</title>
    </head>
    <body style="text-align: center">
        <h1>Mastermind - Introduce una cifra de tres dígitos para adivinar el número secreto</h1>
        <form name="formulario" action="intento.jsp" method="POST">
            <p><input type="text" name="txtMiNumero" value="" /></p>
            <input type="submit" value="Enviar" name="btnEnviar" />
        </form>
        <%
            Mastermind mm = (Mastermind) session.getAttribute("mastermind");
            String miNumero = request.getParameter("txtMiNumero");

            if (miNumero != null) {
                mm.adivinar(miNumero);
        %>
        <p>
            <%
                for (String m : mm.getIntentos()) {%>
            <%=m%><br>
            <%
                }
            %>
        </p>
        <%
            }
        %>
    </body>
</html>
