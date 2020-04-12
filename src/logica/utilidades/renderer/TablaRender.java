/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.utilidades.renderer;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TablaRender extends DefaultTableCellRenderer {
    
    //private final Color oscuro     = new Color(63, 81, 181);
    private final Color white      = Color.WHITE;
    private final Color semioscuro = new Color(92, 107, 192);
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
 
        
        //Renderizar imagen
        if(value instanceof JLabel){
            JLabel imglabel = (JLabel)value;
            imglabel.setBackground(semioscuro);
            return imglabel;
        }
        
        
        this.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        this.setBackground(semioscuro);
        this.setForeground(white);
        
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }
    
}
