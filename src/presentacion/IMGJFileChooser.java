
package presentacion;

import java.awt.Component;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

//Terceros
import logica.utilidades.IMGHandler;

public class IMGJFileChooser extends JFileChooser {

    public IMGJFileChooser(JLabel label, Component padre) {
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagenes (*.jpg,*.png)", "jpg","png");
        
        this.setFileFilter(filtro);
                
        int res;
        res = this.showOpenDialog(padre);

        if (res == JFileChooser.APPROVE_OPTION) 
        {   
            File file = this.getSelectedFile();
            
            if(file.exists()){

                IMGHandler.ScaleImageInComponent(file, label);
                /*
                ImageIcon image = new ImageIcon(file.getPath());
                label.setIcon((Icon)image);
                */
                JOptionPane.showMessageDialog(padre, "Imagen ha sido cargada exitosamente!","Mensaje",JOptionPane.INFORMATION_MESSAGE);
            }else{
                
                JOptionPane.showMessageDialog(padre, "No se pudo mostrar la imagen","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                        
            }
            
        }  
    }
    
    
    
    
}
