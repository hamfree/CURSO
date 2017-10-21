package modelo;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class FachadaBean implements FachadaBeanLocal {

    @PersistenceContext(unitName = "CarritoDelaCompraPU")
    private EntityManager em;

    private CestaCompra cc;

    @Override
    public void hacerCompra(CestaCompra cesta, Comprador comprador) {
        Comprador comp = em.find(Comprador.class, comprador.getId());
        if (comp == null) { //No existe el comprador, lo persistimos ...
            em.persist(comprador);
            if (cesta.getLista() != null) {
                comprador.setArticulos(cesta.getLista());
                for (Articulo a : cesta.getLista()) {
                    em.persist(a);
                }
            }
        } else { // Ya existe el comprador, añadimos los articulos, los persistimos y después persistimos al comprador...
            if (cesta.getLista() != null) {
                comp.setArticulos(cesta.getLista());
                for (Articulo a : cesta.getLista()) {
                    em.persist(a);
                }
                em.persist(comprador);
            }
        }

    }

    @Override
    public void agregarArticulo(Articulo articulo
    ) {
        if (cc == null) {
            cc = new CestaCompra();
        }
        cc.agregar(articulo);
    }

    @Override
    public CestaCompra getCc() {
        return cc;
    }

    @Override
    public void limpiar() {
        if (cc != null) {
            cc.limpiar();
        }
    }

}
