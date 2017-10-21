/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq1;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author curso
 */
@ManagedBean
@RequestScoped
public class NombresBean implements Serializable {

    private static final long serialVersionUID = 9035845314542161855L;
    private String nombre;
    private String[] a;

    /**
     * Creates a new instance of NombresBean
     */
    public NombresBean() {
        a = new String[30];
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
        System.out.println("getNombre()" + this.nombre);
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        System.out.println("setNombre(" + nombre + ") -> " + this.nombre);
    }

    
    // Acción AJAX
    public String getPista() {
        System.out.println("--->getPista " + nombre);
        String hint = null;
        String sugerencia = null;
        if (nombre != null && nombre.length() > 0) {
            hint = "";

            for (String a1 : a) {
                if (a1.toLowerCase().startsWith(nombre.toLowerCase())) {
                    if (hint.equals("")) {
                        hint = a1;
                    } else {
                        hint = hint + " , " + a1;
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

    // Acción para cambiar de página, cuando se pulsa el botón "Enviar" en index.xhtml
    public String enviar() {
        System.out.println("enviar()");
        return "next";
    }
   

}
