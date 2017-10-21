package com.acme.vista;

import com.acme.controlador.Controlador;
import com.acme.modelo.ColeccionDVD;
import com.acme.modelo.Dvd;
import com.acme.utiles.C;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Implementa el bean gestionado que controla la colección de DVDs tanto en
 * memoria como en la BBDD (a través de la clase Controlador). También gestiona
 * parte del flujo de pantallas JSF en la vista.
 *
 * @author curso
 */
@ManagedBean(name = "beanColeccionDVD")
@SessionScoped
public class ColeccionDVDBean implements Serializable {

    private static final long serialVersionUID = -6729011500137924188L;
    private ColeccionDVD col;

    public ColeccionDVDBean() {
        if (this.col == null) {
            this.col = new ColeccionDVD(new ArrayList<>());
        }
    }

    public ArrayList<Dvd> getLista() {
        return col.getLista();
    }

    public void setLista(ColeccionDVD colDvd) {
        this.col = colDvd;
    }

    public int dameTamaño() {
        if (this.getLista() != null) {
            return (this.getLista().size());
        } else {
            return -1;
        }

    }

    // Acción
    public String agregar(DvdBean dvd, int id_usuario) {
        C.dbg(this.getClass(), ".agregar(" + dvd + "," + id_usuario + ") - INICIO");
        String respuesta = null;

        // Aquí realizamos la inclusión del DVD en la coleccion de DVD.....
        if (dvd.getTitulo().length() > 0 && dvd.getDirector().length() > 0) {
            Dvd d = new Dvd(dvd.getTitulo(), dvd.getDirector());
            col.agregarDVD(d);

            // Persistimos el DVD en la BD
            Controlador ctl = new Controlador();
            if (ctl.crearDvd(dvd, id_usuario)) {
                respuesta = "lista";
            } else {
                dvd.setMensaje("Hubo algún problema para agregar el DVD " + dvd.toString());
                respuesta = "agregar";
            }
        } else {
            dvd.setMensaje("Ninguno de los campos puede quedar vacío.");
        }
        C.dbg(this.getClass(), ".agregar() - FIN");
        return respuesta;
    }

    // Accion
    public String listar(int id_usuario) {
        C.dbg(this.getClass(), ".listar(" + id_usuario + ") - INICIO");
        //Construimos la lista de DVD's consultando la BD
        Controlador ctl = new Controlador();
        setLista(ctl.listarDvds(id_usuario));
        C.dbg(this.getClass(), ".listar() - FIN");
        return "lista";
    }

    // Accion
    public String modificar(DvdBean dvd, int id_usuario) {
        C.dbg(this.getClass(), ".modificar(" + dvd + "," + id_usuario + ") - INICIO");
        String respuesta = null;
        if (dvd.getTitulo().length() > 0 && dvd.getDirector().length() > 0) {
            Controlador ctl = new Controlador();
            if (ctl.modificarDVD(dvd, id_usuario)) {
                respuesta = "lista";
            } else {
                dvd.setMensaje("Hubo un error. No se modificar el dvd actual.");
                respuesta = "agregar";
            }
        } else {
            dvd.setMensaje("Ninguno de los campos pueden quedar vacíos.");
        }
        C.dbg(this.getClass(), ".modificar() - FIN");
        return respuesta;
    }

    public String borrar(DvdBean dvd, int id_usuario) {
        C.dbg(this.getClass(), ".borrar(" + dvd + "," + id_usuario + ") - INICIO");
        String respuesta = null;
        if (dvd.getTitulo().length() > 0 && dvd.getDirector().length() > 0) {
            Controlador ctl = new Controlador();
            if (ctl.borrarDvd(dvd, id_usuario) == true) {
                // Hay que borrar el DVD de la colección de DVDs del usuario.
                Dvd unDvd = new Dvd(id_usuario, dvd.getTitulo(), dvd.getDirector());
                if (col.getLista().contains(unDvd)) {
                    for (Dvd d : col.getLista()) {
                        if (unDvd.equals(d)) {
                            col.getLista().remove(d);
                            break;
                        }
                    }
                }
                respuesta = "lista";
            } else {
                dvd.setMensaje("No se pudo borrar el DVD co titulo '" + dvd.getTitulo() + "' y director '" + dvd.getDirector() + "'.");
                respuesta = "agregar";
            }
        } else {
            dvd.setMensaje("Ninguno de los campos pueden quedar vacíos.");
        }
        C.dbg(this.getClass(), ".borrar() - FIN");
        return respuesta;
    }

    // Accion
    public String salir() {
        C.dbg(this.getClass(), ".salir() - INICIO");
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        C.dbg(this.getClass(), ".salir() - FIN");
        return "login";
    }

    @Override
    public String toString() {
        return "ColeccionDVDBean{" + "col=" + col + '}';
    }

}
