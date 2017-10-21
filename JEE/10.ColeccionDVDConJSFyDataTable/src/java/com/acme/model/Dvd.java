package com.acme.model;

import java.io.Serializable;
import java.util.Objects;

/* JavaBean de un DVD */
public class Dvd implements Serializable {

    private static final long serialVersionUID = 665933868633507082L;
    private String titulo;
    private String director;
        
    public Dvd(){}

    public Dvd(String titulo, String director) {
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
        final Dvd other = (Dvd) obj;
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
        return "Dvd{" + "titulo=" + titulo + ", director=" + director + '}';
    }
    
    
}
