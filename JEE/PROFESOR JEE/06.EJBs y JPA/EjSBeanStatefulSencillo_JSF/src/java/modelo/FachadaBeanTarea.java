/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author oracle
 */
@Stateful
public class FachadaBeanTarea implements FachadaBeanTareaLocal {
     TrabajoDiario trabajoDiario = new TrabajoDiario();

    

    @Override
    public void anotarTarea( String descripcionTarea) {
       trabajoDiario.addTarea(descripcionTarea); 
    }

    @Override
    @Remove
    public void acabar() {
        System.out.println(trabajoDiario);
    }

    public TrabajoDiario getTrabajoDiario() {
        return trabajoDiario;
    }
    
}
