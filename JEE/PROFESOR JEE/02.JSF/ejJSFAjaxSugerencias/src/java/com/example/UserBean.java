/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author tmcginn
 */
@ManagedBean(name = "user")
@RequestScoped
public class UserBean {

    private String nombre;

    
    String[] a = new String[30];
    public UserBean() {
        int i = 0;
        a[i] = "Anna";
        i++;
        a[i] = "Brittany";
        i++;
        a[i] = "Cinderella";
        i++;
        a[i] = "Diana";
        i++;
        a[i] = "Eva";
        i++;
        a[i] = "Fiona";
        i++;
        a[i] = "Gunda";
        i++;
        a[i] = "Hege";
        i++;
        a[i] = "Inga";
        i++;
        a[i] = "Johanna";
        i++;
        a[i] = "Kitty";
        i++;
        a[i] = "Linda";
        i++;
        a[i] = "Nina";
        i++;
        a[i] = "Ophelia";
        i++;
        a[i] = "Petunia";
        i++;
        a[i] = "Amanda";
        i++;
        a[i] = "Raquel";
        i++;
        a[i] = "Cindy";
        i++;
        a[i] = "Doris";
        i++;
        a[i] = "Eve";
        i++;
        a[i] = "Evita";
        i++;
        a[i] = "Sunniva";
        i++;
        a[i] = "Tove";
        i++;
        a[i] = "Unni";
        i++;
        a[i] = "Violet";
        i++;
        a[i] = "Liza";
        i++;
        a[i] = "Elizabeth";
        i++;
        a[i] = "Ellen";
        i++;
        a[i] = "Wenche";
        i++;
        a[i] = "Vicky";
        i++;
    }

    public String getNombre() {
         System.out.println("--->getNombre " + nombre);
        return nombre;
    }

    public void setNombre(String nombre) {
        System.out.println("--->setNombre " + nombre);
        this.nombre = nombre;
    }

    public String getPista() {
        //buscar sugerencias
       System.out.println("--->getPista " + nombre);
        String hint = null;
        String sugerencia = null;
        if (nombre != null && nombre.length() > 0) {
            hint = "";

            for (int i = 0; i < a.length; i++) {

                if (a[i].toLowerCase().startsWith(nombre.toLowerCase())) {
                    if (hint.equals("")) {
                        hint = a[i];
                    } else {
                        hint = hint + " , " + a[i];
                    }
                }
            }


            // Pon la salida a "No hay sugerencias" si no se encuentran
            // o a los valores correctos
            
            if (hint.equals("")) {
                sugerencia = "No hay sugerencias";
            } else {
                sugerencia = hint;
            }
        }
        return sugerencia;
    }
}
