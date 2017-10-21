package com.spring.idolo;

public class MalabaristaPoeta
        extends Malabarista {

    private final Poema poema;

    public MalabaristaPoeta(Poema poema) {
        this.poema = poema;
    }

    public MalabaristaPoeta(int bolas, Poema poema) {
        super(bolas);
        this.poema = poema;
    }

    @Override
    public void actuar() throws ActuacionException {
        super.actuar();
        System.out.format("%nRecitando poesía...%n");
        poema.recitar();
    }
}
