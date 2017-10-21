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
        System.out.println(this.getClass().getSimpleName() + ".emprenderGesta() - INICIO");
        gesta.embarcarse();
        System.out.println(this.getClass().getSimpleName() + ".emprenderGesta() - FIN");
    }
}
