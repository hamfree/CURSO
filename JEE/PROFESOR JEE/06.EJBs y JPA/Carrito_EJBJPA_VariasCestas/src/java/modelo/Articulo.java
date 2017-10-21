package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Articulo implements Serializable{
    private static final long serialVersionUID = 4761264356273178002L;
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
