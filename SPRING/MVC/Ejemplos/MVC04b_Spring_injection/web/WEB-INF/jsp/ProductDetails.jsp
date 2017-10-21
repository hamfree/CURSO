<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>View Product</title>
        <style type="text/css">
            @import url("<c:url value="/css/main.css"/>");
        </style>
    </head>
    <body>
        <div id="global">
            <h4>${message}</h4>
            <p>
            <h5>Detalles:</h5>
            Número de producto: ${product.id}<br/>
            Nombre del producto: ${product.name}<br/>
            Descripción: ${product.description}<br/>
            Precio ${product.price}
        </p>
    </div>
</body>
</html>