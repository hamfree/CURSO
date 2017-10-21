package com.spring.idolo;

import java.util.Collection;

public class Banda
        implements Actuante {

    private Collection<Instrumento> instrumentos;

    @Override
    public void actuar() throws ActuacionException {
        for (Instrumento instrumento : instrumentos) {
            instrumento.play();
        }
    }

    public void setInstrumentos(Collection<Instrumento> instrumentos) {
        this.instrumentos = instrumentos;
    }

    public Collection<Instrumento> getInstrumentos() {
        return instrumentos;
    }

    public int getNumberOfInstruments() {
        return instrumentos == null ? 0 : instrumentos.size();
    }
}
