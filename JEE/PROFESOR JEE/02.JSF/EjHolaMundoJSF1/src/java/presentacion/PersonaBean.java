/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author curso
 */
@ManagedBean(name="perBean")
@RequestScoped
public class PersonaBean {
private String nombre;
private String apellido;
    /**
     * Creates a new instance of PersonaBean
     */
    public PersonaBean() {
        System.out.println("Invocado constructor");
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        System.out.println("Inv. getNombre " + nombre);
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        System.out.println("Inv. setNombre " + nombre);
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        System.out.println("Inv. getApellido " + apellido);
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
         System.out.println("Inv. setApellido " + apellido);
        this.apellido = apellido;
    }
    
    public String saludar(){
        System.out.println("inv. saludar");
        return "saludo";
    }
}
