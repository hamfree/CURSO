package modelo;

import javax.ejb.Local;

@Local
public interface FachadaBeanLocal {
            
    public void comprar(Articulo art);
    public void confirmar(Comprador com);
    public CestaCompra getCesta();
}
