/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

public class Contacto {
    //Atributos
    private int id;
    private byte foto;
    private String nombre;
    private String apellido;
    private String company;
    private String posicion;
    private String email;
    private String telefono;
    private String notas;
    
    //Numero de contactos;
    public static int no_contactos;
    
    //Constructor vacio
    public Contacto(){
        ++Contacto.no_contactos;
    }
    //Constructor con campos obligatorio sin id
    public Contacto( String nombre, String apellido, String tel){
        
        this.nombre   = nombre;
        this.apellido = apellido;
        this.telefono = tel;
        ++Contacto.no_contactos;
        
    }
    
    //Contructor sin imagen y id
    public Contacto( int id, String nombre, String apellido, String company, String posicion, String email, String tel, String notas){
        
        this.nombre   = nombre;
        this.apellido = apellido;
        this.company  = company;
        this.posicion = posicion;
        this.email    = email;
        this.telefono = tel;
        this.notas    = notas;
        ++Contacto.no_contactos;
    }
    
    //Constructor completo
    public Contacto( int id, byte foto, String nombre, String apellido, String company, String posicion, String email, String tel, String notas){
        
        this.id       = id;
        this.foto     = foto;
        this.nombre   = nombre;
        this.apellido = apellido;
        this.company  = company;
        this.posicion = posicion;
        this.email    = email;
        this.telefono = tel;
        this.notas    = notas;
        ++Contacto.no_contactos;
    }
    
    
    // Encapsulamiento

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getFoto() {
        return foto;
    }

    public void setFoto(byte foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
    
    //Funcionalidades: 
    //Sobreescribiendo metodo 'toString' heredado de la clase Object
    //Descripcion de la clase
    @Override
    public String toString(){
        
        return "Contacto\n" +
                id        + "\t" + 
                nombre    + "\t" + 
                apellido  + "\t" +
                company   + "\t" +    
                posicion  + "\t" +
                email     + "\t" +
                telefono  + "\t" +
                notas;
    }

    
}
