package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comprador implements Serializable {
    private static final long serialVersionUID = -2554830658384574547L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String direccion;
    private List<Articulo> articulos;

    public Comprador() {
    }

    public Comprador(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }
    
    public void agregar(Articulo a){
        if (a != null){
            articulos.add(a);
        }
    }
    
    
    @Override
    public String toString() {
        return "Comprador{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + '}';
    }
    
}
