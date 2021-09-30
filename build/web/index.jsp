<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Usuario</title>
    </head>
    <body>
    <center>
        <h1>Login Usuario</h1>
        <form method="post" action="Usuario">
            <table>
                <tr>
                <label>Usuario:</label>
                <input type="text" name="textUsuario"><br>
                
                <label>Contraseña:</label>
                <input type="text" name="textClave"><br>
                </tr>
            </table>
            <button type="submit">Ingresar</button>
            <input type="hidden" name="textOpcion" value="4">
            
        </form>
        </center>
       <div style="color: red;">
            <%
              if(request.getAttribute("mensajeError") != null){ %>
              ${mensajeError}
              
              <% } %> 
        </div>
    </body>
</html>
