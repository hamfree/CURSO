<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Book List</title>
        <style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
    </head>
    <body>

        <div id="global">
            <h1>Lista de libros</h1>
            <a href="<c:url value="/book_input"/>">A&ntilde;adir libro</a>
            <table>
                <tr>
                    <th>Categor&iacute;a</th>
                    <th>T&iacute;tulo</th>
                    <th>ISBN</th>
                    <th>Autor</th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach items="${books}" var="book">
                    <tr>
                        <td>${book.category.name}</td>
                        <td>${book.title}</td>
                        <td>${book.isbn}</td>
                        <td>${book.author}</td>
                        <td><a href="book_edit/${book.id}">Editar</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
