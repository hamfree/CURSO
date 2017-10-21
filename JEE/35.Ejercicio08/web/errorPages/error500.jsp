<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error 500</title>
    </head>
    <body>
        <h1 style="text-align: center">Error 500</h1>
        <div style="text-align: center;font-size: x-large;color: red">
            Error 500:<br> 
            <%=exception%><br>
            URL donde se provoco el error: <br> 
            ${pageContext.errorData.requestURI}
        </div>
    </body>
</html>
