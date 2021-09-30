package ultil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String driver,user,password,nombreBd,urlBd;
    private Connection conexion;
    
    public Conexion(){
        driver="com.mysql.jdbc.Driver";
        user="root";
        password="";
        nombreBd="EjercicioCarros";
        urlBd="jdbc:mysql://localhost:3306/"+nombreBd;
        
        try{
        Class.forName(driver).newInstance();
        conexion = DriverManager.getConnection(urlBd,user,password);
                System.out.println("Conexion OK");
        }catch (Exception e){
            System.out.println("Error al conectarse "+e.toString());
        }
        
        }
    public Connection obtenerConexion(){
        return conexion;
    }
    public Connection cerrarConexion() throws SQLException{
        conexion.close();
        conexion = null;
        return conexion;
        
    }
    public static void main(String[] args) {
        new Conexion();
    }
    
}