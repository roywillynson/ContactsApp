/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import logica.Contacto;

/**
 *
 * @author Latitude 5580
 */
public class CSV<T>{
    
    private BufferedReader lectura    = null;
    private BufferedWriter escritura  = null;
    private File file                 = null;
    private final String separador    = ",";
    
    public List<Contacto> CSVToContacto(String input) {
        //Lista de Contactos
        List<Contacto> lista = new ArrayList<>();
        
        //Archivo
        file = new File(input);

        
        if( !(file.exists()) ){
            
            System.out.println("Archivo de entrada no existe");

        }
        else
        {
            
            try{
                
                lectura = new BufferedReader(new FileReader(file));

                String l;
                
                while((l = lectura.readLine() ) != null){
                       
                    String[] registro = l.split(separador);
                    
                    Contacto contacto = new Contacto();
                    
                    if(registro.length == 8){
                        
                        for(int i = 0; i < registro.length; i++){
                            contacto.setFoto    ( cleanString( registro[0]).getBytes() );
                            contacto.setNombre  ( cleanString( registro[1]) );
                            contacto.setApellido( cleanString( registro[2]) );
                            contacto.setCompany ( cleanString( registro[3]) );
                            contacto.setPosicion( cleanString( registro[4]) );
                            contacto.setEmail   ( cleanString( registro[5]) );
                            contacto.setTelefono( cleanString( registro[6]) );
                            contacto.setNotas   ( cleanString( registro[7]) );
                        }
 
                    }

                    lista.add(contacto);
                    
                }

            }
            catch(IOException e){
                
                System.out.println(e);
                
            }
            finally
            {
                try{
                    if(lectura != null) 
                        lectura.close();
                }
                catch(IOException e){
                    System.out.println(e);
                }
  
            }
        }
        
        return lista;
    }
    
    public void ObjectToCSV(){
        
    }
    
    public String cleanString( String n ){
        return n.replace("\"", "");
    }
    
}
