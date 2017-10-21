package com.acme.vista;

import java.io.Serializable;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/* Managed JavaBean de un DVD */
@ManagedBean(name = "beanDvd")
@RequestScoped
public class DvdBean implements Serializable {
    private static final long serialVersionUID = -5634730962959353310L;

    private String titulo;
    private String director;

    public DvdBean() {
        System.out.println("Instanciando DvdBean()");
    }

    public DvdBean(String titulo, String director) {
        this.titulo = titulo;
        this.director = director;
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
