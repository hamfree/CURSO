package com.acme.modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 * Un DVD como objeto del modelo de datos.
 */
public class Dvd implements Serializable {
    private static final long serialVersionUID = 4006321045942242314L;
    private int id_dvd;
    private String titulo;
    private String director;
        
    public Dvd(){}

    public Dvd(String titulo, String director) {
        this.titulo = titulo;
        this.director = director;
    }

    public Dvd(int id_dvd, String titulo, String director) {
        this.id_dvd = id_dvd;
        this.titulo = titulo;
        this.director = director;
    }
        
    public int getId_dvd() {
        return id_dvd;
    }

    public void setId_dvd(int id_dvd) {
        this.id_dvd = id_dvd;
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
        return "Dvd{" + "id_dvd=" + id_dvd + ", titulo=" + titulo + ", director=" + director + '}';
    }

}
