package com.spring.idolo;

public class Instrumentalista
        implements Actuante {

    private Instrumento instrumento;
    private String song;

    public String getSong() {
        return song;
    }

    @Override
    public void actuar() throws ActuacionException {
        System.out.format("Tocando %s: ", song);
        instrumento.play();
    }

    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    public void setSong(String song) {
        this.song = song;
    }
}
