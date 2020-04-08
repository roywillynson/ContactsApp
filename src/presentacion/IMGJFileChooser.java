/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import javax.swing.Icon;
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
            }else{
                
                JOptionPane.showMessageDialog(padre, " No ha selecccionado ningun archivo! ");
                        
            }
            
        }  
    }
    
    
    
    
}
