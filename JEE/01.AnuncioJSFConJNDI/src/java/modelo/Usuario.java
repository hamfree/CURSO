package modelo;

import java.io.Serializable;

public class Usuario implements Serializable{
    private static final long serialVersionUID = -6996610651907813721L;
    private int user;
    private String password;
    private String nombre;
    private String apellido;

    public Usuario() {
    }

    public Usuario(int user, String password, String nombre, String apellido) {
        this.user = user;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
    }



    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the user
     */
    public int getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(int user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "user=" + user + ", password=" + password + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
    
    
}
