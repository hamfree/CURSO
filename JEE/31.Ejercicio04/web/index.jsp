<%-- 
    Document   : index
    Created on : 22-oct-2015, 16:41:28
    Author     : curso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina JSP que envía cookies al servidor</title>
        <script type="text/javascript">
            /* Tratamiento de cookies en javascript */
            function setCookie(cname, cvalue, exdays) {
                var d = new Date();
                d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
                var expires = "expires=" + d.toUTCString();
                document.cookie = cname + "=" + cvalue + "; " + expires;
            }

            function getCookie(cname) {
                var name = cname + "=";
                var ca = document.cookie.split(';');
                for (var i = 0; i < ca.length; i++) {
                    var c = ca[i];
                    while (c.charAt(0) === ' ')
                        c = c.substring(1);
                    if (c.indexOf(name) === 0)
                        return c.substring(name.length, c.length);
                }
                return "";
            }
        </script>
    </head>
    <body style="text-align:center">
        <h1>Pagina JSP que llama al servlet generador de cookies....</h1>
        <a href="gestionaCookies">Llama al servlet</a>
    </body>
</html>
