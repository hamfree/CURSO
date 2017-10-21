/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author student
 */
public class DVD implements Serializable{

    private String titulo;
    private String director;

    public DVD() {
    }

    public DVD(String titulo, String director) {
        this.titulo = titulo;
        this.director = director;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return  titulo + " - " + director ;
    }

   

}
