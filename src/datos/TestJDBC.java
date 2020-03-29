/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.List;
import logica.Contacto;

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
        Contacto pedro = new Contacto();
        
        pedro.setNombre("Peter");
        pedro.setApellido("Jason");
        pedro.setCompany("Brother company");
        pedro.setPosicion("Gerente");
        pedro.setEmail("peter@gmail.com");
        pedro.setNotas("Era calvo el degraciado");
        pedro.setTelefono("809456789");
        
        //tablaContacto.add(pedro);
                
        //Actualizar registro
        tablaContacto.update(3, pedro);
        
        //Mostrar registro
        List<Contacto> contactos = tablaContacto.getAllContacs();
        
        
        for(Contacto contacto: contactos){
            
            System.out.println(
                    
                contacto.getId()       + "\t" +
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
