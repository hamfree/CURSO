<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Save Product</title>
        <style type="text/css">
            @import url("<c:url value="/css/main.css"/>");
        </style>
    </head>
    <body>
        <div id="global">
            <h4>${message}</h4>
            id: ${product.id}<br/>
            Nombre: ${product.name}<br/>
            Descripci&oacute;n: ${product.description}<br/>
            Precio: ${product.price}
        </div>
    </body>
</html>