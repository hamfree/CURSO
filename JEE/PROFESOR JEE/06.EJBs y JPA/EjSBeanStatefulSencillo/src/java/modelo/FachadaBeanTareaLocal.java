/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.ejb.Local;

/**
 *
 * @author oracle
 */
@Local
public interface FachadaBeanTareaLocal {

      public void anotarTarea( String descripcionTarea) ;

    void acabar();
     public TrabajoDiario getTrabajoDiario() ;
}
