package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Una cesta tiene varios articulos
@Entity
public class CestaCompra implements Serializable {
    private static final long serialVersionUID = -6762158850800941913L;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_cesta;
    private float precioTotal;
    
    private List<Articulo> listaArticulos;

    public CestaCompra() {
        listaArticulos = new ArrayList<Articulo>();
    }

    public List<Articulo> getListaArticulos() {
        return listaArticulos;
    }
    
    public void anyadirArticulo(Articulo art) {
        listaArticulos.add(art);
        precioTotal += art.getPrecio();
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public int getId_cesta() {
        return id_cesta;
    }

}
