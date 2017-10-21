package com.spring.idolo;

public class ActuanteProxy
        implements Actuante {

    /*
    Implementa el patrón proxy
    */
    private Actuante actuante;

    public ActuanteProxy() {
    }

    public ActuanteProxy(Actuante actuante) {
        this.actuante = actuante;
    }

    @Override
    public void actuar() throws ActuacionException {
        System.out.println(this.getClass().getSimpleName() + ".actuar() - INICIO");
        long antes = System.nanoTime();

        actuante.actuar();

        long ahora = System.nanoTime();
        long nanosPorMili = 1_000_000;
        long total = (ahora - antes) / nanosPorMili;
        System.out.format("actuar() tarda %d milisegundos en ejecutarse%n", total);
        System.out.println(this.getClass().getSimpleName() + ".actuar() - FIN");
    }
}
