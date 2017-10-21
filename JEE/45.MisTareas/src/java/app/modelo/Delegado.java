package app.modelo;

import app.controlador.GestorTareasBeanLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Delegado {
    GestorTareasBeanLocal gestorTareasBean = lookupGestorTareasBeanLocal();
    private static Delegado delegado = new Delegado();
    
    
    private Delegado(){}

    public static Delegado getInstance(){
        return delegado;
    }
    
    public boolean agregarTarea(String tarea, String idSesion) {
        System.out.println("Delegado.agregarTarea(" + tarea + "," + idSesion + ") - INICIO");
        boolean resultado = false;

        dbg();
        resultado = gestorTareasBean.agregarTarea(tarea, idSesion);
        System.out.println("Delegado.agregarTarea(" + tarea + "," + idSesion + ") - FIN");
        return resultado;
    }

    public List<String> devolverTareas(String idSesion) {
        System.out.println("Delegado.devolverTareas(" + idSesion + ") - INICIO");
        dbg();
        List <String> tareas = gestorTareasBean.devolverTareas(idSesion);
        System.out.println("Delegado.devolverTareas(" + idSesion + ") - FIN");
        return tareas;
    }
    
    public void finalizar(){
        gestorTareasBean.finalizar();
    }
    

   
    
    
    private void dbg(){
        System.out.println("Delegado.devolverTareas() DBG: " + gestorTareasBean.toString());
    }

    private GestorTareasBeanLocal lookupGestorTareasBeanLocal() {
        try {
            Context c = new InitialContext();
            return (GestorTareasBeanLocal) c.lookup("java:global/MisTareas/GestorTareasBean!app.controlador.GestorTareasBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
