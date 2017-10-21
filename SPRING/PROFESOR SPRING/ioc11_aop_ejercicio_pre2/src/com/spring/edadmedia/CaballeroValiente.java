package com.spring.edadmedia;

public class CaballeroValiente
    implements Caballero
{
    private final Gesta gesta;
    private final Juglar juglar;

    public CaballeroValiente( Gesta gesta, Juglar juglar )
    {
        this.gesta = gesta;
        this.juglar = juglar;
    }

    @Override
    public void emprenderGesta()
    {
        juglar.cantarAntesDeGesta();
        gesta.embarcarse();
        juglar.cantarDespuesDeGesta();
    }
}
