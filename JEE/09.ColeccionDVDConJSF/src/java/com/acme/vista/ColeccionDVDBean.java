/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.vista;

import com.acme.model.*;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author curso
 */
@ManagedBean(name = "beanColeccionDVD")
@SessionScoped
public class ColeccionDVDBean implements Serializable {
    private static final long serialVersionUID = -6729011500137924188L;
    private ColeccionDVD col;
    private ArrayList<DvdBean> colb = null;

    public ColeccionDVDBean() {
        col = new ColeccionDVD(new ArrayList<>());
    }



    public ArrayList<DvdBean> getLista() {
        colb = new ArrayList<>();
        for ( Dvd d: col.getLista()) {
            DvdBean db = new DvdBean(d.getTitulo(),d.getDirector());
            colb.add(db);
        }
        return colb;
    }


    public int dameTamaño() {
        if (this.getLista() != null) {
            return (this.getLista().size());
        } else {
            return -1;
        }

    }

    // Acción
    public String agregar(DvdBean dvd) {
        String respuesta = null;

        // Aquí realizamos la inclusión del DVD en la coleccion de DVD.....
        if (dvd.getTitulo().length() > 0 && dvd.getDirector().length() > 0) {
            Dvd d = new Dvd(dvd.getTitulo(), dvd.getDirector());
            col.agregarDVD(d);
            System.out.println(d.toString() + " añadido a la colección de DVDBean's ");
            respuesta = "lista";
        } else {
            System.out.println("Uno o varios de los parámetros del nuevo DVD es nulo... ");
        }
        return respuesta;
    }


    public String listar() {
        return "lista";
    }
}
