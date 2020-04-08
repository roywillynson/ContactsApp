
package logica;

import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.Icon;

//Terceros
import datos.ContactosJDBC;
import java.awt.Color;
import java.awt.Font;


public class TablaContacto extends JTable {
    //ATRIBUTOS
    private final String[] columnas  = {"Id","Foto","Nombre", "Apellido", "Compa\u00F1ia", "Posicion","Email","Telefono", "Notas"};
    private Object[][] datos = null;
    private DefaultTableModel model = null;
    ContactosJDBC con = new ContactosJDBC();
    
    //CONSTRUCTOR
    public TablaContacto(){
        this.model = new DefaultTableModel(null, columnas){
            @Override
            public boolean isCellEditable(int row, int column) {
                return !(column >= 0 && column < 9);
            }
          
        };
        
    }
    
    //GETTERS
    public int getCantidadColumnas(){
        return columnas.length;
    }
    
    public int getContidadFilas(){
        return (datos.length > 0) ? datos.length : 0;
    }
    
    public String getNombreColumna(int i){
        return columnas[i];
    }
    
    public Object getDato(int row, int col){
        return datos[row][col];
    }
    
    //SETTERS
    public void setDato(Object[] row, int i, int columnas){
        datos = new Object[columnas][row.length];
        
        for(int j = 0; j < 9; j++){
                datos[i][j] = row[j];
        }
        
    }
    

    
    //FUNCIONALIDAD
    //Agregar Campos de las Filas
    public final void addDatosFilas(){
        
        List<Contacto> lista = con.getAllContacs();
        

        for(int i = 0; i < lista.size(); i++){
            
            Object[] regis = new Object[9]; //Registro
            //Datos
            regis[0] = lista.get(i).getId();
            //Convertir la imagen
            ImageIcon img = new ImageIcon(logica.utilidades.IMGHandler.convertByteArrayToImage(lista.get(i).getFoto()).getScaledInstance(32, 32, 0));
            regis[1] = new JLabel((Icon)img); //Asignar
            regis[2] = lista.get(i).getNombre();
            regis[3] = lista.get(i).getApellido();
            regis[4] = lista.get(i).getCompany();
            regis[5] = lista.get(i).getPosicion();
            regis[6] = lista.get(i).getEmail();
            regis[7] = lista.get(i).getTelefono();
            regis[8] = lista.get(i).getNotas();
            
            
            
            setDato(regis, i, lista.size()); //Clonar lista
            
            model.addRow(regis); //Agregar filas
        }
        
        this.setModel(model);
    }  
    
    public void buscar(String busqueda, int filtro){
        
        
        String[] filtroname = {
            "WHERE nombre LIKE '%"+ busqueda +"%'",
            "WHERE apellido LIKE '%"+ busqueda +"%'",
            "WHERE CONCAT_WS(' ', nombre, apellido) LIKE '%"+ busqueda +"%'",
            "WHERE company LIKE '%"+ busqueda +"%'"
            
        };
        
        List<Contacto> lista = con.buscar(filtroname[filtro]);
        

        for(int i = 0; i < lista.size(); i++){
            
            Object[] regis = new Object[9]; //Registro
            //Datos
            regis[0] = lista.get(i).getId();
            //Convertir la imagen
            ImageIcon img = new ImageIcon(logica.utilidades.IMGHandler.convertByteArrayToImage(lista.get(i).getFoto()).getScaledInstance(32, 32, 0));
            regis[1] = new JLabel((Icon)img); //Asignar
            regis[2] = lista.get(i).getNombre();
            regis[3] = lista.get(i).getApellido();
            regis[4] = lista.get(i).getCompany();
            regis[5] = lista.get(i).getPosicion();
            regis[6] = lista.get(i).getEmail();
            regis[7] = lista.get(i).getTelefono();
            regis[8] = lista.get(i).getNotas();
            
            
            
            setDato(regis, i, lista.size()); //Clonar lista
            
            model.addRow(regis); //Agregar filas
        }
        
        this.setModel(model);
        
    }
    
}
