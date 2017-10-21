package vista;

import controlador.GestorUsuarios;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Usuario;

/**
 *
 * @author curso
 */
@ManagedBean(name = "usuBean")
@SessionScoped
public class UsuarioBean implements Serializable {

    private String nombre;
    private String apellido;
    private String user;
    private String password;
    

    public UsuarioBean() {
//        System.out.println("Construyendo " + UsuarioBean.class.getName());
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
//        System.out.println("getNombre() = " + nombre);
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
//        System.out.println("setNombre(" + nombre + ")");
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
//        System.out.println("getApellido() = " + apellido );
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
//        System.out.println("setApellido(" + apellido + ")");
        this.apellido = apellido;
    }

    /**
     * @return the user
     */
    public String getUser() {
//        System.out.println("getUser() = " + user );
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
//        System.out.println("setUser(" + user + ")");
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
//        System.out.println("getPassword() = "  + password);
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
//        System.out.println("setPassword(" + password + ")");
        this.password = password;
    }

    public String validar() {
        String respuesta = null;
        GestorUsuarios gu = new GestorUsuarios();
        Usuario u = gu.dameUsuario(getUser(), getPassword());
        if (u == null) {
            System.out.println("validar() : usuario no encontrado. Devuelvo null...");
            return null;
        } else {
            System.out.println("validar() : usuario encontrado : " + u.toString() + ". Devulevo 'anuncio'");
            setNombre(u.getNombre());
            setApellido(u.getApellido());
            setUser(u.getUser());
            setPassword(u.getPassword());
            respuesta = "anuncio";
        }
        return respuesta;
    }

}
