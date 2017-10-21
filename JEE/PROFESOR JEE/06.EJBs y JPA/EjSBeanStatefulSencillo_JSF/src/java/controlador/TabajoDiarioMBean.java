/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

import modelo.FachadaBeanTareaLocal;

@ManagedBean(name = "trabajoBean")
@SessionScoped
public class TabajoDiarioMBean implements Serializable {
List<String> lista;
    private String textoTarea;


    FachadaBeanTareaLocal servicio = null;

    /**
     * Creates a new instance of TareaMBean
     */
    public TabajoDiarioMBean() {
        servicio = lookupFachadaBeanLocal();
        System.out.println("Constructor TareaMBean");

    }

    public String registrar() {
        System.out.println("registrar sb:" + servicio);
        servicio.anotarTarea(textoTarea);
        return "index";
    }

    public String acabar() {
        System.out.println("acabar servicio:" + servicio);
        
        lista = servicio.getTrabajoDiario().getTareas();
        servicio.acabar();
       
        return "fin";
    }

    public List<String> getLista() {
        
        return lista;
    }


    public String getTextoTarea() {
        return textoTarea;
    }

    public void setTextoTarea(String textoTarea) {
        this.textoTarea = textoTarea;
    }
    private FachadaBeanTareaLocal lookupFachadaBeanLocal() {
        FachadaBeanTareaLocal retorno = null;
        try {
            Context c = new InitialContext();
            retorno = (FachadaBeanTareaLocal) c.lookup("java:app/EjSBeanStatefulSencillo_JSF/FachadaBeanTarea");
        } catch (NamingException ne) {
            System.out.println("Horrrror en lookup" + ne);
        }
        return retorno;
    }
}
