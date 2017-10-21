package com.spring.bean;

import com.spring.idolo.ActuacionException;
import com.spring.idolo.Actuante;
import com.spring.idolo.Poema;

public class MultiPoeta implements Actuante {

    private Poema[] poemas;

    public MultiPoeta() {
    }

    public Poema[] getPoemas() {
        return poemas;
    }

    public void setPoemas(Poema[] poemas) {
        this.poemas = poemas;
    }

    @Override
    public void actuar() throws ActuacionException {
        for (Poema p : poemas){
            p.recitar();
        }
    }

    @Override
    public String toString() {
        return "MultiPoeta{" + "poemas=" + poemas + '}';
    }

}
