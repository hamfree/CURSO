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
        System.out.println("Compra confirmada"+com);
        //CarritoDAO.dameObjetoDAO().insertarPedido(cesta, com);
        Comprador c = em.find(Comprador.class, com.getNombre());
        if (c == null) {
            System.out.println("----> comprador nulo"+c);
            em.persist(com);
            // com en estado Managed
            List<Articulo> lista = cesta.getLista();
            for (Articulo elem : lista) {
                em.persist(elem);
                com.getArticulos().add(elem);
            }

        } else {
            System.out.println("-------> comprador existente"+c);
            List<Articulo> lista = cesta.getLista();
            for (Articulo elem : lista) {
                em.persist(elem);
                com.getArticulos().add(elem);
                
            }
        }


    }

    public CestaCompra getCesta() {
        return cesta;
    }
}
