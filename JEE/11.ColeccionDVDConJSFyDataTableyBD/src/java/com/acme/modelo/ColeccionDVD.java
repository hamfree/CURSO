package com.acme.modelo;

import com.acme.utiles.C;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Implementa la gestión de la colección de DVDs en memoria...
 *
 * @author hamfree
 */
public class ColeccionDVD implements Serializable {

    private static final long serialVersionUID = 3236566728249536819L;

    private ArrayList<Dvd> lista;

    public ColeccionDVD() {
        this.lista = new ArrayList<>();
    }

    public ColeccionDVD(ArrayList<Dvd> lista) {
        if (this.lista == null) {
            this.lista = new ArrayList<>();
        }
        if (lista != null) {
            if (!lista.isEmpty()) {
                for (Dvd d : lista) {
                    this.lista.add(d);
                }
            }
        }
    }

    public ArrayList<Dvd> getLista() {
        return lista;
    }

    public void agregarDVD(Dvd dvd) {
        C.dbg(this.getClass(), ".agregar(" + dvd + ") - INICIO");
        lista.add(dvd);
        C.dbg(this.getClass(), ".agregar() - FIN");
    }

    public int dameTamaño() {
        C.dbg(this.getClass(), ".dameTamaño() - INICIO");
        int tamaño = -1;
        if (this.getLista() != null) {
            tamaño = this.getLista().size();
        } 
        C.dbg(this.getClass(), ".dameTamaño() - FIN");
        return tamaño;
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
