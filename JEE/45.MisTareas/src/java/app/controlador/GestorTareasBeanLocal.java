/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controlador;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author curso
 */
@Local
public interface GestorTareasBeanLocal {

    boolean agregarTarea(String tarea, String idSesion);

    List<String> devolverTareas(String parameter);

    public void finalizar();

    public void destruir();
    
    public void afterInit();

}
