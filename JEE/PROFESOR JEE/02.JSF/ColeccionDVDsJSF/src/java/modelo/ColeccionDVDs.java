/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

public class ColeccionDVDs {

    private ArrayList<DVD> lista;

    public ColeccionDVDs() {
        lista = new ArrayList<DVD>();
        lista.add(new DVD("La Diligencia", "John Ford"));
                        lista.add(new DVD("Viridiana", "Luis Buñiel"));

    }

    public void agregarDVD(DVD dvd) {
        lista.add(dvd);
    }

    /**
     * @return the lista
     */
    public List<DVD> getLista() {
        return lista;
    }

}
