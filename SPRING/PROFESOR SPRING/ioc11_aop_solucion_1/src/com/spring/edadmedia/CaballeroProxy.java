package com.spring.edadmedia;

public class CaballeroProxy
    implements Caballero
{
    private final Juglar juglar;
    private final Caballero caballero;

    public CaballeroProxy( Juglar juglar, Caballero caballero )
    {
        this.juglar = juglar;
        this.caballero = caballero;
    }

    @Override
    public void emprenderGesta()
    {
        juglar.cantarAntesDeGesta();
        caballero.emprenderGesta();
        juglar.cantarDespuesDeGesta();
    }
}
