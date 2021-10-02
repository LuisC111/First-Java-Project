package modeloDAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVO.UsuarioVO;
import ultil.Conexion;
import ultil.Crud;

public class UsuarioDAO extends Conexion implements Crud {
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    private String resultado;
    private UsuarioVO Modelo= new UsuarioVO();
    private String usuId="", usuLogin="", usuPassword="";
    
    public UsuarioDAO(){
        
    }

    public UsuarioDAO(UsuarioVO usuVO){
        super();
        try{
            conexion=this.obtenerConexion();
            usuId = usuVO.getUsuId();
            usuLogin = usuVO.getUsuLogin();
            usuPassword = usuVO.getUsuPassword();
        } catch(Exception e){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    @Override
    public boolean agregarRegistro() {
        try {
            sql="insert into usuario (usuLogin, usuPassword) values (?,?)";
            puente= conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            puente.setString(2, usuPassword);
            puente.executeUpdate();
            operacion=true;
            
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql="update usuario set usulogin=?, usupassword=? where usuid=?";
            puente= conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            puente.setString(2, usuPassword);
            puente.setString(2, usuId);
            puente.executeUpdate();
            operacion=true;
            
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {
        try {
            sql="delete from usuario where usuid=?";
            puente= conexion.prepareStatement(sql);
            puente.setString(1, usuId);
            puente.executeUpdate();
            operacion=true;
            
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return operacion;
    }
    public String[] iniciarSesion(String usuario, String clave){
        try {
            conexion= this.obtenerConexion();
            sql="select usuario.USUID,rol.ROLTIPO from usuario inner join usuario_rol on usuario.USUID = usuario_rol.USUID inner join rol on usuario_rol.ROLID= rol.ROLID where usulogin=? and usupassword=?";
            puente= conexion.prepareStatement(sql);
            puente.setString(1, usuario);
            puente.setString(2, clave);
            mensajero = puente.executeQuery();
            
            if(mensajero.next()){
                String usuId=mensajero.getString("USUID");    
                String Rol=mensajero.getString("ROLTIPO");
                Modelo.setUsuId(usuId);
                operacion=true;
                return new String[]{"true",usuId,Rol};
            }
            
        } catch (SQLException e) {
        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            try {
                this.cerrarConexion();
                
                 
            } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return new String[]{};
    
    }
   public String retornoRol(String Id){
        try {
            
            conexion= this.obtenerConexion();
            sql="select rol.ROLTIPO from usuario inner join usuario_rol on usuario.USUID = usuario_rol.USUID inner join rol on usuario_rol.ROLID= rol.ROLID where usuario.USUID=?";
            System.out.println(sql);
            puente= conexion.prepareStatement(sql);
            System.out.println("entro");
            puente.setString(1, Id);
            
            mensajero = puente.executeQuery();
            
            if(mensajero.next()){
                resultado=mensajero.getString("ROLTIPO");    
                
                System.out.println(resultado);
                
            }
            
        } catch (SQLException e) {
        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return resultado;
    }
}
