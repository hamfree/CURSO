/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author jesus
 */
@Entity
public class Comprador implements Serializable{
   @Id  private String nombre;
    private String domicilio;
    
    private List<Articulo> articulos = new ArrayList<Articulo>();   // clave secundaria
 
    public Comprador() {
    }

    public Comprador(String nombre, String domicilio) {
        this.nombre = nombre;
        this.domicilio = domicilio;
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
     * @return the domicilio
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @return the articulos
     */
    public List<Articulo> getArticulos() {
        return articulos;
    }

    /**
     * @param articulos the articulos to set
     */
    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    @Override
    public String toString() {
        return "Comprador{" + "nombre=" + nombre + ", domicilio=" + domicilio + '}';
    }
      
}
