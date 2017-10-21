<%-- 
    Document   : coleccion.jsp
    Created on : Jan 23, 2013, 2:50:47 PM
    Author     : student
--%>

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

        <%
            modelo.ColeccionDVDs col = ((modelo.ColeccionDVDs)(session.getAttribute("atlista")));
            for (modelo.DVD elem : col.getLista() ){
                out.println(elem.getDirector() + " - " +  elem.getTitulo()+ "<BR>");
            }
               
            %>
      
    <BR>
           <a href='DVDServlet?accion=nuevo' >Agregar nuevo DVD </a><BR>
    </body>
</html>
