/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

public class ColeccionDVDs {

    private ArrayList<DVD> lista;

    public ColeccionDVDs() {
        lista = new ArrayList<DVD>();
    }

    public void agregarDVD(DVD dvd) {
        lista.add(dvd);
    }

    /**
     * @return the lista
     */
    public ArrayList<DVD> getLista() {
        return lista;
    }

}
