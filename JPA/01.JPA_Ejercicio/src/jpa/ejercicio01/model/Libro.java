package jpa.ejercicio01.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKS")
public class Libro implements Serializable {
    private static final long serialVersionUID = 967254323701440757L;
    
    @Id
    private String isbn;
    
    @Column(name = "TITLE")
    private String titulo;
    
    @Column(name = "EDITION")
    private String edicion;
    
    @Column(name = "COPYRIGHT")
    private String derechos;

    public Libro() {
    }

    public Libro(String isbn, String titulo, String edicion, String derechos) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.edicion = edicion;
        this.derechos = derechos;
    }

    public String getDerechos() {
        return derechos;
    }

    public void setDerechos(String derechos) {
        this.derechos = derechos;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", titulo=" + titulo + ", edicion=" + edicion + ", derechos=" + derechos + '}';
    }
    
    
    
}
