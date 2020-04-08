
package datos;

import java.sql.*;
import java.util.*;
import logica.Contacto;

public class ContactosJDBC {
    
    //Atributos
    private Connection conn = null;
//  private Statement stmnt = null;
    private PreparedStatement pstmnt  = null;
    private ResultSet rs    = null;
    
    //Metodos
    /************************ Read **************************/
    public List<Contacto> getAllContacs(){
        
        ArrayList<Contacto> contactos = new ArrayList();
        
        String query = "SELECT * FROM contactos";
        
        Conexion.conectar();
        
        try{
            
            conn = Conexion.getConexion();
            
            if (conn != null) {
                
                pstmnt = conn.prepareStatement(query);
                rs = pstmnt.executeQuery();

                while (rs.next()) {
                    Blob foto = rs.getBlob(2);
                    contactos.add(new Contacto(
                            rs.getInt(1),
                            foto.getBytes(1, (int)foto.length()),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getString(9)
                    ));
                }
            }
        }
        catch(SQLException e){
            
            System.out.println(e);
            
        }
        finally{
            
            Conexion.desconectar();
            Conexion.cerrar(rs);
            Conexion.cerrar(pstmnt);
//            try{
//                
//                System.out.println("Esta cerrada la instancia: " + Conexion.getConexion().isClosed());
//                System.out.println("Esta cerrada la copia de la instancia: " + conn.isClosed());
//            }
//            catch(SQLException e){
//                
//            }
        }
        
        
        return contactos;
        
    }
    
    /*********************** Buscar *************************/
    public List<Contacto> buscar(String queryBuscar){
        ArrayList<Contacto> contactos = new ArrayList();
        
        String query = "SELECT * FROM contactos " + queryBuscar;
        
        Conexion.conectar();
        
        try{
            
            conn = Conexion.getConexion();
            
            if (conn != null) {
                
                pstmnt = conn.prepareStatement(query);
                
                rs = pstmnt.executeQuery();
                
                while (rs.next()) {
                    Blob foto = rs.getBlob(2);
                    contactos.add(new Contacto(
                            rs.getInt(1),
                            foto.getBytes(1, (int)foto.length()),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getString(9)
                    ));
                }
            }
        }
        catch(SQLException e){
            
            System.out.println(e);
            
        }
        finally{
            
            Conexion.desconectar();
            Conexion.cerrar(rs);
            Conexion.cerrar(pstmnt);
//            try{
//                
//                System.out.println("Esta cerrada la instancia: " + Conexion.getConexion().isClosed());
//                System.out.println("Esta cerrada la copia de la instancia: " + conn.isClosed());
//            }
//            catch(SQLException e){
//                
//            }
        }
        
        return contactos;
    }
    
    
    /*********************** Create ************************/
    public void add(Contacto contacto){
        
        String query = "INSERT INTO contactos(foto, nombre, apellido, company, posicion, email, telefono, Notas) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Conexion.conectar();
        
        try{
            
            conn = Conexion.getConexion();
            
            if (conn != null) {
                
                pstmnt = conn.prepareStatement(query);

                pstmnt.setBytes(1,  contacto.getFoto()  );
                pstmnt.setString(2, contacto.getNombre()  );
                pstmnt.setString(3, contacto.getApellido());
                pstmnt.setString(4, contacto.getCompany() );
                pstmnt.setString(5, contacto.getPosicion());
                pstmnt.setString(6, contacto.getEmail()   );
                pstmnt.setString(7, contacto.getTelefono());
                pstmnt.setString(8, contacto.getNotas()   );
                        
                pstmnt.executeUpdate();

            }
        }
        catch(SQLException e){
            
            System.out.println(e);
            
        }
        finally{
            
            Conexion.desconectar();
            Conexion.cerrar(pstmnt);

        }
    }
    
    
    
    /********************* Delete ****************************/
    public void delete(int id){

        String query = "DELETE FROM contactos WHERE id_contacto = ?";

        Conexion.conectar();

        try{

            conn = Conexion.getConexion();

            if (conn != null) {

                pstmnt = conn.prepareStatement(query);

                pstmnt.setInt(1, id);

                pstmnt.executeUpdate();

            }
        }
        catch(SQLException e){

            System.out.println(e);

        }
        finally{

            Conexion.desconectar();
            Conexion.cerrar(pstmnt);
            
        }
       
    }
    
    
    /******************** Update *********************/
    public void update(int id, Contacto contacto){

        String query = "UPDATE contactos SET "
                
                + "foto=?, "
                + "nombre=?, "
                + "apellido=?, "
                + "company=?, "
                + "posicion=?, "
                + "email=?, "
                + "telefono=?,"
                + "Notas=? "
                
                + "WHERE id_contacto=?";

        Conexion.conectar();

        try{

            conn = Conexion.getConexion();

            if (conn != null) {

                pstmnt = conn.prepareStatement(query);
          
                pstmnt.setBytes(1, contacto.getFoto()    );
                pstmnt.setString(2, contacto.getNombre()  );
                pstmnt.setString(3, contacto.getApellido());
                pstmnt.setString(4, contacto.getCompany() );
                pstmnt.setString(5, contacto.getPosicion());
                pstmnt.setString(6, contacto.getEmail()   );
                pstmnt.setString(7, contacto.getTelefono());
                pstmnt.setString(8, contacto.getNotas()   );
                pstmnt.setInt(9, id);

                pstmnt.executeUpdate();

            }
        }
        catch(SQLException e){

            System.out.println(e);

        }
        finally{

            Conexion.desconectar();
            Conexion.cerrar(pstmnt);
            
        }
       
    }
}
