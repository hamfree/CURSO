/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jesus
 */
@Entity
public class Articulo implements Serializable{
    @Id 
    private String idArticulo;
    private String nombre;
    private float precio;

    public Articulo() {
    }

    public Articulo(String idArticulo, String nombre, float precio) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Articulo(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
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
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Articulo{" + "idArticulo=" + idArticulo + ", nombre=" + nombre + ", precio=" + precio + '}';
    }


  
    
}
