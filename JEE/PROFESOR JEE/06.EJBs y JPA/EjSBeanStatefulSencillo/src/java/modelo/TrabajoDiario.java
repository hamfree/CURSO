/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TrabajoDiario implements Serializable{
    private List<String> tareas = new ArrayList<String>();

    public TrabajoDiario() {
    }

    public void addTarea(String descripcion){
        tareas.add(descripcion);
    }

    public List<String> getTareas() {
        return tareas;
    }

}
