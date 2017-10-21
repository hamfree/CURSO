package modelo;

import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class FachadaBean implements FachadaBeanLocal {

    @PersistenceContext
    private EntityManager em;
    private CestaCompra cesta;

    public FachadaBean() {
        System.out.println("creado FachadaBean");
        cesta = new CestaCompra();
    }

    @Override
    public void comprar(Articulo art) {
        System.out.println("comprado: " + art);
        cesta.anyadirArticulo(art);
    }

    @Override
    public void confirmar(Comprador com) {
        System.out.println("Compra confirmada" + com);

        // Tenemos varias cestas por comprador. 
        Comprador c = em.find(Comprador.class, com.getNombre());
        if (c == null) {
            System.out.println("----> comprador nulo");
            com.addCesta(cesta);
            List<Articulo> lista = cesta.getListaArticulos();
            for (Articulo elem : lista) {
                em.persist(elem);
            }
            em.persist(cesta);
            em.persist(com);
        } else {
            System.out.println("comprador existente " + c);
            c.addCesta(cesta);
            List<Articulo> lista = cesta.getListaArticulos();
            for (Articulo elem : lista) {
                em.persist(elem);
            }
            em.persist(cesta);

        }

    }

    @Override
    public CestaCompra getCesta() {
        return cesta;
    }
}
