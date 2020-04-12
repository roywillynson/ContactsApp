
package datos;


import java.util.List;
import logica.Contacto;
import logica.utilidades.CSV;
import org.apache.commons.csv.CSVFormat;

/**
 *
 * @author Latitude 5580
 */
public class TestJDBC {
    
    public static void main(String[] args) {
        
        ContactosJDBC tablaContacto = new ContactosJDBC();
        
        //Borrar registro
        //tablaContacto.delete(4);
        
        //Agregar registro
       /* Contacto pedro = new Contacto();
        pedro.setNombre("Peter");
        pedro.setApellido("Jason");
        pedro.setCompany("Brother company");
        pedro.setPosicion("Gerente");
        pedro.setEmail("peter@gmail.com");
        pedro.setNotas("Era calvo el degraciado");
        pedro.setTelefono("809456789");
        */
        //tablaContacto.add(pedro);
                
        //Actualizar registro
        //tablaContacto.update(3, pedro);
        
        
        
        
        
        //CSV archivo = new CSV();
        //CSV.formato = CSVFormat.EXCEL.withQuote(null).withDelimiter(';');
        //archivo.ContactoToCSV(tablaContacto.getAllContacs(), "C:\\Users\\Latitude 5580\\Desktop\\Prueba.txt");
     
        /*
        for(Contacto contacto: contactosarc){
            
            System.out.println(
                contacto.getNombre()   + "\t" +
                contacto.getApellido() + "\t" +
                contacto.getCompany()  + "\t" +
                contacto.getEmail()    + "\t" +
                contacto.getPosicion() + "\t" +
                contacto.getTelefono()
            );
        }
        
        tablaContacto.add(contactosarc.get(1));
        */
        
        
        //Mostrar registro
        //List<Contacto> contactos = archivo.CSVToContacto("C:\\Users\\Latitude 5580\\Desktop\\Prueba.txt");
        
        
        for(Contacto contacto: tablaContacto.getAllContacs()){
            
            System.out.println(
                contacto.getId() + "\t" +
                contacto.getNombre()   + "\t" +
                contacto.getApellido() + "\t" +
                contacto.getCompany()  + "\t" +
                contacto.getEmail()    + "\t" +
                contacto.getPosicion() + "\t" +
                contacto.getTelefono()
            );
        }
        
    }
    
}
