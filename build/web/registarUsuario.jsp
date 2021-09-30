<%-- 
    Document   : registarUsuario
    Created on : 6 sept. 2021, 14:39:42
    Author     : USER-F
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registra Usuario</title>
    </head>
    <body>
    <center>
        <h1>Registra Usuario</h1>
        <form method="post" action="Usuario">
            <table>
                <tr>
                <label>Usuario:</label>
                <input type="text" name="textUsuario"><br>
                
                <label>Contraseña:</label>
                <input type="text" name="textClave"><br>
                </tr>
            </table>
            <button type="submit">Registra</button>
            <input type="hidden" name="textOpcion" value="1">
        </form>
        <div>
            </center>
            <%
                if (request.getAttribute("mensajeError") !=null) {%>
                ${mensajeError}
                <%}else{ %>
                ${mensajeExito}
                <% } %>
        </div>
    </body>
</html>
