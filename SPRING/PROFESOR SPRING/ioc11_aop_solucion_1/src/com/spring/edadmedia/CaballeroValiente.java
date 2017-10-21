package com.spring.edadmedia;

public class CaballeroValiente
    implements Caballero
{
    private final Gesta gesta;

    public CaballeroValiente( Gesta gesta )
    {
        this.gesta = gesta;
    }

    @Override
    public void emprenderGesta()
    {
        gesta.embarcarse();
    }
}
