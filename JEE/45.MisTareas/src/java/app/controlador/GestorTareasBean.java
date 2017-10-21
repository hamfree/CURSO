package app.controlador;

import app.modelo.TareasUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
public class GestorTareasBean implements GestorTareasBeanLocal {

    // Instanciamos un arraylist de TareasUsuario en el EJB ...
    // No se si es lo que quiere el profesor ...
    private ArrayList<TareasUsuario> tareas = new ArrayList<>();
    
    @PostActivate
    public void afterInit(){
        System.out.println(GestorTareasBean.class.getCanonicalName() + " instanciado por el contenedor...");
        System.out.println("Ref de 'tareas'->" + tareas.toString());
                
    }

    @Override
    public boolean agregarTarea(String tarea, String idSesion) {
        System.out.println("GestorTareasBean.agregarTarea(" + tarea + "," + idSesion + ") - INICIO");
        TareasUsuario tu;
        boolean resultado = false;
        if ((idSesion == null || idSesion.length() == 0) || (tarea == null || tarea.length() == 0)) {
            resultado = false;
        } else {
            if (!tareas.isEmpty()) {
                System.out.println("DBG: tareas no esta vacio, buscamos ..." );
                boolean esAgregado = false;
                for (TareasUsuario t : tareas) {
                    if (t.getIdSesion().equalsIgnoreCase(idSesion)) {
                        resultado = t.agregarTarea(tarea, idSesion);
                        esAgregado = resultado;
                    }
                }
                if (!esAgregado){
                    System.out.println("DBG: No se encontro el id de sesion, asi que lo añadimos a la lista...");
                    tu = new TareasUsuario(idSesion);
                    tu.agregarTarea(tarea, idSesion);
                    resultado = tareas.add(tu);
                }
            } else {
                tu = new TareasUsuario(idSesion);
                tu.agregarTarea(tarea, idSesion);
                resultado = tareas.add(tu);
            }
            
        }
        
        DBGmostrarContenidoListaTareas();
        
        System.out.println("GestorTareasBean.agregarTarea(" + tarea + "," + idSesion + ") - FIN");
        return resultado;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<String> devolverTareas(String idSesion) {
        System.out.println("GestorTareasBean.delvolverTareas(" + idSesion + ") - INICIO");

        List<String> alTareas = null;
        for (TareasUsuario t : tareas) {
            if (t.getIdSesion().equalsIgnoreCase(idSesion)) {
                alTareas = t.getTareas();
            }
        }
        System.out.println("GestorTareasBean.delvolverTareas(" + idSesion + ") - FIN");
        return alTareas;
    }
    
    private void DBGmostrarContenidoListaTareas(){
        StringBuilder sb = new StringBuilder();
        String ls = System.getProperty("line.separator");
        sb.append(ls);
        for (TareasUsuario t: tareas) {
            sb.append(t.toString()).append(ls);
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("DBG - Contenido de tareas: " + sb.toString());
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }
    
    @Remove
    public void finalizar(){
        System.out.println("Haciendo limpieza al eliminar el BEAN de sesion...");
        tareas = null;
    }
    
    @PreDestroy
    public void destruir(){
        System.out.println(GestorTareasBean.class.getCanonicalName() + " se va a destruir...");
    }
}
