package modelo;

import javax.ejb.Local;

@Local
public interface FachadaBeanLocal {

    void hacerCompra(CestaCompra cesta, Comprador comprador);

    void agregarArticulo(Articulo articulo);

    CestaCompra getCc();

    void limpiar();

}
