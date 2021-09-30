<%-- 
    Document   : sesiones
    Created on : 27-sep-2021, 14:53:54
    Author     : USER-F
--%>

<%@page import="modeloDAO.UsuarioDAO"%>
<%@page import="modeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-control","no-cache,no-store,must-revalidate");
response.setDateHeader("Expires", 0);

%>

<%
    HttpSession buscarSesion = (HttpSession)request.getSession();
    String usuario="";
    String id="";
    if(buscarSesion.getAttribute("datosUsuario")==null){
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    else{
    UsuarioVO usuVO = (UsuarioVO)buscarSesion.getAttribute("datosUsuario");
    usuario = usuVO.getUsuLogin();
    //UsuarioDAO Modelo = new UsuarioDAO() ;
    //Modelo.retornoRol(usuVO.getUsuId());
    }
%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="float: right; color:red; font-size:20px;">
            Bienvenido: <%=usuario%>
            <form method="post" action="Sesiones">
                <input type="submit" value="Cerrar Sesion"/>
            </form>
        </div>
            <br>
    </body>
</html>
