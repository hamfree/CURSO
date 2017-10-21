<%-- 
    Document   : index
    Created on : 12-nov-2015, 17:33:21
    Author     : curso
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
        <form action="MiServlet"  >
            dni: <input type="text" name="dni" value="${atPersona.dni}" /><BR>
            nombre <input type="text" name="nombre" value="${atPersona.nombre}" /><BR>
            apellido <input type="text" name="apellido" value="${atPersona.apellido}" /><BR>
            <input type="submit" name="accion" value="crear" />
            <input type="submit"  name="accion" value="actualizar" />
            <input type="submit"  name="accion" value="borrar" /><BR>
            
                        <input type="submit"  name="accion" value="buscarPorId" />
            <input type="submit"  name="accion" value="buscarPorNombre" />
        </form>
        <P></P>
        
       ${atResultado} <BR>
        <c:if test="${not empty atLista}" >
            <c:forEach items="${atLista}" var="elem">
                
                ${elem}<BR>
            </c:forEach>
        </c:if>
      
    </body>
</html>
