
package presentacion;

import datos.ContactosJDBC;
import java.awt.Component;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

//Terceros
import logica.utilidades.CSV;
import logica.Contacto;

public final class CSVJFileChooser extends JFileChooser {
    
    private final CSV csv = new CSV();
    
    private final ContactosJDBC jdbc = new ContactosJDBC();
    
    public CSVJFileChooser(Component padre, boolean isImport) {
        

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Documentos de texto (*.csv,*.txt)", "csv","txt");
        this.setFileFilter(filtro);
        
        int res;
        if(isImport){

            res = this.showOpenDialog(padre);
        }
        else{
            res = this.showSaveDialog(padre);
        }
        

        if (res == JFileChooser.APPROVE_OPTION) 
        {   
            File file = this.getSelectedFile();
            
            if(isImport){
                if(file.exists()){
                    importar(file.getAbsolutePath());
                    JOptionPane.showMessageDialog(padre, "Archivo CSV fue agregado correctamente","Mensaje",JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("../recursos/csv_normal.png")));
                }

            }else{
                
                exportar(file.getAbsolutePath());
                System.out.print(this.getCurrentDirectory() +"\\"+ file.getName());
                JOptionPane.showMessageDialog(padre, "Archivo CSV fue exportado correctamente","Mensaje",JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("../recursos/csv_normal.png")));
                
            }
        
            
        }  
    }
    
    
    public void importar(String input){
        for(Contacto contacto: csv.CSVToContacto(input)){
            jdbc.add(contacto);
        }
                
    }
    
    public void exportar(String output){
        csv.ContactoToCSV(jdbc.getAllContacs(), output);
    }
}
