package logica.utilidades;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class IMGHandler{
    

    //Atributos
    private static InputStream is   = null;
    private static BufferedImage bi = null;
    /******************************************************************
     *          Metodo:  Convertir Imagen a Array de Bytes
     ******************************************************************/
    
    public static byte[] convertImagetoByteArray(Image image){
        
        //Convertir image a bufferedimage
        bi = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        
        //Crear grafico
        Graphics2D grafico = bi.createGraphics();
        
        //Dibujar Imagen en el Grafico      
        grafico.drawImage(image, 0, 0, null);
        
        //Liberar espacio grafico
        grafico.dispose();
        
        ByteArrayOutputStream baos = null;

        try{
            baos = new ByteArrayOutputStream();
            ImageIO.write(bi,"jpg", baos);
        }   
        catch(IOException e){

            System.out.println(e);
        }
        finally{
           if(bi!=null)
              bi.flush();
        }

        return  (baos != null) ? baos.toByteArray() : new byte[0];
    }
    
    
    
    /*********************************************************
     *          Metodo: Convertir Array de Bytes a Imagen
     *********************************************************/
    
    public static Image convertByteArrayToImage(byte[] byarr){
        
        
        Image image = null;
        
        try {
            //Convertir de byte a InputStream
            is = new ByteArrayInputStream(byarr);
            
            //Convertir Input a Image
            image = ImageIO.read(is);

        } catch (IOException e) {
            System.out.println(e);
        }finally{
            try {
                is.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        
            
        return image;
    }
    
    /******************************************************************
     *        Escalar imagen al tamaño del componente 
     ******************************************************************/
    
    public static  void ScaleImageInComponent(java.io.File file,  javax.swing.JLabel c){
        try {
            bi = ImageIO.read(file);
            
            ImageIcon imgicon;
            if(bi.getHeight() > c.getHeight() && bi.getWidth() > c.getWidth()){
                imgicon = new ImageIcon(bi.getScaledInstance(c.getWidth(), c.getHeight(), Image.SCALE_SMOOTH));
            }else{
                imgicon = new ImageIcon(bi.getScaledInstance(bi.getWidth(), bi.getHeight(), Image.SCALE_SMOOTH));
            }
            
            
            c.setIcon(imgicon);
            
        } catch (IOException e) {
            System.out.println(e);
        }finally{
            bi.flush();
        }
    }
    
    
    public void ScaleImageInComponent(Image image,  javax.swing.JLabel c){
        
        try {
            //Leer Imagen
            bi = ImageIO.read(new ByteArrayInputStream(convertImagetoByteArray(image)));
            
            //Scalar
            ImageIcon imgicon = new ImageIcon(bi.getScaledInstance(c.getWidth(), c.getHeight(), Image.SCALE_DEFAULT));
            
            c.setIcon(imgicon);
            
        } catch (IOException e) {
            System.out.println(e);
        }finally{
            bi.flush();
        }
    }

}
