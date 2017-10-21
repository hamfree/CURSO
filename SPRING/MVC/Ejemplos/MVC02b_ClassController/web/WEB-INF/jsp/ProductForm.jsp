<!DOCTYPE HTML>
<html>
    <head>
        <title>Add Product Form</title>
        <style type="text/css">@import url(css/main.css);</style>
    </head>
    <body>

        <div id="global">
            <form action="product_save.action" method="post">
                <fieldset>
                    <legend>A�adir un producto</legend>
                    <p>
                        <label for="name">Nombre: </label>
                        <input type="text" id="name" name="name"
                               tabindex="1">
                    </p>
                    <p>
                        <label for="description">Descripci&oacute;n: </label>
                        <input type="text" id="description"
                               name="description" tabindex="2">
                    </p>
                    <p>
                        <label for="price">Precio: </label>
                        <input type="text" id="price" name="price"
                               tabindex="3">
                    </p>
                    <p id="buttons">
                        <input id="reset" type="reset" tabindex="4"
                               value="limpiar">
                        <input id="submit" type="submit" tabindex="5"
                               value="A�adir producto">
                    </p>
                </fieldset>
            </form>
        </div>
    </body>
</html>
