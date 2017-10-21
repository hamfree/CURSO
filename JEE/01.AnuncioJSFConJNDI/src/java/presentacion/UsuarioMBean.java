package presentacion;

import controlador.Controlador;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Usuario;

@ManagedBean(name = "usuBean")
@SessionScoped
public class UsuarioMBean implements Serializable {

    private static final long serialVersionUID = -7625812417989990724L;

    private int usuario;
    private String password;
    private String nombre;
    private String apellido;
    private String msgError;

    public UsuarioMBean() {
    }

    // Accion
    public String registrar() {
        Controlador ctl = new Controlador();
        Usuario u = ctl.dameUsuario(nombre, password);

        if (u != null) {
            usuario = u.getUser();
            nombre = u.getNombre();
            apellido = u.getApellido();
            return "anuncio";
        }
        setMsgError("Error, el usuario no es válido");
        return null;
    }

    /**
     * @return the usuario
     */
    public int getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(int usuario) {
        this.usuario = usuario;
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

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }
}
