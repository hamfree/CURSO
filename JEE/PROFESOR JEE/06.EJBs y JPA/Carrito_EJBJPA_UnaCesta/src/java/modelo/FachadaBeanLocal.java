/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface FachadaBeanLocal {
            
    public void comprar(Articulo art);
    public void confirmar(Comprador com);
    public CestaCompra getCesta();
}
