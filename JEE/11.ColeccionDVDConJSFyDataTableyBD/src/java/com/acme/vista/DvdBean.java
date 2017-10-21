package com.acme.vista;

import com.acme.controlador.Controlador;
import com.acme.utiles.C;
import java.io.Serializable;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Bean gestionado de un DVD (usado en agregar.xhtml y otras)
 *
 * @author Curso
 */
@ManagedBean(name = "beanDvd")
@RequestScoped
public class DvdBean implements Serializable {

    private static final long serialVersionUID = -5634730962959353310L;

    private String titulo;
    private String director;
    private String mensaje;

    public DvdBean() {
    }

    public DvdBean(String titulo, String director) {
        this.titulo = titulo;
        this.director = director;
        this.mensaje = "";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    // Accion
    public String buscar(String titulo, String director, int id_usuario) {
        C.dbg(this.getClass(), ".buscar(" + titulo + "," + director + "," + id_usuario + ") - INICIO");
        if (titulo.length() > 0 && director.length() > 0) {
            Controlador ctl = new Controlador();
            DvdBean dvdAEncontrar = new DvdBean(titulo, director);
            DvdBean dvdEncontrado = ctl.buscarDvdDeUsuario(dvdAEncontrar, id_usuario);
            if (dvdEncontrado != null) {
                setDirector(dvdEncontrado.getDirector());
                setTitulo(dvdEncontrado.getTitulo());
                setMensaje("DVD encontrado en su colección.");
            } else {
                setMensaje("No se encontro el DVD con el titulo '" + titulo + "' y el director '" + director + "'");
            }
        } else {
            setMensaje("Debe introducir obligatoriamente valores para 'Título' y 'Director'.");
        }
        C.dbg(this.getClass(), ".buscar() - FIN");
        return "agregar";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.titulo);
        hash = 79 * hash + Objects.hashCode(this.director);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DvdBean other = (DvdBean) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DvdBean{" + "titulo=" + titulo + ", director=" + director + '}';
    }

}
