package com.spring.edadmedia;

public class RescatarDamaGesta
        implements Gesta {

    @Override
    public void embarcarse() {
        System.out.println(this.getClass().getSimpleName() + ".embarcarse() - INICIO");
        System.out.println("...rescatando a la dama en apuros...");
        System.out.println(this.getClass().getSimpleName() + ".embarcarse() - INICIO");
    }
}
