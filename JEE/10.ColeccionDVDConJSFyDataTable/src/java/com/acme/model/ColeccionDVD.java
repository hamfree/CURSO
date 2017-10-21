/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author curso
 */
public class ColeccionDVD implements Serializable {
    private static final long serialVersionUID = 3236566728249536819L;

    private ArrayList<Dvd> lista;

    public ColeccionDVD(){
    }
    public ColeccionDVD(ArrayList<Dvd> lista) {
        lista = new ArrayList<>();
        this.lista = lista;
    }

    public ArrayList<Dvd> getLista() {
        return lista;
    }

    public void agregarDVD(Dvd dvd) {
        lista.add(dvd);
    }

    public int dameTamaño() {
        if (this.getLista() != null) {
            System.out.println("dameTamaño() " + this.getLista().size());
            return (this.getLista().size());
        } else {
            System.out.println("La lista no tiene elementos...");
            return -1;
        }

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.lista);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ColeccionDVD other = (ColeccionDVD) obj;
        if (!Objects.equals(this.lista, other.lista)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ColeccionDVD{" + "lista=" + lista + '}';
    }

}
