package presentacionJSF;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.GestorColeccion;
import modelo.Usuario;


@ManagedBean(name = "usuBean")
@SessionScoped
public class UsuarioMBean {

    private String usuario;
    private String password;

    private String nombre;
    private String apellido;

    public UsuarioMBean() {
        System.out.println("---> creado UsuarioMBean");

    }

    public String registrar() {
        System.out.println("---> registrar");
         GestorColeccion ln = GestorColeccion.dameInstancia();
        Usuario u = ln.dameUsuario(usuario, password);
        if (u == null){
            return "index";
        }
        nombre = u.getNombre();
        apellido = u.getApellido();
        return "nuevoDVD";
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        System.out.println("--->getUsuario "+usuario);
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        System.out.println("--->setUsuario " + usuario);
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        System.out.println("--->getPassword ");
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {

        System.out.println("--->setPassword " + password);
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

}
