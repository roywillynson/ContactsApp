/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.utilidades.renderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class TablaHeaderRender extends DefaultTableCellRenderer{
    
    DefaultTableCellRenderer headerender;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object o, boolean bln, boolean bln1, int i, int i1) {
        
        
        JTableHeader headers = table.getTableHeader(); //Obtener cabezera de la tabla
        
        

        //Render
        headerender = (DefaultTableCellRenderer)headers.getDefaultRenderer();
        
        //Alinear texto de encabezado
        headerender.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        
        //Color del Encabezado
        headerender.setForeground(new Color(92, 107, 192));
        
        //Tamaño
        //Modificar estilo de cabezera
        headerender.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
        
        return super.getTableCellRendererComponent(table, o, bln, bln1, i, i1); //To change body of generated methods, choose Tools | Templates.
    }
    
}
