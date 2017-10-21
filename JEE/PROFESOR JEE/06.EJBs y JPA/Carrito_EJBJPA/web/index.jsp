<%-- 
    Document   : index
    Created on : 30-abr-2012, 11:21:36
    Author     : jesus
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Articulo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Compra de Articulos</h1>
        <FORM ACTION="comprar" METHOD="POST">
            Codigo del articulo: <INPUT  type="text" name="codigo"><P/>
           nombre del articulo: <INPUT  type="text" name="nombre"><P/>
           precio: <INPUT  type="text" name="precio"><BR>
            <BR><BR>
            <INPUT TYPE='submit' VALUE='Enviar Datos'> <BR>
        </FORM>
        <P></p>
        <A href="finalizar">Finalizar compra</A>
        <p></p>
        Cesta:<BR></br>
        <c:forEach   items="${cesta.lista}"  var="elem">
            ${elem} <BR></br>
        </c:forEach>
       
    </body>
</html>
