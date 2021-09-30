/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modeloDAO.UsuarioDAO;
import modeloVO.UsuarioVO;

/**
 *
 * @author USER-F
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/Usuario"})
public class UsuarioControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      //Recibir datos de las vistas
      int opcion = Integer.parseInt(request.getParameter("textOpcion"));
      String usuId = request.getParameter("textId");
      String usuLogin = request.getParameter("textUsuario");    
      String usuPassword = request.getParameter("textClave");
      // Mandar datos a VO
      UsuarioVO usuVO = new UsuarioVO(usuId, usuLogin, usuPassword);
      // DAO
      UsuarioDAO usuDAO = new UsuarioDAO(usuVO);
      // Administrar Operaciones
      switch(opcion){
          case 1:
              if(usuLogin.length()==0 || usuPassword.length()==0){
                request.setAttribute("mensajeError", "Falta algun campo por llenar "); 
                request.getRequestDispatcher("registarUsuario.jsp").forward(request, response);
                }
              else{
              if (usuDAO.agregarRegistro()){
                  
                request.setAttribute("mensajeExito", "El Usuario se registro correctamente!! ");            
              }
              else{
                request.setAttribute("mensajeError", "El Usuario se registro correctamente!! ");                  
              }
              request.getRequestDispatcher("registarUsuario.jsp").forward(request, response);
              }
              break;
          case 2:
              if (usuDAO.actualizarRegistro()){
              }
              break;
           case 3:
              if (usuDAO.eliminarRegistro()){
              }
              break;
            case 4:
                System.out.println(usuLogin);
                if(usuLogin.length()==0 || usuPassword.length()==0){
                request.setAttribute("mensajeError", "Falta algun campo por llenar "); 
                request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                else{
           String[] resultado = usuDAO.iniciarSesion(usuLogin, usuPassword);
              if (resultado!=null){
                  HttpSession miSesion = request.getSession(true);
                  usuId=resultado[1];
                  usuVO = new UsuarioVO(usuId, usuLogin, usuPassword);
                  miSesion.setAttribute("datosUsuario", usuVO);
                  if("Administrador".equals(resultado[2])){
                  request.getRequestDispatcher("menu.jsp").forward(request, response);
                  }
                  else if (resultado[2]=="Comprador"){
                  request.getRequestDispatcher("menuComprador.jsp").forward(request, response);

                  }
                  else if (resultado[3]=="Vendedor"){
                  request.getRequestDispatcher("menuVendedor.jsp").forward(request, response);

                  }
                  
              }
              else{
                request.setAttribute("mensajeError", "El Usuario o la contraseña incorrecta "); 
                request.getRequestDispatcher("index.jsp").forward(request, response);
              }
              }
              break;
      }   
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
