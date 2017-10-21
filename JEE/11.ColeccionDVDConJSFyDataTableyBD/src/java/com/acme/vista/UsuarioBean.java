package com.acme.vista;

import com.acme.controlador.Controlador;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.acme.modelo.Usuario;
import com.acme.utiles.C;
import java.io.Serializable;

/**
 * Bean gestionado de un Usuario
 *
 * @author hamfree
 */
@ManagedBean(name = "beanUsu")
@SessionScoped
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = -1949642455509824083L;

    private int usuario;
    private String password;
    private String nombre;
    private String apellido;
    private String msgError;

    public UsuarioBean() {
    }

    // Accion
    public String conectar() {
        C.dbg(this.getClass(), ".conectar() - INICIO");
        String pagRetorno = null;
        if (nombre == null || password == null) {
            setMsgError("Debe indicar los dos parámetros para continuar...");
            pagRetorno = "login";
        } else if (nombre.length() == 0 || password.length() == 0) {
            setMsgError("Debe indicar los dos parámetros para continuar...");
            pagRetorno = "login";
        } else {
            Controlador ctl = new Controlador();
            Usuario u = ctl.dameUsuario(nombre, password);

            if (u != null) {
                usuario = u.getUser();
                nombre = u.getNombre();
                apellido = u.getApellido();
                pagRetorno = "index";
            } else {
                setMsgError("Error, el usuario no es válido");
            }
        }

        C.dbg(this.getClass(), ".conectar() - FIN");
        return pagRetorno;
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

    @Override
    public String toString() {
        return "UsuarioBean{" + "usuario=" + usuario + ", password=" + password + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }

}
