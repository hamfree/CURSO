/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author jesus
 */
// Un comprador sólo una cesta (para no complicar)
@Entity
public class Comprador implements Serializable{
   @Id  private String nombre;
    private String domicilio;
    private CestaCompra cesta = new CestaCompra();
 
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

    public CestaCompra getCesta() {
        return cesta;
    }

    public void setCesta(CestaCompra cesta) {
        this.cesta = cesta;
    }

    @Override
    public String toString() {
        return "Comprador{" + "nombre=" + nombre + ", domicilio=" + domicilio + '}';
    }
      
}
