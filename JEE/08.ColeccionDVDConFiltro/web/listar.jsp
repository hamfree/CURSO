<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.acme.model.Dvd"%>
<%@page import="com.acme.model.ColeccionDVD"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi colección</title>
    </head>
    <body>
        <% ColeccionDVD alDvd = (ColeccionDVD) session.getAttribute("coleccion"); %>
        <div>   
            <h1>Mi colección</h1>
            <ol>
                <% if (alDvd.getLista().size() > 0) {
                        ArrayList<Dvd> lista = alDvd.getLista();
                        for (Dvd d : lista) {
                %>
                <li><%=d.getTitulo()%>, (<%=d.getDirector()%>)</li>
                    <% }
                    } else {%>
                <li>No existen DVDs en la colección</li>
            </ol>
            <%
                }
            %>
            <p><a href="index.jsp">Volver al Inicio</a></p>
        </div>
    </body>
</html>

