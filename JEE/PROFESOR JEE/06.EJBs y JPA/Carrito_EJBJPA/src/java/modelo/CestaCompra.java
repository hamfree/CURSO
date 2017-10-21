/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author jesus
 */
public class CestaCompra {

    private ArrayList<Articulo> lista;
    private float precioTotal;

    public CestaCompra() {
        lista = new ArrayList<Articulo>();
    }

    /**
     * @return the lista
     */
    public ArrayList<Articulo> getLista() {
        return lista;
    }

    public Articulo getArticuloLista(int i) {
        return lista.get(i);
    }
        
    public void anyadirArticulo(Articulo art) {
        lista.add(art);
        precioTotal += art.getPrecio();
    }

    /**
     * @return the precioTotal
     */
    public float getPrecioTotal() {
        return precioTotal;
    }


}
