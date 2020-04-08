
package datos;

import java.sql.*;

public class Conexion {
    //Atributos
    private static Connection conn = null;
    private static final String PORT = "3306";
    private static final String DB_NAME = "agenda";
    private static final String JDBC_URL  = "jdbc:mysql://localhost:"+ Conexion.PORT +"/"+ Conexion.DB_NAME +"?allowPublicKeyRetrieval = true&useSSL=false";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "admin";
    
    //Constructor vacio
    public Conexion(){
        
    }
    
    //Abrir Conexion
    public static void conectar(){
            try{
            
                conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
            
            }
            catch(SQLException e){

                System.out.println(e);

            } 
    }
    
    //Instanciar conexion
    public static Connection getConexion(){
        
        return conn;
    } 
    
    
    //Cerrar conexion
    public static void desconectar(){
        if( conn != null){
            try{
                
                conn.close();
                
            }
            catch(SQLException e){
                
                System.out.println(e);
                
            }
        }
    }
    
    //Cerrar Resulset
    public static void cerrar(ResultSet rs) {
        try{
            
            if(rs != null) {
                rs.close();
            }
            
        }catch(SQLException e){
            
            System.out.println(e);
            
        }
    }
    
    //Cerrar preparedStatement
    public static void cerrar(PreparedStatement pstmnt) {
        try{
            
            if(pstmnt != null) {
                pstmnt.close();
            }
            
        }catch(SQLException e){
            
            System.out.println(e);
            
        }
    }
    
}
