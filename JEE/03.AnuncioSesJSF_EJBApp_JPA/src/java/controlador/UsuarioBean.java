package controlador;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.FachadaSBLocal;

import modelo.Usuario;

@ManagedBean(name = "usuBean")
@SessionScoped
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 880173922107126041L;

    @EJB
    private FachadaSBLocal ln;

    private int idUsuario;
    private String password;
    private String nombre;
    private String apellido;
    private String mensajesError;

    public String getMensajesError() {
        return mensajesError;
    }

    public UsuarioBean() {
    }

    public String registrar() {
        Usuario u = ln.dameUsuario(nombre, password);
        if (u == null) {
            mensajesError = "el nombre o el password son incorrectos";
            return "index";
        }
        nombre = u.getNombre();
        apellido = u.getApellido();
        idUsuario = u.getIdUser();
        return "anuncio";
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}
