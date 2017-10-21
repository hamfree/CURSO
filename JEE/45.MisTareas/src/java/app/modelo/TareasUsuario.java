package app.modelo;

import java.util.ArrayList;

public class TareasUsuario {
    private String idSesion;
    private ArrayList<String> listaTareas = null;

    public TareasUsuario(){
        listaTareas = new ArrayList<>();
    }
    
    public TareasUsuario(String idSesion) {
        this.idSesion = idSesion;
        this.listaTareas = new ArrayList<>();
    }

    public ArrayList<String> getTareas() {
        System.out.println("TareasUsuario.getTareas()");
        return listaTareas;
    }

    public void setTareas(ArrayList<String> tareas) {
        this.listaTareas = tareas;
    }
    
    public boolean agregarTarea(String laTarea,String idSesion){
        System.out.println("TareasUsuario.agregarTarea(" + laTarea + "," + idSesion + ") - INICIO");
        boolean resultado = false;
        if (laTarea != null && idSesion != null) {
            if ( getIdSesion().equalsIgnoreCase(idSesion)){
                resultado = listaTareas.add(laTarea);
                if (resultado == true) {
                    System.out.println("...Tarea agregada...");
                } else {
                    System.out.println("...Tarea no agregada...");
                }
            }
        } else {
            resultado = false;
        }
        System.out.println(resultado + "<--- TareasUsuario.agregarTarea(" + laTarea + "," + idSesion + ") - FIN");
        return resultado;
    }

    public String getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(String idSesion) {
        this.idSesion = idSesion;
    }

    @Override
    public String toString() {
        return "TareasUsuario{" + "idSesion=" + idSesion + ", listaTareas=" + listaTareas + '}';
    }
}
