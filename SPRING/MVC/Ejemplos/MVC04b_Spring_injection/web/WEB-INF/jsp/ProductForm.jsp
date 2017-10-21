<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

    <head>
        <title>Add Product Form</title>
        <style type="text/css">
            @import url("<c:url value="/css/main.css"/>");
        </style>
    </head>
    <body>

        <div id="global">
            <c:if test="${requestScope.errors != null}">
                <p id="errors">
                    Error(es)!
                <ul>
                    <c:forEach var="error" items="${requestScope.errors}">
                        <li>${error}</li>
                        </c:forEach>
                </ul>

            </c:if>
            <form action="product_save" method="post">
                <fieldset>
                    <legend>Añadir un producto</legend>
                    <p>
                        <label for="name">Nombre: </label>
                        <input type="text" id="name" name="name" value="${form.name}"
                               tabindex="1">
                    </p>
                    <p>
                        <label for="description">Descripci&oacute;n: </label>
                        <input type="text" id="description" value="${form.description}"
                               name="description" tabindex="2">
                    </p>
                    <p>
                        <label for="price">Precio: </label>
                        <input type="text" id="price" name="price" value="${form.price}"
                               tabindex="3">
                    </p>
                    <p id="buttons">
                        <input id="reset" type="reset" tabindex="4"
                               value="limpiar">
                        <input id="submit" type="submit" tabindex="5"
                               value="Añadir producto">
                    </p>
                </fieldset>
            </form>
        </div>
    </body>
</html>
