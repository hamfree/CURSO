<%-- 
    Document   : tomadatos
    Created on : 30-abr-2012, 12:26:22
    Author     : jesus
--%>

<%@page import="modelo.Articulo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
               <h1>Compra Finalizada</h1>
        Cesta:<BR></br>
        <c:forEach   items="${cesta.listaArticulos}"  var="elem">
            ${elem} <BR></br>
        </c:forEach>
            ${cesta.precioTotal}
      
          
        <FORM ACTION="confirmar" METHOD="POST">
           su nombre: <INPUT  type="text" name="nombre"><P/>
           direccion de envio: <INPUT  type="text" name="direccion"><BR>
            <BR><BR>
            <INPUT TYPE='submit' VALUE='Enviar Datos'> <BR>
        </FORM>
    </body>
</html>
