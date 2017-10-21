/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jesus
 */
// Una cesta tiene varios articulos
@Entity
public class CestaCompra implements Serializable {
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
