package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

// Un comprador puede tener varias cestas
@Entity
public class Comprador implements Serializable {

    private static final long serialVersionUID = -5240982816750939398L;
    @Id
    private String nombre;
    private String domicilio;
    private List<CestaCompra> cestas = new ArrayList<CestaCompra>();

    public Comprador() {
    }

    public Comprador(String nombre, String domicilio) {
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

    public void addCesta(CestaCompra c) {
        cestas.add(c);
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

    @Override
    public String toString() {
        return "Comprador{" + "nombre=" + nombre + ", domicilio=" + domicilio + '}';
    }

    /**
     * @return the cestas
     */
    public List<CestaCompra> getCestas() {
        return cestas;
    }

    /**
     * @param cestas the cestas to set
     */
    public void setCestas(List<CestaCompra> cestas) {
        this.cestas = cestas;
    }

}
