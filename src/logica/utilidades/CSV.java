package logica.utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVPrinter;

//Terceros
import logica.Contacto;


public class CSV{
    
    public static CSVFormat formato  = CSVFormat.DEFAULT.withQuote(null);
    private BufferedReader lectura   = null;
    private BufferedWriter escritura = null;
 
 
    //Convertir Archivo CSV a Contacto
    public List<Contacto> CSVToContacto(String input) {
        //Lista de Contactos
        List<Contacto> contactos = new ArrayList<>();
 
        try{
            //Crear archivo a leer
            File file = new File(input);
            
            //Archivo
            lectura = new BufferedReader(new FileReader(file));
            
            //Convertir archivo
            CSVParser fileParser = new CSVParser(lectura, formato);
            
            //Mostrar registro
            for (CSVRecord registro : fileParser.getRecords()) {
                
                //Verificando que CSV sea valido
                if(registro.size() == 8) {
                    
                    Contacto contacto = new Contacto();
                    contacto.setFoto( cleanString( registro.get(0)).getBytes());
                    contacto.setNombre  ( cleanString( registro.get(1) ) );
                    contacto.setApellido( cleanString( registro.get(2) ) );
                    contacto.setCompany ( cleanString( registro.get(3) ) );
                    contacto.setPosicion( cleanString( registro.get(4) ) );
                    contacto.setEmail   ( cleanString( registro.get(5) ) );
                    contacto.setTelefono( cleanString( registro.get(6) ) );
                    contacto.setNotas   ( cleanString( registro.get(7) ) );
                    contactos.add(contacto);  
                    
                }else{
                    System.out.println("CSV no es valido");
                }
  
            }
            
        }catch(IOException e){    
            System.out.println(e);
        }
        finally{
            try{
                if(lectura != null) 
                    lectura.close();
                
            }catch(IOException e){
                System.out.println(e); 
            } 
        }
        
        return contactos;
    }
    
    //Convertir Objecto a archivo CSV
    public void ContactoToCSV(List<Contacto> lista, String output){
        
        try{
            //Creando archivo
            File file = new File(output);
            //Escritura del archivo
            escritura = new BufferedWriter(new FileWriter(file));
            
            //Establecer formatos y nombre columnas
            CSVPrinter escritor  = new CSVPrinter(escritura, formato);
            
            //Imprimir registro en archivo
            for(Contacto contacto : lista){
                escritor.printRecord(contacto.getId(),contacto.getNombre(), contacto.getApellido(), contacto.getCompany(), contacto.getPosicion(), contacto.getEmail(), contacto.getTelefono(), contacto.getNotas());
            }
            
            //Liberar Memoria
            escritor.close(true);
            
        }catch(IOException e){
            
            System.out.println(e); 
            
        }
    }
    
    //Limpiar String
    public String cleanString( String n ){
        
        return n.replace("\"", "");
        
    }
    
}
