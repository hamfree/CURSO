package com.spring.idolo;

public class MultiPoeta2
    implements Actuante
{
    private final Poema[] poemas;

    public MultiPoeta2( Poema[] poemas )
    {
        this.poemas = poemas;
    }

    @Override
    public void actuar() throws ActuacionException
    {
        for ( Poema p : poemas ) {
            p.recitar();
        }
    }
}
