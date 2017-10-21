/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrator
 */
@Stateful
public class FachadaBean implements FachadaBeanLocal {

    @PersistenceContext
    private EntityManager em;
    private CestaCompra cesta;

    public FachadaBean() {
        System.out.println("creado FachadaBean");
        cesta = new CestaCompra();
    }

    public void comprar(Articulo art) {
        System.out.println("comprado: " + art);
        cesta.anyadirArticulo(art);
    }

    public void confirmar(Comprador com) {
        System.out.println("Compra confirmada" + com);

        // Como solo tenenemos una cesta por comprador este if no tiene mucho sentido. 
        // Siempre va a ser nulo
        Comprador c = em.find(Comprador.class, com.getNombre());
        if (c == null) {
            System.out.println("----> comprador nulo");
               com.setCesta(cesta);
            List<Articulo> lista = cesta.getListaArticulos();
            for (Articulo elem : lista) {
                em.persist(elem);
                
            }
            em.persist(cesta);
             em.persist(com);
        } 

    }

    public CestaCompra getCesta() {
        return cesta;
    }
}
