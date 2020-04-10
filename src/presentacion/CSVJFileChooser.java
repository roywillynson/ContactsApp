/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import datos.ContactosJDBC;
import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

//Terceros
import logica.utilidades.CSV;
import logica.Contacto;

public class CSVJFileChooser extends JFileChooser {
    
    private final CSV csv = new CSV();
    
    private final ContactosJDBC jdbc = new ContactosJDBC();
    
    public CSVJFileChooser(Component padre) {
        
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Documentos de texto (*.csv,*.txt)", "csv","txt");
        
        this.setFileFilter(filtro);
                
        int res;
        res = this.showOpenDialog(padre);

        if (res == JFileChooser.APPROVE_OPTION) 
        {   
            File file = this.getSelectedFile();
            
            if(file.exists()){
                
                for(Contacto contacto: csv.CSVToContacto(file.getAbsolutePath())){
                    jdbc.add(contacto);
                }
                
            }else{
                
                JOptionPane.showMessageDialog(padre, " No ha selecccionado ningun archivo! ");
                        
            }
            
        }  
    }
}
